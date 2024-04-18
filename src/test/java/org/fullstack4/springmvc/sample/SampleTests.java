package org.fullstack4.springmvc.sample;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.SampleMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SampleService sampleService;

    @Autowired(required = false)
    private SampleMapper sampleMapper;


    @Test
    public void testService() {
        log.info("===============================");
        log.info("sampleService Test : " + sampleService);
        log.info("===============================");

        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void TestConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        log.info("===============================");
        log.info("dataSource Test : "+ connection);
        log.info("===============================");

        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void TestShowMember() throws Exception{
        log.info("===============================");
        log.info("sampleMapper : + " + sampleMapper.showMember());
        log.info("===============================");
    }


}

