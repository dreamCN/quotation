package com.wlxk.quotation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlxk.quotation.model.domain.StockDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@Mapper
@Repository
public interface StockDao extends BaseMapper<StockDO> {

    @Select("select * from stock where code = #{code}")
    StockDO selectByCode(@Param("code") String code);

}
