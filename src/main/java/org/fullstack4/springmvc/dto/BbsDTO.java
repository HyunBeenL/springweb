package org.fullstack4.springmvc.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;


@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BbsDTO {
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private String display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private int read_cnt;

}

