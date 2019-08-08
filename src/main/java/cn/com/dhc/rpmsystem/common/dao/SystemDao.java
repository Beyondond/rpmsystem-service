package cn.com.dhc.rpmsystem.common.dao;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import cn.com.dhc.rpmsystem.entity.SettingEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDao
{
	/**
	 * 添加操作日志到数据库中
	 */
	void insertOperateLog2DB(OperateLogEntity entity);
	
	/**
	 * 通过配置Id获取配置详情
	 * @param id
	 * @return
	 */
	SettingEntity getRpmSettingById(@Param("id") int id);
	
	/**
	 * 根据技能Id获取功能描述
	 * @param skillId
	 * @return
	 */
	String getSkillDescBySkillId(@Param("skillId") Integer skillId);
}
