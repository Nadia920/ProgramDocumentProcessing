package com.company.B1.controller.dto;

import com.company.B1.model.ClassEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingBalanceDTO {
    private Double asset;
    private Double passive;
    private ClassEntity classEntity;
}
