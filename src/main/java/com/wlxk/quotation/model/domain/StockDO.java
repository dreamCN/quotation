package com.wlxk.quotation.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@Data
@TableName("stock")
public class StockDO {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
}
