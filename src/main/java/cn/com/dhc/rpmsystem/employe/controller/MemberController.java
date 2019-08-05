package cn.com.dhc.rpmsystem.employe.controller;

import cn.com.dhc.rpmsystem.employe.service.IMemberService;
import cn.com.dhc.rpmsystem.entity.Member;
import cn.com.dhc.rpmsystem.entity.ResultEntity;
import cn.com.dhc.rpmsystem.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zss
 * @date 2019-08-05
 */
@RestController
public class MemberController {

    @Autowired
    private IMemberService memberServiceImpl;

    @RequestMapping("/get/member")
    public ResultEntity<Member> get(@RequestBody Member req) {

        Member member = memberServiceImpl.get(req.getNumUid());
        return ResultUtils.success(member);
        //return null;
    }

}
