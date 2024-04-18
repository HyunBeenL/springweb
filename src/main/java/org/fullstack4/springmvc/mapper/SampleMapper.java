package org.fullstack4.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fullstack4.springmvc.dto.MemberDTO;

import java.util.List;

@Mapper
public interface SampleMapper {
    List<MemberDTO> showMember();
}
