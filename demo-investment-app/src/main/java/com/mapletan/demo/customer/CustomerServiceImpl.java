package com.mapletan.demo.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.mapletan.demo.api.CustomerServiceI;
import com.mapletan.demo.dto.command.customer.CustomerAddCmd;
import com.mapletan.demo.dto.query.customer.CustomerListByNameQry;
import com.mapletan.demo.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import com.mapletan.demo.customer.executor.CustomerAddCmdExe;
import com.mapletan.demo.customer.executor.query.CustomerListByNameQryExe;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}