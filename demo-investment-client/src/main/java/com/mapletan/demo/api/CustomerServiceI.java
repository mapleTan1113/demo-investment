package com.mapletan.demo.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.mapletan.demo.dto.command.customer.CustomerAddCmd;
import com.mapletan.demo.dto.query.customer.CustomerListByNameQry;
import com.mapletan.demo.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
