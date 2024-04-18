package org.fullstack4.springmvc.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BbsDTO {
    @PositiveOrZero
    private int idx;
    @NotBlank // Not null ,빈값x , 공백문자x
    //@NotEmpty // NOT null ,빈값x
    private String user_id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    @PositiveOrZero
    @Min(value=0)
    private int read_cnt;
    private String interest;

}

