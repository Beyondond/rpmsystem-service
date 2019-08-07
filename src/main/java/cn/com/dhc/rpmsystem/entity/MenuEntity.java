package cn.com.dhc.rpmsystem.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description TODO
 * @Date 2019/8/7 9:51
 * @Created by Sunli
 */
@Data
public class MenuEntity
{
	// 功能ID
	private int id = 0;
	
	// 功能父Id
	private int parentId = 0;
	
	// 功能描述
	private String skillDesc = StringUtils.EMPTY;
}
