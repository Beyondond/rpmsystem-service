package cn.com.dhc.rpmsystem.system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhouyongzhou
 * @description 人员角色
 * @date 2019/8/5
 */
@Setter
@Getter
public class RpmRole {
    /**
     * 主键id
     */
    private int id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 技能
     */
    private String skills;
    /**
     * 创建人
     */
    private String createNumUid;
    /**
     * 基本信息列展示
     */
    private String columName;
    /**
     * 创建时间
     */
    private Date created_time;
}
