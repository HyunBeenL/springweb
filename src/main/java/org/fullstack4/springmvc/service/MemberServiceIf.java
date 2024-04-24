package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;

import java.util.List;


public interface MemberServiceIf {
    Boolean Login(MemberDTO dto);
    int Join(MemberDTO dto);
    int Modify(MemberDTO dto);
    MemberDTO view(String id);
    int delete(String id);
    List<String> idList();
}
