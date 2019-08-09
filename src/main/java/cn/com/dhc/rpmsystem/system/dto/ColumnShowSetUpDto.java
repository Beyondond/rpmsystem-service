package cn.com.dhc.rpmsystem.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zss
 * @date 2019-08-08
 */
@Getter
@Setter
@ApiModel(description= "展示列设置封装实体类")
public class ColumnShowSetUpDto implements Serializable {
    private static final long serialVersionUID = 1403145683998099240L;

    @ApiModelProperty(value = "员工工号")
    private Integer numUid;

    @ApiModelProperty(value = "设置要展示的列")
    private List<Integer> columnShow;
}
