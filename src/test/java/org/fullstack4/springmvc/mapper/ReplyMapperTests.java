package org.fullstack4.springmvc.mapper;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.ReplyVO;
import org.fullstack4.springmvc.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ReplyMapperTests {

    @Autowired(required = false)
    ReplyMapper replyMapper;

    @Test
    public void ReplyInsertTest(){
        ReplyVO replyVO = ReplyVO.builder()
                .bbs_idx(33)
                .user_id("test")
                .title("댓글 테스트")
                .build();

        int result = replyMapper.regist(replyVO);
        log.info("==================================");
        log.info("result : "+result);
        log.info("==================================");
    }

    @Test
    public void ReplylistTest(){

    }
}
