package org.fullstack4.springmvc.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.MemberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberServiceIf{

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    public Boolean Login(MemberDTO dto) {
        MemberVO vo = memberMapper.login(dto.getUser_id());

        log.info("========================");
        log.info("======LoginService======");
        log.info("========================");
        if(vo.getPwd().equals(dto.getPwd())){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public int Join(MemberDTO dto) {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberMapper.join(vo);
        return result;
    }

    @Override
    public int Modify(MemberDTO dto) {
        log.info("========================");
        log.info("======MemberModify======");
        log.info("========================");

        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        int result = memberMapper.modify(vo);

        return result;
    }

    @Override
    public MemberDTO view(String id) {

        log.info("========================");
        log.info("======MemberView======");
        log.info("========================");

        MemberVO vo = memberMapper.view(id);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }
}
