package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.system.dto.RpmRoleDto;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.service.RoleManagerService;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author kemeiyi
 * @description 角色配置管理
 * @date 2019/8/7
 */
@RestController
@RequestMapping("/roleManager")
@Api(tags = "RoleManagerController", description = "角色管理")
public class RoleManagerController {

    @Autowired
    private RoleManagerService roleManagerService;

    @ApiOperation("添加角色")
    @PostMapping("/addRoleManager")
    public ResultEntity addRoleManager(@RequestBody RpmRoleDto rpmRoleDto) {

        RpmRole  rpmRole = new RpmRole();
        rpmRole.setId(rpmRoleDto.getId());
        rpmRole.setColumName(rpmRoleDto.getColumName());
        Calendar calendar= Calendar.getInstance();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        rpmRole.setCreated_time(calendar.getTime());
        rpmRole.setRoleName(rpmRoleDto.getRoleName());
        rpmRole.setCreateNumUid(rpmRoleDto.getCreateNumUid());
        rpmRole.setSkills(rpmRoleDto.getSkills());
        roleManagerService.addRole(rpmRole);
        return ResultUtils.success();
    }
    @ApiOperation("删除角色")
    @PostMapping("/deleteRoleManager")
    public ResultEntity deleteRoleManager(@RequestParam("id")int id){
        roleManagerService.deleteRoleByName(id);
        return ResultUtils.success();
    }

    @ApiOperation("修改角色")
    @PostMapping("/updateRoleManager")
    public ResultEntity updateRoleManager(@RequestBody RpmRoleDto rpmRoleDto){
        RpmRole  rpmRole = new RpmRole();
        rpmRole.setId(rpmRoleDto.getId());
        rpmRole.setColumName(rpmRoleDto.getColumName());
        rpmRole.setCreated_time(rpmRoleDto.getCreated_time());
        rpmRole.setRoleName(rpmRoleDto.getRoleName());
        rpmRole.setCreateNumUid(rpmRoleDto.getCreateNumUid());
        rpmRole.setSkills(rpmRoleDto.getSkills());
        roleManagerService.updateRpmRole(rpmRole);
        return ResultUtils.success();
    }

    @ApiOperation("查询单个角色")
    @PostMapping("/findRoleByName")
    public ResultEntity findRoleByName(String roleName){
        RpmRole rpmRole = roleManagerService.findRoleByName(roleName);
        return ResultUtils.success(rpmRole);
    }

    @ApiOperation("查询所有角色")
    @PostMapping("/findAllRole")
    public ResultEntity findAllRpmRole(){
        List<RpmRole> rpmRoleList = roleManagerService.findAllRole();
        return ResultUtils.success(rpmRoleList);
    }
}
