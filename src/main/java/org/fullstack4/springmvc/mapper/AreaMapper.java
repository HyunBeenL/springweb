package org.fullstack4.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {
    List<String> siList();
    List<String> guList(String si);
    List<String> dongList(String si,String gu);
}
