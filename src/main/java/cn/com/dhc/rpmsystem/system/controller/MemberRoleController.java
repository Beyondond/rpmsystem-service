package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.system.dto.ColumnShowDto;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowSetUpDto;
import cn.com.dhc.rpmsystem.system.service.IMemberRoleService;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zss
 * @date 2019-08-08
 */
@Api(value = "员工角色接口类")
@RestController
@RequestMapping("/member/role")
public class MemberRoleController {

    @Autowired
    private IMemberRoleService memberRoleServiceImpl;


    @ApiOperation(value = "获取员工首页列展示接口", notes = "获取员工首页列展示接口")
    @RequestMapping(value = "/get/column-show", method = RequestMethod.POST)
    public String getMemberRole(@RequestBody ColumnShowSetUpDto req) {

        ColumnShowDto columnShow = memberRoleServiceImpl.getMemberRole(req.getNumUid());
        return JSON.toJSONString(ResultUtils.success(columnShow));
    }

    @ApiOperation(value = "设置员工首页列展示接口", notes = "设置员工首页列展示接口")
    @RequestMapping(value = "/set/column-show", method = RequestMethod.POST)
    public String setMemberRole(@RequestBody ColumnShowSetUpDto req) {

        memberRoleServiceImpl.setMemberRole(req);
        return JSON.toJSONString(ResultUtils.success());
    }

}
