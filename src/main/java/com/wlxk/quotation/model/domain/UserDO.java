package com.wlxk.quotation.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@Data
@TableName("user")
public class UserDO {
    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
}
