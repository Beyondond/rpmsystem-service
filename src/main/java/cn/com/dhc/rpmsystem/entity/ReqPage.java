package cn.com.dhc.rpmsystem.entity;

import cn.com.dhc.rpmsystem.common.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
@ApiModel(description= "公共分页查询数据封装实体类")
public class ReqPage implements Serializable {
    private static final long serialVersionUID = 434634798496091234L;

    @ApiModelProperty(value = "查询当前页数")
    private Integer currPage = CommonConstant.DEFAULT_CURRENTPAGE;

    @ApiModelProperty(value = "每页显示条数")
    private Integer pageSize = CommonConstant.DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "排序条件")
    private Order order;

}
