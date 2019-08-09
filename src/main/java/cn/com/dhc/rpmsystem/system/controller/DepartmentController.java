package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.PageBean;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.system.entity.Department;
import cn.com.dhc.rpmsystem.system.service.impl.DepartmentServiceImpl;
import cn.com.dhc.rpmsystem.utils.DateUtils;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import cn.com.dhc.rpmsystem.utils.SystemUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author zhouyongzhou
 * @description 部门管理
 * @date 2019/8/6
 */
@RestController
@RequestMapping("/department")
@Api(tags = "DepartmentController", description = "部门管理")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @ApiOperation("添加部门")
    @PostMapping("/addDepartment")
    public ResultEntity addDepartment(@RequestParam("dp_name") String dp_name, @RequestParam("paternal_id") int paternal_id,
                                      @RequestParam("created_num_uid") int created_num_uid, @RequestParam("created_time") String created_time) {
        Department department = getDepartment( -1, dp_name, paternal_id, created_num_uid, created_time );
        departmentService.addDepartment( department );
        SystemUtils.writeOperateLog( 1, "添加了" + dp_name, true, created_num_uid );
        return ResultUtils.success();
    }

    @ApiOperation("根据条件查询")
    @PostMapping("/findDepartments")
    public ResultEntity findDepartments(@RequestParam("searchStr") String searchStr, @RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageNum") Integer pageSize
    ) {
        //总数
        Integer totalCount = departmentService.getTotalCount( searchStr );
        int totalPage = 0;
        //分页查询
        if (pageNum != null && pageSize != null && pageNum > 0 && pageSize > 0) {
            if (totalCount % pageSize != 0) {
                totalPage = totalCount / pageSize + 1;
            }
            PageHelper.startPage( pageNum, pageSize );
        }
        List<Department> departments = departmentService.findDepartments( searchStr );
        PageBean<Department> pageBean = new PageBean<>();
        pageBean.setList( departments );
        pageBean.setPage( pageNum );
        pageBean.setTotalCount( totalCount );
        pageBean.setTotalPage( totalPage );
        return ResultUtils.success( pageBean );
    }

    @ApiOperation("根据id删除部门")
    @PostMapping("/deleteDepartment")
    public ResultEntity deleteDepartment(@RequestParam("id") int id) {
        departmentService.deleteDepartment( id );
        SystemUtils.writeOperateLog( 2, "根据id删除部门" + id, true, 20034 );
        return ResultUtils.success();
    }

    @ApiOperation("编辑更新部门")
    @PostMapping("/updateDepartment")
    public String updateDepartment(@RequestParam("id") int id, @RequestParam("dp_name") String dp_name, @RequestParam("paternal_id") int paternal_id,
                                   @RequestParam("created_num_uid") int created_num_uid, @RequestParam("created_time") String created_time) {
        Department department = getDepartment( id, dp_name, paternal_id, created_num_uid, created_time );
        SystemUtils.writeOperateLog( 3, "编辑更新部门" + dp_name, true, 20034 );
        return JSON.toJSONString( ResultUtils.success( departmentService.updateDepartment( department ) ) );
    }

    /**
     * 获取Department
     *
     * @param id
     * @param dp_name
     * @param paternal_id
     * @param created_num_uid
     * @param created_time
     * @return
     */
    public Department getDepartment(int id, String dp_name, int paternal_id, int created_num_uid, String created_time) {
        Department department = new Department();
        if (-1 != id) {
            department.setId( id );
        }
        department.setDp_name( dp_name );
        department.setPaternal_id( paternal_id );
        department.setCreated_num_uid( created_num_uid );
        Date date = DateUtils.StringToDate( created_time, null );
        department.setCreated_time( date );
        return department;
    }


}
