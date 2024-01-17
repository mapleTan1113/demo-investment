package com.mapletan.demo.account;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.mapletan.demo.api.AccountServiceI;
import com.mapletan.demo.dto.command.account.AccountCapitalVerifyCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Service
@CatchAndLog
@Slf4j
public class AccountServiceImpl implements AccountServiceI {
    @Override
    public boolean capitalVerify(AccountCapitalVerifyCmd cmd) {
        log.info("capitalVerify success");
        return true;
    }
}
