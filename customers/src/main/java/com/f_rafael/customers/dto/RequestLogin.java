package com.f_rafael.customers.dto;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
