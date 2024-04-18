package org.fullstack4.springmvc.mapper;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {
//    @Autowired(required = false)
//    private TimeMapper timeMapper;
//
//    @Test
//    public void testGetTime(){
//        log.info("===================================");
//        log.info("timeMapper.getTime() : " + timeMapper.getTime());
//        log.info("===================================");
//
//    }

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;

    @Autowired(required = false)
    private BbsMapper bbsMapper;

    @Test
    public void testGetTime(){
        log.info("===================================");
        log.info("timeMapper.getNow() : " + timeMapper2.getNow());
        log.info("===================================");

    }

    @Test
    public void testInsertBbs(){
//        BbsDTO bbsDTO = BbsDTO.builder().
//                user_id("test").
//                title("제목").
//                content("내용").
//                build();
        BbsDTO dto = new BbsDTO();
        dto.setUser_id("test1");
        dto.setTitle("제목");
        dto.setContent("내용");
        log.info("===================================");
//        log.info("BoardMapper.getNow() : " + bbsMapper.regist(dto));
        log.info("===================================");
    }

    @Test
    public void testViewBbs(){

        log.info("===================================");
        log.info("BoardMapper.getNow() : " + bbsMapper.BbsView(2));
        log.info("===================================");
    }
}
