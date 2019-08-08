package cn.com.dhc.rpmsystem.system.dao;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import cn.com.dhc.rpmsystem.system.dto.OperateLogDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyz
 */
@Repository
public interface OperateLogDao {
    /**
     * 根据条件查询
     * @param operateLogDto
     * @return
     */
    List<OperateLogEntity> findOperateLogs(OperateLogDto operateLogDto);
}
