package cn.com.dhc.rpmsystem.employe.controller;

import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zss
 * @date 2019-08-05
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberServiceImpl;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultEntity<Member> getMember(@RequestBody Member req) {

        Member member = memberServiceImpl.getMember(req.getNumUid());
        return ResultUtils.success(member);
        //return null;
    }

}
