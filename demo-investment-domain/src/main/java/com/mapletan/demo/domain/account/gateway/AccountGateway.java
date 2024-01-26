package com.mapletan.demo.domain.account.gateway;

import com.mapletan.demo.domain.account.Account;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/26
 **/
public interface AccountGateway {
    void freezeAccount(Account account);

    void updateAccount(Account account);
}
