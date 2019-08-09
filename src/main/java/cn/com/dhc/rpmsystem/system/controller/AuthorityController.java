package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.system.dto.MemberRole;
import cn.com.dhc.rpmsystem.system.dto.RpmRoleDto;
import cn.com.dhc.rpmsystem.system.dto.RpmSkillInfoDto;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
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

    @ApiOperation("删除权限")
    @PostMapping("/deleteAuthorityManager")
    public ResultEntity deleteAuthorityManager(@RequestParam("id")int id){
        authorityService.deleteSkillInfo(id);
        return ResultUtils.success();
    }

    @ApiOperation("修改权限")
    @PostMapping("/updateAuthorityManager")
    public ResultEntity updateAuthorityManager(@RequestBody MemberRole memberRole){
        RpmRole rpmRole = new RpmRole();
        rpmRole.setColumName(memberRole.getColumName());
        rpmRole.setCreated_time(memberRole.getCreated_time());
        rpmRole.setCreateNumUid(memberRole.getCreateNumUid());
        rpmRole.setId(memberRole.getId());
        rpmRole.setRoleName(memberRole.getRoleName());
        rpmRole.setSkills(memberRole.getSkills());
        authorityService.updateSkillInfo(memberRole);
        return ResultUtils.success();
    }

    @ApiOperation("查询单个权限")
    @PostMapping("/findAuthorityByName")
    public ResultEntity findAuthorityByName(String memName){
        MemberRole memberRole = authorityService.findOneSkillInfo(memName);
        return ResultUtils.success(memberRole);
    }

    @ApiOperation("查询所有权限")
    @PostMapping("/findAuthorityManager")
    public ResultEntity findRoleByName(){
        List<MemberRole> rpmSkillInfo = authorityService.findAllSkillInfo();
        return ResultUtils.success(rpmSkillInfo);
    }
}
