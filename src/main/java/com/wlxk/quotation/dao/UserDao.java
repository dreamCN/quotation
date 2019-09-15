package com.wlxk.quotation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlxk.quotation.model.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<UserDO> {

}
