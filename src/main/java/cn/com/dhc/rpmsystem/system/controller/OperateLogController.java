package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.OperateLogEntity;
import cn.com.dhc.rpmsystem.entity.PageBean;
import cn.com.dhc.rpmsystem.system.dto.OperateLogDto;
import cn.com.dhc.rpmsystem.system.service.impl.OperateLogServiceImpl;
import cn.com.dhc.rpmsystem.utils.DateUtils;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhouyongzhou
 * @description 操作日志管理
 * @date 2019/8/6
 */
@Api(tags = "OperateLogController", description = "操作日志管理")
@RestController
@RequestMapping("/operateLog")
public class OperateLogController {
    @Autowired
    OperateLogServiceImpl operateLogServiceImpl;

    @ApiOperation("根据条件查询")
    @PostMapping("/findOperateLogs")
    public String findOperateLogs(HttpServletRequest request) {
        String startTime = request.getParameter( "startTime" );
        String endTime = request.getParameter( "endTime" );
        String searchValue = request.getParameter( "searchValue" );
        Integer pageNum = Integer.parseInt( request.getParameter( "pageNum" ) );
        Integer pageSize = Integer.parseInt( request.getParameter( "pageSize" ) );

//        searchType  检索类型 0-operateTarget（操作对象） 1--operateAccount（操作人工号 int）
//                   2--operateName (操作人名字) 3--operateResult（操作结果 int）
        String Typestr = request.getParameter( "searchType" );

        int searchType = -1;
        if (!StringUtils.isEmpty( Typestr )){
             searchType = Integer.parseInt( Typestr );
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        OperateLogDto operateLogDto = buildOperateLogDao( startTime, endTime, searchType, searchValue );
        List<OperateLogEntity> list_operateLogEntity=operateLogServiceImpl.findOperateLogs( operateLogDto );
        PageBean<OperateLogEntity> pageBean = new PageBean<>();
        pageBean.setList( list_operateLogEntity );
        Integer totalCount = operateLogServiceImpl.getTotalCount( operateLogDto );
        pageBean.setTotalCount( totalCount );
        pageBean.setPage( pageNum );
        return JSON.toJSONString( ResultUtils.success( pageBean ) );
    }

    /**
     * 构建所需要的OperateLogDto
     * @param startTime
     * @param endTime
     * @param searchType
     * @param searchValue
     * @return
     */
    private OperateLogDto buildOperateLogDao(String startTime, String endTime, int searchType, String searchValue) {
        OperateLogDto operateLogDto = new OperateLogDto();
        operateLogDto.setStartTime( DateUtils.StringToDate( startTime,null ) );
        operateLogDto.setEndTime( DateUtils.StringToDate( endTime,null ) );
        operateLogDto.setSearchType( searchType );
        switch (searchType) {
            case 0:
                operateLogDto.setOperateTarget(searchValue);
                break;
            case 1:
                if (!StringUtils.isEmpty( searchValue )){
                    operateLogDto.setOperateAccount( Integer.parseInt( searchValue ) );
                }
                break;
            case 2:
                operateLogDto.setOperateName( searchValue );
                break;
            case 3:
                if (!StringUtils.isEmpty( searchValue )){
                    operateLogDto.setOperateResult( Integer.parseInt( searchValue ) );
                }
                break;
            default:
                break;
        }
        return operateLogDto;
    }

}
