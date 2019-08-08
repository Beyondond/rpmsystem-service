package cn.com.dhc.rpmsystem.system.service;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import cn.com.dhc.rpmsystem.system.dto.OperateLogDto;

import java.util.List;

/**
 * 日志管理
 * @author zyz
 */
public interface OperateLogService {

    /**
     * 按条件查询日志
     * @param operateLogDto
     * @return
     */
    List<OperateLogEntity> findOperateLogs(OperateLogDto operateLogDto);

}
