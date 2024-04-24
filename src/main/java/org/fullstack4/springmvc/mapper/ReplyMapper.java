package org.fullstack4.springmvc.mapper;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Mapper;
import org.fullstack4.springmvc.domain.ReplyVO;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int regist(ReplyVO vo);
    int modify(ReplyVO vo);
    int update_reply_cnt(int bbs_idx);
    ReplyVO view(int idx);
    List<ReplyVO> reply_list();

}
