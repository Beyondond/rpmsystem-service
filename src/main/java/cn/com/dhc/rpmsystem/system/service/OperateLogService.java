package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;

import java.util.List;

public interface OperateLogService {
    /**
     * 查询所有的操作日志
     * @return
     */
    List<OperateLogEntity> findAllOperateLogs();







}
