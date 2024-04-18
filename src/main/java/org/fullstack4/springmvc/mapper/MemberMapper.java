package org.fullstack4.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fullstack4.springmvc.domain.MemberVO;

@Mapper
public interface MemberMapper {
    MemberVO login(String id);
}
