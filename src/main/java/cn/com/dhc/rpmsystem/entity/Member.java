package cn.com.dhc.rpmsystem.entity;

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
public class Member implements Serializable {
    private static final long serialVersionUID = -4999243192619000016L;
    /**
     * 员工工号  主键id
     */
    private int numUid;
    /**
     * 员工姓名
     */
    private String memName;
    /**
     * 员工性别(1男2女)
     */
    private  int memGender;
    /**
     * 级别
     */
    private String memLevel;
    /**
     * 职位
     */
    private String positon;
    /**
     * 学历
     */
    private String education;
    /**
     * 专业
     */
    private String major;
    /**
     * 英语等级
     */
    private String engLevel;
    /**
     * 毕业学校
     */
    private String graSchool;
    /**
     * 毕业时间
     */
    private Date graTime;
    /**
     * 入职时间
     */
    private Date initPositionTime;
    /**
     * 入项时间
     */
    private Date initProjectTime;
    /**
     * 技术类型
     */
    private String technologyType;
    /**
     * 平台系统
     */
    private String platformSystem;
    /**
     * 电话号码（唯一）
     */
    private String phoneNum;
    /**
     * 身份证号（唯一）
     */
    private String identityId;
    /**
     * 个人邮箱（唯一）
     */
    private String mailbox;
    /**
     * 技术年限
     */
    private String technologyYears;
    /**
     * 是否有华为经验 （1有0没有）
     */
    private int hwExp;
    /**
     * 过往公司
     */
    private String pastCorp;
    /**
     * 项目经验
     */
    private String projectExp;
    /**
     * 录入人员工号
     */
    private int inputNumUid;
    /**
     * 录入时间
     */
    private Date inputTime;
    /**
     * 是否在职（1在职 0离职）
     */
    private int positionStatus;
    /**
     * 数据状态（1正常0删除）
     */
    private int status;
    /**
     * 创建时间
     */
    private Timestamp createdTime;
    /**
     * 删除时间
     */
    private Timestamp  deleteTime;


}

