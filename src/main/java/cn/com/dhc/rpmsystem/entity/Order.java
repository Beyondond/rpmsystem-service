package cn.com.dhc.rpmsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 查询排序的封装
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
@ApiModel(description= "排序实体类")
public class Order implements Serializable {
    private static final long serialVersionUID = 749118788009979542L;

    /**
     * 排序方式
     */
    @ApiModelProperty(value = "排序方式")
    private String orderType;

    @ApiModelProperty(value = "排序字段")
    private String orderField;

    public Order (String orderType, String orderField) {
        this.orderType = orderType;
        this.orderField = orderField;
    }

    /**
     * 默认为DESC(降序)排序
     * @param orderField
     */
    public Order(String orderField) {
        this.orderField = orderField;
        this.orderType = "desc";
    }
}
