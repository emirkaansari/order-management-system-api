package com.example.ordermanagementsystemapi.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerRequest {
    @NotBlank(message = "name can't be blank.")
    private String fullName;
    @Email
    @NotBlank(message = "email can't be blank.")
    private String email;
    @NotBlank(message = "telephone can't be blank.")
    private String telephone;
}