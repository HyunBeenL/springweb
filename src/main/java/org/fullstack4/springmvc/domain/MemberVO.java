package org.fullstack4.springmvc.domain;


import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
@Log4j2///실제 배포시에 넣지마
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private String user_name;
    private String user_id;
    private String pwd;
    private String addr1;
    private String addr2;
    private String birthday;
    private String job_code;
    private int mileage;
    private String user_state;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private LocalDate pwd_change_date;
    private LocalDate leave_date;
}
