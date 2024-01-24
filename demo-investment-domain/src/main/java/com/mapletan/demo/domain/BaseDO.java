package com.mapletan.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/

@Data
public class BaseDO {

    private Date createTime;

    private Date updateTime;
}
