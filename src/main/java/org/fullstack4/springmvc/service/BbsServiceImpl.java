package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.service.BbsServiceIf;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Service
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsServiceIf {

    private final BbsMapper bbsMapper;
    private final ModelMapper modelMapper;

    @Override
    public int regist(BbsDTO dto) {
        log.info("========================");
        log.info("BbsServiceImpl >> regist(bbsDTO) : " +dto.toString());
        log.info("========================");

        BbsVO bbsvo = modelMapper.map(dto,BbsVO.class);
        int result = bbsMapper.regist(bbsvo);



        return result;
    }

    @Override
    public List<BbsDTO> listAll(int page) {
        int startnum = 0+(10*(page-1));
        int endnum = 10;
        List<BbsDTO> bbsDTOList = bbsMapper.listAll(startnum,endnum).stream()
                .map(vo->modelMapper.map(vo,BbsDTO.class))
                .collect(Collectors.toList());

        log.info("========================");
        log.info("BbsServiceImpl >> regist(bbsDTO) : " +bbsDTOList.toString());
        log.info("========================");
        return bbsDTOList;
    }

    @Override
    public PageResponseDTO<BbsDTO> bbsListByPage(PageRequestDTO pageRequestDTO) {
        List<BbsVO> voList = bbsMapper.bbsListByPage(pageRequestDTO);
        List<BbsDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,BbsDTO.class))
                .collect(Collectors.toList());
        int total_count = bbsMapper.bbsTotalCount(pageRequestDTO);
        PageResponseDTO<BbsDTO> responseDTO = PageResponseDTO.<BbsDTO>withAll()
                .requestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total_count(total_count)
                .build();
        return responseDTO;
    }

    @Override
    public BbsDTO BbsView(int idx) {
        BbsVO bbsVO = bbsMapper.BbsView(idx);
        BbsDTO bbsDTO = modelMapper.map(bbsVO, BbsDTO.class);

        return bbsDTO;
    }

    @Override
    public int Modify(BbsDTO dto) {
        log.info(dto.toString()+"######################");
        BbsVO bbsvo = modelMapper.map(dto,BbsVO.class);
        log.info(bbsvo.toString()+"###################");
        int result = bbsMapper.Modify(bbsvo);

        return result;
    }

    @Override
    public int delete(int idx) {
        int result = bbsMapper.delete(idx);
        return result;
    }

    @Override
    public int TotalCount() {
        int totalcount = bbsMapper.totalcount();
        return totalcount;
    }

    @Override
    public int BbsTotalCount(PageRequestDTO requestDTO) {
        int totalcount = bbsMapper.bbsTotalCount(requestDTO);
        return totalcount;
    }



}
