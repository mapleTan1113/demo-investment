package com.mapletan.demo.api;

import com.mapletan.demo.dto.command.account.AccountCapitalUpdateCmd;
import com.mapletan.demo.dto.command.account.AccountCapitalVerifyCmd;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
public interface AccountServiceI {
    boolean capitalVerify(AccountCapitalVerifyCmd cmd);

    void updateCapital(AccountCapitalUpdateCmd cmd);
}
