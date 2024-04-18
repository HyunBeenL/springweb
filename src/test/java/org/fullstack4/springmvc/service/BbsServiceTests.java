package org.fullstack4.springmvc.service;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsServiceTests {

    @Autowired(required = false)
    private BbsServiceIf bbsServiceIf;

    @Test
    public void testRegist(){
        BbsDTO bbsDTO = BbsDTO.builder()
                .user_id("id")
                .title("title")
                .content("content")
                .display_date("2024-03-01")
                .read_cnt(0)
                .build();

        int result = bbsServiceIf.regist(bbsDTO);
    }
}
