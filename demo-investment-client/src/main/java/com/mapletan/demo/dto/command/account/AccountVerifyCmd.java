package com.mapletan.demo.dto.command.account;

import com.mapletan.demo.dto.data.AccountDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
@NoArgsConstructor
public class AccountVerifyCmd {

    private AccountDTO accountDTO;
}
