package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.system.dto.RpmRoleDto;
import cn.com.dhc.rpmsystem.system.dto.RpmSkillInfoDto;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;
import cn.com.dhc.rpmsystem.system.service.AuthorityService;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kemeiyi
 * @description 权限管理操作
 * @date 2019/8/7
 */
@RestController
@RequestMapping("/authority")
@Api(tags = "AuthorityController", description = "权限管理")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @ApiOperation("添加权限")
    @PostMapping("/addAuthorityManager")
    public ResultEntity addAuthorityManager(@RequestBody RpmSkillInfoDto rpmSkillInfoDto) {
        RpmSkillInfo rpmSkillInfo = new RpmSkillInfo();
        rpmSkillInfo.setId(rpmSkillInfoDto.getId());
        rpmSkillInfo.setRoleId(rpmSkillInfoDto.getRoleId());
        rpmSkillInfo.setSkillDesc(rpmSkillInfoDto.getSkillDesc());
        authorityService.addSkillInfo(rpmSkillInfo);
        return ResultUtils.success();
    }
    @ApiOperation("删除权限")
    @PostMapping("/deleteAuthorityManager")
    public ResultEntity deleteAuthorityManager(@RequestParam("id")int id){
        authorityService.deleteSkillInfo(id);
        return ResultUtils.success();
    }

    @ApiOperation("修改权限")
    @PostMapping("/updateAuthorityManager")
    public ResultEntity updateAuthorityManager(@RequestParam("id")int id){
        authorityService.updateSkillInfo(id);
        return ResultUtils.success();
    }

    @ApiOperation("查询单个权限")
    @PostMapping("/findAuthorityByName")
    public ResultEntity findAuthorityByName(@RequestParam("name")String name){
        RpmSkillInfo rpmSkillInfo = authorityService.findOneSkillInfo(name);
        return ResultUtils.success(rpmSkillInfo);
    }

    @ApiOperation("查询所有权限")
    @PostMapping("/findAuthorityManager")
    public ResultEntity findRoleByName(){
        List<RpmSkillInfo> rpmSkillInfo = authorityService.findAllSkillInfo();
        return ResultUtils.success(rpmSkillInfo);
    }
}
