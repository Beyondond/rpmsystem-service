package cn.com.dhc.rpmsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类PageBean
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
@ApiModel(description= "分页返回数据实体类")
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = -7877845715124492334L;


    @ApiModelProperty(value = "当前页数")
    private int page;

    @ApiModelProperty(value = "总记录数")
    private int totalCount;

    @ApiModelProperty(value = "总页数")
    private int totalPage;

    @ApiModelProperty(value = "每页显示的记录数")
    private int limit;

    @ApiModelProperty(value = "每页显示数据记录的集合")
    private List<T> list;

}
