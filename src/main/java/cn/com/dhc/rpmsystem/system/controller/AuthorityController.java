package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.system.dto.MemberRole;
import cn.com.dhc.rpmsystem.system.dto.RpmRoleDto;
import cn.com.dhc.rpmsystem.system.dto.RpmSkillInfoDto;
import cn.com.dhc.rpmsystem.system.entity.RpmMemberRole;
import cn.com.dhc.rpmsystem.system.entity.RpmRole;
import cn.com.dhc.rpmsystem.system.entity.RpmSetting;
import cn.com.dhc.rpmsystem.system.entity.RpmSkillInfo;
import cn.com.dhc.rpmsystem.system.service.AuthorityService;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
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

    @ApiOperation("新增权限")
    @PostMapping("/addAuthorityManager")
    public ResultEntity addAuthorityManager(@RequestBody MemberRole memberRole){
        Calendar calendar= Calendar.getInstance();
        RpmMemberRole rpmMemberRole = new RpmMemberRole();
        rpmMemberRole.setNumUid(memberRole.getNumUid());
        rpmMemberRole.setCreatedTime(calendar.getTime());
        rpmMemberRole.setColumnShow(memberRole.getColumnShow());
        rpmMemberRole.setMemName(memberRole.getMemName());
        rpmMemberRole.setCreatedNumUid(memberRole.getCreatedNumUid());
        rpmMemberRole.setPassword("0123456789");
        rpmMemberRole.setRoleIds(memberRole.getRoleIds());
        authorityService.addAuthority(rpmMemberRole);
        return ResultUtils.success();
    }

    @ApiOperation("删除权限")
    @PostMapping("/deleteAuthorityManager")
    public ResultEntity deleteAuthorityManager(@RequestParam("numUid")Integer numUid){
        authorityService.deleteAuthority(numUid );
        return ResultUtils.success();
    }

    @ApiOperation("修改权限")
    @PostMapping("/updateAuthorityManager")
    public ResultEntity updateAuthorityManager(@RequestBody MemberRole memberRole){
        RpmMemberRole rpmMemberRole = new RpmMemberRole();
        rpmMemberRole.setRoleIds(memberRole.getRoleIds());
        rpmMemberRole.setMemName(memberRole.getMemName());
        authorityService.updateAuthority(rpmMemberRole);
        return ResultUtils.success();
    }

    @ApiOperation("查询单个权限")
    @PostMapping("/findAuthorityByName")
    public ResultEntity findAuthorityByName(String memName){
        MemberRole memberRole = authorityService.findOneAuthority(memName);
        return ResultUtils.success(memberRole);
    }

    @ApiOperation("查询所有权限")
    @PostMapping("/findAuthorityManager")
    public ResultEntity findRoleByName(){
        List<MemberRole> rpmSkillInfo = authorityService.findAllAuthoritys();
        return ResultUtils.success(rpmSkillInfo);
    }
}
