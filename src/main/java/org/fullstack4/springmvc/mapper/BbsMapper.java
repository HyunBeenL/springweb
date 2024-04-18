package org.fullstack4.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;

import java.util.List;

@Mapper
public interface BbsMapper {
    List<BbsVO> listAll();
    BbsVO BbsView(int idx);
    int regist(BbsVO bbsvo);
    int delete(int idx);
    int Modify(BbsVO bbsvo);
}
