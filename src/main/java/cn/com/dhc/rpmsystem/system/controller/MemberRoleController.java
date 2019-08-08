package cn.com.dhc.rpmsystem.system.controller;

import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.system.dto.ColumnShowDto;
import cn.com.dhc.rpmsystem.system.service.IMemberRoleService;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import com.alibaba.fastjson.JSON;
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
@RestController
@RequestMapping("/member/role")
public class MemberRoleController {

    @Autowired
    private IMemberRoleService memberRoleServiceImpl;


    @ApiOperation(value = "获取用户详情接口", notes = "根据员工卡号获取员工详情接口")
    @RequestMapping(value = "/get/column-show", method = RequestMethod.POST)
    public String getMemberRole(@RequestBody Member req) {

        ColumnShowDto columnShow = memberRoleServiceImpl.getMemberRole(req.getNumUid());
        return JSON.toJSONString(ResultUtils.success(columnShow));
    }


}
