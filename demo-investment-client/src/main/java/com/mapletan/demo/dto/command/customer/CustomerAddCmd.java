package com.mapletan.demo.dto.command.customer;

import com.alibaba.cola.dto.Command;
import com.mapletan.demo.dto.data.CustomerDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerAddCmd extends Command {

    @NotNull
    private CustomerDTO customerDTO;

}
