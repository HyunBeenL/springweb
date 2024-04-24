package org.fullstack4.springmvc.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.ReplyDTO;
import org.fullstack4.springmvc.service.BbsReplyServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping(value="/bbsReply")
@RequiredArgsConstructor
public class BbsReplyController {
    private final BbsReplyServiceIf bbsReplyServiceIf;

    @PostMapping("/regist.dox")
    public String registPOST(@Valid ReplyDTO dto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        log.info("=========================");
        log.info("BbsReplyController.registPost()");


        if (bindingResult.hasErrors()) {
            log.info("Errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            log.info(bindingResult.getAllErrors());
            log.info("#######################bbsDTO : " + dto.toString());
            redirectAttributes.addFlashAttribute("errdto", dto);
            return "redirect:/bbs/view?idx="+dto.getBbs_idx();
        }

        int result = bbsReplyServiceIf.reply_regist(dto);
        log.info("result : " + result);
        log.info("=========================");
        if (result > 0) {
            return "redirect:/bbs/view?idx="+dto.getBbs_idx();
        } else {
            return "/bbs/view?idx="+dto.getBbs_idx();
        }
    }

    public void view(@RequestParam(name="idx", defaultValue = "1") int idx){

    }
}
