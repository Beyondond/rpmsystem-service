package cn.com.dhc.rpmsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author zhouyongzhou
 * @description 员工基本信息
 * @date 2019/8/5
 */
@Getter
@Setter
@ApiModel(description= "员工实体类")
public class Member implements Serializable {
    private static final long serialVersionUID = -4999243192619000016L;

    @ApiModelProperty(value = "员工工号  主键id")
    private int numUid;

    @ApiModelProperty(value = "员工姓名")
    private String memName;

    @ApiModelProperty(value = "员工性别(1男2女)")
    private  int memGender;

    @ApiModelProperty(value = "级别")
    private String memLevel;

    @ApiModelProperty(value = "职位")
    private String positon;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "英语等级")
    private String engLevel;

    @ApiModelProperty(value = "毕业学校")
    private String graSchool;

    @ApiModelProperty(value = "毕业时间")
    private Date graTime;

    @ApiModelProperty(value = "入职时间")
    private Date initPositionTime;

    @ApiModelProperty(value = "入项时间")
    private Date initProjectTime;

    @ApiModelProperty(value = "技术类型")
    private String technologyType;

    @ApiModelProperty(value = "平台系统")
    private String platformSystem;

    @ApiModelProperty(value = "电话号码（唯一）")
    private String phoneNum;

    @ApiModelProperty(value = "身份证号（唯一）")
    private String identityId;

    @ApiModelProperty(value = "个人邮箱（唯一）")
    private String mailbox;

    @ApiModelProperty(value = "技术年限")
    private String technologyYears;

    @ApiModelProperty(value = "是否有华为经验 （1有0没有）")
    private int hwExp;

    @ApiModelProperty(value = "过往公司")
    private String pastCorp;

    @ApiModelProperty(value = "项目经验")
    private String projectExp;

    @ApiModelProperty(value = "录入人员工号")
    private int inputNumUid;

    @ApiModelProperty(value = "录入时间")
    private Date inputTime;

    @ApiModelProperty(value = "是否在职（1在职 0离职）")
    private int positionStatus;

    @ApiModelProperty(value = "数据状态（1正常0删除）")
    private int status;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createdTime;

    @ApiModelProperty(value = "删除时间")
    private Timestamp  deleteTime;


}

