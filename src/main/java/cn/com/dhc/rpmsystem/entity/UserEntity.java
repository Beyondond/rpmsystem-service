package cn.com.dhc.rpmsystem.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description 用户基本信息
 * @Date 2019/8/7 9:40
 * @Created by Sunli
 */
@Data
public class UserEntity
{
	private String numUid;
	
	private String memName;
	
	private String roleIds;
	
	private List<MenuEntity> menuResource;
}
