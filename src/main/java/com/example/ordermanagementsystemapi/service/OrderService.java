package com.example.ordermanagementsystemapi.service;

import com.example.ordermanagementsystemapi.exception.InvalidRequestException;
import com.example.ordermanagementsystemapi.model.dao.Customer;
import com.example.ordermanagementsystemapi.model.dao.Order;
import com.example.ordermanagementsystemapi.model.dao.OrderLine;
import com.example.ordermanagementsystemapi.model.dao.Product;
import com.example.ordermanagementsystemapi.model.dto.request.CreateOrderRequest;
import com.example.ordermanagementsystemapi.model.dto.request.SearchOrderRequest;
import com.example.ordermanagementsystemapi.model.dto.response.OrderResponse;
import com.example.ordermanagementsystemapi.model.dto.response.ProductResponse;
import com.example.ordermanagementsystemapi.repository.OrderRepository;
import com.example.ordermanagementsystemapi.util.CustomerMapper;
import com.example.ordermanagementsystemapi.util.OrderLineMapper;
import com.example.ordermanagementsystemapi.util.OrderMapper;
import com.example.ordermanagementsystemapi.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;
    private final OrderLineMapper orderLineMapper;
    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;

    public void createOrder(CreateOrderRequest createOrderRequest) throws Exception {
        List<Long> nonExistentProducts = createOrderRequest.getOrderLine().stream()
                .map(OrderLine::getProduct)
                .map(Product::getSkuCode)
                .filter(skuCode -> !productService.doesProductExist(skuCode))
                .collect(Collectors.toList());
        Customer customer = customerService.getCustomerByEmail(createOrderRequest.getCustomerEmail());
        if (!nonExistentProducts.isEmpty()) {
            throw new InvalidRequestException("The following products do not exist: " + nonExistentProducts);
        }
        if (customer == null) {
            throw new InvalidRequestException("The customer does not exist.");
        }
        Order order = Order.builder()
                .orderLines(createOrderRequest.getOrderLine())
                .customer(customer)
                .build();
        for (OrderLine orderLine : createOrderRequest.getOrderLine()) {
            orderLine.setOrder(order);
        }
        orderRepository.save(order);
    }

    public List<OrderResponse> searchOrder(SearchOrderRequest searchOrderRequest) {
        List<Order> orders = orderRepository.customSearch(
                searchOrderRequest.getCustomerEmail(),
                searchOrderRequest.getProductSkuCode(),
                searchOrderRequest.getDate()
        );
        return orders.stream()
                .map(order -> {
                    List<Product> products = order.getOrderLines()
                            .stream().map(orderLine -> orderLine.getProduct()).collect(Collectors.toList());
                    OrderResponse orderResponse = orderMapper.toOrderResponse(order);
                    orderResponse.setOrderLineResponse(orderLineMapper.toOrderLineResponseList(order.getOrderLines()));
                    orderResponse.setCustomerResponse(customerMapper.toCustomerResponse(order.getCustomer()));
                    orderResponse.getOrderLineResponse().forEach(orderLineResponse -> {
                        for (Product product : products) {
                            ProductResponse productResponse = productMapper.toProductResponse(product);
                            orderLineResponse.setProductResponse(productResponse);
                        }
                    });
                    return orderResponse;
                })
                .collect(Collectors.toList());
    }
}

