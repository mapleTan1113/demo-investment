package com.mapletan.demo.api;

import com.mapletan.demo.dto.command.account.AccountVerifyCmd;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
public interface AccountServiceI {
    boolean capitalVerify(AccountVerifyCmd cmd);
}