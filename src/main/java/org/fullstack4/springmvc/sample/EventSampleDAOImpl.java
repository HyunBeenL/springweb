package org.fullstack4.springmvc.sample;

import org.fullstack4.springmvc.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO{

}
