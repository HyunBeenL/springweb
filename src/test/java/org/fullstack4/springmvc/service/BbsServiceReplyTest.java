package org.fullstack4.springmvc.service;


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
public class BbsServiceReplyTest {

    @Autowired(required = false)
    private BbsReplyServiceIf bbsReplyServiceIf;

    @Test
    public void testReplyRegist(){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .bbs_idx(33)
                .user_id("test")
                .title("댓글 테스트")
                .build();

        int result = bbsReplyServiceIf.reply_regist(replyDTO);
        log.info("==================================");
        log.info("result : "+result);
        log.info("==================================");
    }
}
