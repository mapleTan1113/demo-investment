package com.mapletan.demo.domain.customer.gateway;

import com.mapletan.demo.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
