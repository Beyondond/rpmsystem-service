package cn.com.dhc.rpmsystem.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description 系统配置实体对象
 * @Date 2019/8/7 14:51
 * @Created by Sunli
 */
@Data
public class SettingEntity
{
	// id
	private int id = 0;
	
	// 配置名称
	private String settingName = StringUtils.EMPTY;
	
	// 归属技能
	private int skill = 0;
	
	// 配置内容
	private String settingValue = StringUtils.EMPTY;
	
	// 是否启用 1:启用 0:不启用
	private int enableStatus = 1;
}
