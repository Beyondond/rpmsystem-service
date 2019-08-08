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
	// 用户账号Id
	private String numUid;
	
	// 用户名称
	private String memName;
	
	// 用户角色
	private String roleIds;
	
	// 用户菜单资源
	private List<MenuEntity> menuResource;
}
