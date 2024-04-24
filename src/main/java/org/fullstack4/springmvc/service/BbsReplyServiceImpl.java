package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.ReplyVO;
import org.fullstack4.springmvc.dto.ReplyDTO;
import org.fullstack4.springmvc.mapper.ReplyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BbsReplyServiceImpl implements BbsReplyServiceIf {

    private final ReplyMapper replyMapper;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public int reply_regist(ReplyDTO dto) {
        log.info("==============================");
        log.info("ReplyDTO : "+ dto.toString());
        log.info("==============================");

        ReplyVO vo = modelMapper.map(dto,ReplyVO.class);
        int result = replyMapper.regist(vo);
        int reply_result = update_reply_cnt(vo.getBbs_idx());

        log.info("result : "+ result);
        log.info("==============================");
        log.info("==============================");

        return result;
    }

    @Override
    public int update_reply_cnt(int bbs_idx) {
        int result = replyMapper.update_reply_cnt(bbs_idx);

        log.info("===========================");
        log.info("result : "+ result);
        log.info("===========================");

        return result;
    }

    @Override
    public List<ReplyDTO> reply_list(int bbs_idx) {
        List<ReplyDTO> replyDTOList = replyMapper.reply_list(bbs_idx).stream()
                .map(vo->modelMapper.map(vo,ReplyDTO.class))
                .collect(Collectors.toList());

        log.info("========================");
        log.info("BbsReplyServiceImpl >> reply_list : " +replyDTOList.toString());
        log.info("========================");
        return replyDTOList;
    }


}
