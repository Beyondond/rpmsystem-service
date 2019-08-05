package cn.com.dhc.rpmsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouyongzhou
 * @description 员工基本信息
 * @date 2019/8/5
 */
public class Member implements Serializable {
    private static final long serialVersionUID = -4999243192619000016L;
    /**
     * 员工工号  主键id
     */
    private int num_uid;
    /**
     * 员工姓名
     */
    private String mem_name;
    /**
     * 员工性别(1男2女)
     */
    private  int mem_gender;
    /**
     * 级别
     */
    private String mem_level;
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
    private String eng_level;
    /**
     * 毕业学校
     */
    private String gra_school;
    /**
     * 毕业时间
     */
    private String gra_time;
    /**
     * 入职时间
     */
    private Date init_position_time;
    /**
     * 入项时间
     */
    private Date init_project_time;
    /**
     * 技术类型
     */
    private String technology_type;
    /**
     * 平台系统
     */
    private String platform_system;
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
    private String technology_years;
    /**
     * 是否有华为经验 （1有0没有）
     */
    private int hw_exp;
    /**
     * 过往公司
     */
    private String past_crop;
    /**
     * 项目经验
     */
    private String project_exp;
    /**
     * 录入人员工号
     */
    private int input_num_uid;
    /**
     * 录入时间
     */
    private Date input_time;
    /**
     * 是否在职（1在职 0离职）
     */
    private int position_status;
    /**
     * 数据状态（1正常0删除）
     */
    private int status;
    /**
     * 创建时间
     */
    private Date created_time;
    /**
     * 删除时间
     */
    private Date delete_time;


    public int getNum_uid() {
        return num_uid;
    }

    public void setNum_uid(int num_uid) {
        this.num_uid = num_uid;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public int getMem_gender() {
        return mem_gender;
    }

    public void setMem_gender(int mem_gender) {
        this.mem_gender = mem_gender;
    }

    public String getMem_level() {
        return mem_level;
    }

    public void setMem_level(String mem_level) {
        this.mem_level = mem_level;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEng_level() {
        return eng_level;
    }

    public void setEng_level(String eng_level) {
        this.eng_level = eng_level;
    }

    public String getGra_school() {
        return gra_school;
    }

    public void setGra_school(String gra_school) {
        this.gra_school = gra_school;
    }

    public String getGra_time() {
        return gra_time;
    }

    public void setGra_time(String gra_time) {
        this.gra_time = gra_time;
    }

    public Date getInit_position_time() {
        return init_position_time;
    }

    public void setInit_position_time(Date init_position_time) {
        this.init_position_time = init_position_time;
    }

    public Date getInit_project_time() {
        return init_project_time;
    }

    public void setInit_project_time(Date init_project_time) {
        this.init_project_time = init_project_time;
    }

    public String getTechnology_type() {
        return technology_type;
    }

    public void setTechnology_type(String technology_type) {
        this.technology_type = technology_type;
    }

    public String getPlatform_system() {
        return platform_system;
    }

    public void setPlatform_system(String platform_system) {
        this.platform_system = platform_system;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getTechnology_years() {
        return technology_years;
    }

    public void setTechnology_years(String technology_years) {
        this.technology_years = technology_years;
    }

    public int getHw_exp() {
        return hw_exp;
    }

    public void setHw_exp(int hw_exp) {
        this.hw_exp = hw_exp;
    }

    public String getPast_crop() {
        return past_crop;
    }

    public void setPast_crop(String past_crop) {
        this.past_crop = past_crop;
    }

    public String getProject_exp() {
        return project_exp;
    }

    public void setProject_exp(String project_exp) {
        this.project_exp = project_exp;
    }

    public int getInput_num_uid() {
        return input_num_uid;
    }

    public void setInput_num_uid(int input_num_uid) {
        this.input_num_uid = input_num_uid;
    }

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }

    public int getPosition_status() {
        return position_status;
    }

    public void setPosition_status(int position_status) {
        this.position_status = position_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }
}

