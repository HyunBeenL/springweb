package org.fullstack4.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.Common.CookieUtil;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.MemberMapper;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Log4j2
@Controller
@RequestMapping(value="/member")
public class MemberController {

    @Autowired
    private MemberServiceIf MemberService;
    @GetMapping("/list")
    public void list(Model model){
        log.info("=========================");
        log.info("BbsController.list()");
        log.info("=========================");

//        model.addAttribute("list",memberMapper.BbsList());
    }

    @GetMapping("/view")
    public void view(@RequestParam(name="user_id",defaultValue="") String user_id,
                     Model model){
        log.info("=========================");
        log.info("MemberController.view()");
        log.info("idx : " + user_id);
        log.info("=========================");


        MemberDTO dto = MemberService.view(user_id);

        model.addAttribute("dto",dto);
//        model.addAttribute("list",memberMapper.BbsView(user_id));
    }

    @GetMapping("/join")
    public void joinGET(){
        log.info("=========================");
        log.info("BbsController.registGet()");
        log.info("=========================");
    }

    @PostMapping("/join")
    public String joinPOST(MemberDTO dto, Model model, RedirectAttributes redirectAttributes){
        log.info("=========================");
        log.info("MemberController.registPost()");
        log.info("MemberDTO : "+ dto.toString());
        log.info("=========================");


        int result = MemberService.Join(dto);
        return "redirect:/login/login";


    }

    @GetMapping("/modify")
    public void ModifyGET(@RequestParam(name="user_id",defaultValue="") String user_id,
                          Model model){
        log.info("=========================");
        log.info("BbsController.Modifyget()");
        log.info("=========================");

        MemberDTO dto = MemberService.view(user_id);

        model.addAttribute("dto",dto);
    }

    @PostMapping("/modify")
    public String ModifyPost(MemberDTO dto, Model model, RedirectAttributes redirectAttributes, HttpServletRequest req,HttpServletResponse resp){
        log.info("=========================");
        log.info("BbsController.ModifyPost()");
        log.info("=========================");

        HttpSession session = req.getSession();
        int result = MemberService.Modify(dto);
        if(result>0){
            if(CookieUtil.getCookieValue(req,"user_id") != null) {
                CookieUtil.setDeleteCookie(resp, "user_id");
            }
            session.invalidate();
            return "redirect:/login/login";
        }
        else{
            return "/member/modify?user_id="+dto.getUser_id();
        }
    }

    @GetMapping("/leave")
    public void leaveGET(){
        log.info("=========================");
        log.info("MemberController.leave()");
        log.info("=========================");
    }

    @PostMapping("/leave")
    public void leavePOST(){
        log.info("==================================");
        log.info("bbsController >> deletePost()");
        log.info("==================================");

    }
}
