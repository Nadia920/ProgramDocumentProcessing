package com.company.B1.controller.dto;

import com.company.B1.model.ClassEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class TurnoversDTO {
    private Double debit;
    private Double credit;
    private ClassEntity classEntity;
}
