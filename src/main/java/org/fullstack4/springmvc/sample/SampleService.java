package org.fullstack4.springmvc.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
public class SampleService {

    //   @Autowired
    @Qualifier("normal")
    private final SampleDAO sampleDAO;
    

}
