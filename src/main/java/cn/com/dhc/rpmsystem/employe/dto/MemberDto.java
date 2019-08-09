package cn.com.dhc.rpmsystem.employe.dto;

import cn.com.dhc.rpmsystem.entity.ReqPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * @author zss
 * @date 2019-08-07
 */
@Getter
@Setter
@ApiModel(description= "分页搜索查询数据实体类")
public class MemberDto extends ReqPage {


    /**
     * 检索姓名
     */
    @ApiModelProperty(value = "检索姓名")
    private String searchName;

}
