package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;


public interface MemberServiceIf {
    Boolean Login(MemberDTO dto);
}
