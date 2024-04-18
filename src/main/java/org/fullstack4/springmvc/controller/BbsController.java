package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.fullstack4.springmvc.service.BbsServiceIf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@Controller
@RequestMapping(value="/bbs")
@RequiredArgsConstructor
public class BbsController {

    @Autowired
    BbsMapper bbsMapper;

    private final BbsServiceIf bbsService;

    @GetMapping("/list")
    public void list(Model model){
        log.info("=========================");
        log.info("BbsController.list()");
        log.info("=========================");

        List<BbsDTO> dto = bbsService.listAll();

        model.addAttribute("bbsList",dto);
    }

    @GetMapping("/view")
    public void view(@RequestParam(name="idx",defaultValue="0") int idx,
                     Model model){
        log.info("=========================");
        log.info("BbsController.view()");
        log.info("idx : " + idx);
        log.info("=========================");

        BbsDTO bbsDTO = bbsService.BbsView(idx);

        model.addAttribute("idx",idx);
        model.addAttribute("list",bbsDTO);
    }

    @GetMapping("/regist")
    public void registGET(){
        log.info("=========================");
        log.info("BbsController.registGet()");
        log.info("=========================");
    }

    @PostMapping("/regist")
    public String registPOST(BbsDTO dto, RedirectAttributes redirectAttributes){

        log.info("=========================");
        log.info("BbsController.registPost()");
        log.info("bbsDTO : "+ dto.toString());
        log.info("=========================");

        int result = bbsService.regist(dto);
        if(result>0){
            return "redirect:/bbs/list";
        }else{
            return "/bbs/regist";
        }




    }

    @GetMapping("/modify")
    public void ModifyGET(@RequestParam(name="idx",defaultValue="0") int idx,
                          Model model){
        log.info("=========================");
        log.info("BbsController.Modifyget()");
        log.info("=========================");

        BbsDTO bbsDTO = bbsService.BbsView(idx);
        model.addAttribute("idx",idx);
        model.addAttribute("Bbs",bbsDTO);

    }

    @PostMapping("/modify")
    public String ModifyPost(BbsDTO bbsDTO, Model model, RedirectAttributes redirectAttributes){
        log.info("=========================");
        log.info("BbsController.ModifyPost()");
        log.info("=========================");

        int result = bbsService.Modify(bbsDTO);
        if(result>0){
            return "redirect:/bbs/view?idx="+bbsDTO.getIdx();
        }else{
            return "/bbs/modify";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name="idx",defaultValue="0") int idx,
                       Model model, RedirectAttributes redirectAttributes){
        log.info("=========================");
        log.info("BbsController.delete()");
        log.info("=========================");

        int result = bbsService.delete(idx);
        if(result>0) {
            return "redirect:/bbs/list";
        }else{
            return "/bbs/view?idx="+idx;
        }
    }

    @PostMapping("/delete")
    public String deletePOST(@RequestParam(name="idx",defaultValue="0") int idx,
                           Model model, RedirectAttributes redirectAttributes){
        log.info("==================================");
        log.info("bbsController >> deletePost()");
        log.info("==================================");

        int result = bbsService.delete(idx);
        if(result>0) {
            return "redirect:/bbs/list";
        }else{
            return "/bbs/view?idx="+idx;
        }

    }


}
