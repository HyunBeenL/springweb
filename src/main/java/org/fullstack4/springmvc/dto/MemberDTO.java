package org.fullstack4.springmvc.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    @NotBlank
    private String user_name;
    @NotBlank
    private String user_id;
    @NotBlank
    private String pwd;
    @NotBlank
    private String addr1;
    @NotBlank
    private String addr2;
    private String birthday;
    private String job_code;
    private String email;
    private int mileage;
    private String interest;
    private String user_state;
    private LocalDate regdate;
    private LocalDate modify_date;
    private LocalDate pwd_change_date;
    private LocalDate leave_date;
}
