package com.mapletan.demo.dto.command.customer;

import com.mapletan.demo.dto.data.CustomerDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerAddCmd{

    @NotNull
    private CustomerDTO customerDTO;

}
