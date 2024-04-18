package org.fullstack4.springmvc.controller;

import lombok.extern.log4j.Log4j2;


import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@Controller
public class SampleController {
    @Autowired
    private SampleMapper mapper;

    @GetMapping("/hello")
    public void hello(HttpServletRequest req) throws Exception {
        log.info("================================");
        log.info("hello!!!!!!!!!!!");
        log.info("================================");

        List<MemberDTO> dto = mapper.showMember();
        req.setAttribute("dto",dto);

    }

}
