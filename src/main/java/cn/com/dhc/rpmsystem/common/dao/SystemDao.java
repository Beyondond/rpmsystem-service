package cn.com.dhc.rpmsystem.common.dao;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDao
{
	/**
	 * 添加操作日志到数据库中
	 */
	void insertOperateLog2DB(OperateLogEntity entity);
}
