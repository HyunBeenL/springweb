package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.fullstack4.springmvc.service.BbsServiceIf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Log4j2
@Controller
@RequestMapping(value="/bbs")
@RequiredArgsConstructor

public class BbsController {

    @Autowired
    BbsMapper bbsMapper;

    private final BbsServiceIf bbsService;

//    @GetMapping("/list")
//    public void list(Model model
//            , @RequestParam(required = false, defaultValue = "1") int page
//            , @RequestParam(required = false, defaultValue = "1") int bar){
//        log.info("=========================");
//        log.info("BbsController.list()");
//        log.info("=========================");
//
//        List<BbsDTO> dto = bbsService.listAll(page);
//        int totalcount = bbsService.TotalCount();
//
//        int barcount = 1+(bar-1)*10;
//        model.addAttribute("barcount", barcount);
//        model.addAttribute("pagecount", (totalcount/10)+1);
//        model.addAttribute("page", page);
//        model.addAttribute("bbsList",dto);
//    }

    @GetMapping("/list")
    public void list(Model model
            , @Valid PageRequestDTO pageRequestDTO
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        log.info("=========================");
        log.info("BbsController.list()");
        log.info("pageRequsetDTO" + pageRequestDTO.toString());

        if(bindingResult.hasErrors()){
            log.info("BbsController >> list Error");
            redirectAttributes.addFlashAttribute("errors",bindingResult);
        }

        PageResponseDTO<BbsDTO> responseDTO = bbsService.bbsListByPage(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);

        log.info("=========================");
        log.info("BbsController.list()>>view()");
        log.info(responseDTO);

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
    public String registPOST(@Valid BbsDTO dto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        log.info("=========================");
        log.info("BbsController.registPost()");
        log.info("BbsController.registPost()"+bindingResult);
        log.info("=========================");

        if(bindingResult.hasErrors()){
            log.info("Errors");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            log.info(bindingResult.getAllErrors());
            log.info("#######################bbsDTO : "+ dto.toString());
            redirectAttributes.addFlashAttribute("errdto",dto);
            return "redirect:/bbs/regist";
        }
        int result = bbsService.regist(dto);
        log.info("result : "+result);
        log.info("=========================");
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

    @RequestMapping(value="/fileUpload", method = RequestMethod.GET)
    public String fileUploadGET(){
        return "/bbs/fileUpload";
    }


    @RequestMapping(value="/fileUpload", method = RequestMethod.POST)
    public String fileUploadPost(@RequestParam("file")MultipartFile file){
        String uploadeFolder = "D:\\JAVA4\\spring\\springweb\\springmvc\\src\\main\\webapp\\Uploads";
//        String uploadeFolder = "D:\\JAVA4\\uploads";
        String fileRealName = file.getOriginalFilename();
        long size = file.getSize();
        ///파일 경로 추출
        String fileExt = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());


        log.info("==========================================");
        log.info("uploadeFolder : " + uploadeFolder);
        log.info("fileRealName : " +fileRealName);
        log.info("size : "+ size);

        log.info("fileExt : " + fileExt);
        log.info("==========================================");

        UUID uuid = UUID.randomUUID();
        String[] uuids = uuid.toString().split("-");
        String newName = uuids[0];

        log.info("uuid : "+ uuid);
        log.info("uuids : "+ uuids.toString());
        log.info("newName : "+ newName);

        File saveFile = new File(uploadeFolder + "\\" + newName + fileExt);
        try{
            file.transferTo(saveFile);
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        log.info("===============================================");
        return "/bbs/fileUpload";
    }

    @RequestMapping(value="/fileUpload2", method = RequestMethod.POST)
    public String fileUploadPost2(MultipartHttpServletRequest files){
        String uploadeFolder = "D:\\JAVA4\\spring\\springweb\\springmvc\\src\\main\\webapp\\Uploads";

        List<MultipartFile> list = files.getFiles("files");
        for(int i=0; i<list.size(); i++){
            String fileRealName = list.get(i).getOriginalFilename();
            long size = list.get(i).getSize();
            ///파일 경로 추출
            String fileExt = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());


            log.info("==========================================");
            log.info("uploadeFolder : " + uploadeFolder);
            log.info("fileRealName : " +fileRealName);
            log.info("size : "+ size);

            log.info("fileExt : " + fileExt);
            log.info("==========================================");

            UUID uuid = UUID.randomUUID();
            String[] uuids = uuid.toString().split("-");
            String newName = uuids[0];

            log.info("uuid : "+ uuid);
            log.info("uuids : "+ uuids.toString());
            log.info("newName : "+ newName);

            File saveFile = new File(uploadeFolder + "\\" + newName + fileExt);
            try{
                list.get(i).transferTo(saveFile);
            }catch(IllegalStateException e){
                e.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            log.info("===============================================");
        }
        return "/bbs/fileUpload";
    }


}
