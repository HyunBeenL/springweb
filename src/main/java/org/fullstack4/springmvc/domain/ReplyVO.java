package org.fullstack4.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyVO {
    @PositiveOrZero
    private int idx;
    @PositiveOrZero
    private int bbs_idx;
    @NotBlank
    private String title;
    @NotBlank
    private String user_id;
    @NotBlank
    private LocalDate reg_date;
    @NotBlank
    private LocalDate modify_date;
}
