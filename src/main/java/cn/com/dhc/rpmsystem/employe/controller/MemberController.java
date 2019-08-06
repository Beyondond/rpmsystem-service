package cn.com.dhc.rpmsystem.employe.controller;

import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
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
 * @date 2019-08-05
 */
@Api(value = "员工接口")
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberServiceImpl;

    @ApiOperation(value = "获取用户详情接口", notes = "根据员工卡号获取员工详情接口")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getMember(@RequestBody Member req) {

        Member member = memberServiceImpl.getMember(req.getNumUid());
        return JSON.toJSONString(ResultUtils.success(member));
    }


    @ApiOperation(value = "添加员工接口", notes = "添加员工接口")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMember(@RequestBody Member req) {
        Integer numUid = memberServiceImpl.saveMember(req);
        return JSON.toJSONString(ResultUtils.success(numUid));
    }


    @ApiOperation(value = "删除员工接口", notes = "根据员工卡号删除员工接口")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delMember(@RequestBody Member req) {
        Integer numUid = memberServiceImpl.delMember(req);
        return JSON.toJSONString(ResultUtils.success(numUid));
    }


    @ApiOperation(value = "编辑员工接口", notes = "编辑员工接口")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateMember(@RequestBody Member req) {
        Integer numUid = memberServiceImpl.updateMember(req);
        return JSON.toJSONString(ResultUtils.success(numUid));
    }

}
