package org.fullstack4.springmvc.controller;


import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Log4j2
@Controller
@RequestMapping(value="/area")
public class AreaController {
    @Autowired
    private AreaMapper areaMapper;

    @RequestMapping(value = "/siList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String SiList(){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<String> siList = areaMapper.siList();
        if(siList.size()>0) {
            resultMap.put("result", "success");
        }else {
            resultMap.put("result", "fail");
        }
        resultMap.put("list", siList);
        return new Gson().toJson(resultMap);
    }

    @RequestMapping(value = "/guList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String GuList(@RequestParam(name="si",defaultValue="") String si){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<String> guList = areaMapper.guList(si);
        if(guList.size()>0) {
            resultMap.put("result", "success");
        }else {
            resultMap.put("result", "fail");
        }
        resultMap.put("list", guList);
        return new Gson().toJson(resultMap);
    }
}
