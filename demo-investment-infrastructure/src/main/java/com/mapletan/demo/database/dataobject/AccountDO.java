package com.mapletan.demo.database.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mapletan
 * @since 2024-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("account")
public class AccountDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountId;

    private BigDecimal totalCapital;

    private BigDecimal availableCapital;

    private BigDecimal frozenCapital;

    private BigDecimal settleCapital;

    private Date createTime;

    private Date updateTime;

}
