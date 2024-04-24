package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.ReplyVO;
import org.fullstack4.springmvc.dto.ReplyDTO;

import java.util.List;

public interface BbsReplyServiceIf {
    int reply_regist(ReplyDTO dto);
    int update_reply_cnt(int bbs_idx);
    List<ReplyVO> reply_list();
}
