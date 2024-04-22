package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.Common.CookieUtil;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Member;

@Controller
@Log4j2
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {


    private final MemberServiceIf MemberService;
    private final HttpServletResponse httpServletResponse;
    HttpSession session;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public void loginGET(HttpServletRequest req, Model model){
        log.info("=============================");
        log.info("LoginController >> loginGET()");
        log.info("=============================");

        String acc_url = req.getHeader("referer");
        model.addAttribute("acc_url", req.getHeader("referer"));
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String loginPOST(@Valid MemberDTO dto,HttpServletRequest req,HttpServletResponse resp){

        session = req.getSession();
        log.info("=============================");
        log.info("LoginController >> loginPOST()");
        log.info("=============================");

        System.out.println(req.getParameter("autologin")+"111111111111111111111111111");
        System.out.println(req.getParameter("save_id")+"111111111111111111111111111");
        Boolean login = MemberService.Login(dto);
        if(login){
            if(req.getParameter("save_id")!=null){
                CookieUtil.setCookies(resp,"","/",50000,"save_id",dto.getUser_id());
            }
            else if(CookieUtil.getCookieValue(req,"save_id") == null){
                CookieUtil.setDeleteCookie(resp,"save_id");
            }
            if(req.getParameter("autologin")!=null){
                CookieUtil.setCookies(resp,"","/",50000,"user_id",dto.getUser_id());
                System.out.println(req.getParameter("autologin")+"2222222222222222222222222222222");
            }
            log.info("로그인 성공");
            session.setAttribute("user_id",dto.getUser_id());
            return "redirect:/bbs/list";
        }
        else{
            log.info("로그인 실패");
            return "redirect:/login/login";
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest req,HttpServletResponse resp){
        session = req.getSession();

        log.info("=============================");
        log.info("LoginController >> logout()");
        log.info("=============================");

        CookieUtil.setDeleteCookie(resp,"user_id");
        session.invalidate();
        return "redirect:/bbs/list";
    }
}
