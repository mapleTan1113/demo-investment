package com.mapletan.demo.database.gatewayimpl;

import com.mapletan.demo.database.AccountMapper;
import com.mapletan.demo.domain.account.Account;
import com.mapletan.demo.domain.account.gateway.AccountGateway;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/26
 **/
public class AccountGatewayImpl implements AccountGateway {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public void freezeAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }
}
