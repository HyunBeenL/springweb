package org.fullstack4.springmvc.controller;


import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.ReplyDTO;
import org.fullstack4.springmvc.service.BbsReplyServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping(value = "/replyList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String view(@RequestParam(name="bbs_idx", defaultValue = "1") int bbs_idx){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<ReplyDTO> replyDTOList = bbsReplyServiceIf.reply_list(bbs_idx);
        if(replyDTOList.size()>0){
            resultMap.put("result","sucess");
        }else {
            resultMap.put("result", "fail");
        }

        resultMap.put("list", replyDTOList);
        return new Gson().toJson(resultMap);
    }
}
