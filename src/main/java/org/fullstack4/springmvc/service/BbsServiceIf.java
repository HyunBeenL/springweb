package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;

import java.util.List;

public interface BbsServiceIf {
    int regist(BbsDTO dto);
    List<BbsDTO> listAll(int page);
    BbsDTO BbsView(int idx);
    int Modify(BbsDTO dto);
    int delete(int idx);
    int TotalCount();
}
