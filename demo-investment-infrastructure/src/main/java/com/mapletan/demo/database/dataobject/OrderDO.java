package com.mapletan.demo.database.dataobject;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("order_table")
public class OrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "order_id", type = IdType.INPUT)
    private String orderId;

    private String portfolioId;

    private String accountId;

    private Integer orderState;

    private String creator;

    private String modifier;

    private Date createTime;

    private Date updateTime;


}
