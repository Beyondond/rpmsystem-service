package cn.com.dhc.rpmsystem.system.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouyongzhou
 * @description 配置信息
 * @date 2019/8/5
 */
@Setter
@Getter
public class RpmSetting {
    /**
     * 主键id
     */
    private int id;
    /**
     * 配置名称
     */
    private String settingName;
    /**
     * 所属技能
     */
    private String skill;
    /**
     * 配置内容
     */
    private String settingValue;
    /**
     * 是否启用 1启用2未启用
     */
    private int enableStatus;

}
