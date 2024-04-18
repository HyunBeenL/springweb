package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Member;

@Controller
@Log4j2
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {


    private final MemberServiceIf MemberService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public void loginGET(){
        log.info("=============================");
        log.info("LoginController >> loginGET()");
        log.info("=============================");
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String loginPOST(MemberDTO dto){
        log.info("=============================");
        log.info("LoginController >> loginPOST()");
        log.info("=============================");

        Boolean login = MemberService.Login(dto);
        if(login){
            log.info("로그인 성공");
            return " /bbs/list";
        }
        else{
            log.info("로그인 실패");
            return "redirect:/login/login";
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(){
        log.info("=============================");
        log.info("LoginController >> logout()");
        log.info("=============================");

        return "redirect:/bbs/list";
    }
}
