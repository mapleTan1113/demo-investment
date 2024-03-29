package com.mapletan.demo.dto.query.order;

import com.alibaba.cola.dto.Query;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Data
public class OrderByIdQry extends Query {

    @NotNull
    private String orderId;
}
