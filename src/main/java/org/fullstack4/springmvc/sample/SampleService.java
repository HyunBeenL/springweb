package org.fullstack4.springmvc.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
public class SampleService {
    // 의존성 주입의 대상 -> private
//    @Autowired
    // (Autowired의 상위에 있는 클래스)SampleService를 생성할 때, sampleDAO 객체를 SampleDAO에 주입해서 생성해 줘...
    // 테스트 결과 : sampleService Test : SampleService(sampleDAO=org.fullstack4.springmvc.sample.SampleDAO@1b812421)
    private final SampleDAO sampleDAO;
    
    // 아래와 같은 작업이 필요 없음
//    SampleService() {
//        this.sampleDAO = new SampleDAO();
//    }
}
