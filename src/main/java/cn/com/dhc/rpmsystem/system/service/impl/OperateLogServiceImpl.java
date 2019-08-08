package cn.com.dhc.rpmsystem.system.service.impl;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import cn.com.dhc.rpmsystem.system.dao.OperateLogDao;
import cn.com.dhc.rpmsystem.system.dto.OperateLogDto;
import cn.com.dhc.rpmsystem.system.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouyongzhou
 * @description 操作日志管理
 * @date 2019/8/6
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    OperateLogDao operateLogDao;

    @Override
    public List<OperateLogEntity> findOperateLogs(OperateLogDto operateLogDto) {
        return operateLogDao.findOperateLogs( operateLogDto );
    }
}
