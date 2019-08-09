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
@ApiModel(description= "展示列设置弹框返回数据封装实体类")
public class ColumnShowDto implements Serializable {
    private static final long serialVersionUID = 2470326299471120979L;

    @ApiModelProperty(value = "全部列")
    private List<Inside> columnAll;

    @ApiModelProperty(value = "要展示的列")
    private List<Integer> columnShow;

    @Getter
    @Setter
    public class Inside {

        @ApiModelProperty(value = "标识")
        private Integer id;

        @ApiModelProperty(value = "标识对应的属性文档注释")
        private String name;

    }
}
