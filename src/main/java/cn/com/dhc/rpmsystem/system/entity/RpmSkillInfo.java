package cn.com.dhc.rpmsystem.system.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouyongzhou
 * @description 技能信息
 * @date 2019/8/5
 */
@Getter
@Setter
public class RpmSkillInfo {
    /**
     * 主键id
     */
    private int id;
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 技能描述
     */
    private String skillDesc;
}
