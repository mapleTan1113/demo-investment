package com.mapletan.demo.dto.command.account;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.extension.BizScenario;
import com.mapletan.demo.dto.data.AccountDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class AccountCapitalVerifyCmd extends Command {

    private AccountDTO accountDTO;

//    private String biz;
//
//    private BizScenario bizScenario;
}
