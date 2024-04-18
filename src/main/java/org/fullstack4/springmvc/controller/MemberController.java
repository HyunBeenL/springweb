package org.fullstack4.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping(value="/member")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;
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


        model.addAttribute("user_id",user_id);
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


        return "redirect:/login/login";


    }

    @GetMapping("/modify")
    public void ModifyGET(){
        log.info("=========================");
        log.info("BbsController.Modifyget()");
        log.info("=========================");
    }

    @PostMapping("/modify")
    public void ModifyPost(){
        log.info("=========================");
        log.info("BbsController.ModifyPost()");
        log.info("=========================");
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
