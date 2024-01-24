package com.mapletan.demo.database;

import com.mapletan.demo.database.dataobject.OrderDetailDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mapletan
 * @since 2024-01-24
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetailDO> {
//    boolean saveBatchCustom(List<OrderDetailDO> orderDetailDOList);

}
