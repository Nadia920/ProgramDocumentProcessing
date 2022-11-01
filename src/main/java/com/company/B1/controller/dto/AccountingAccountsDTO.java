package com.company.B1.controller.dto;

import com.company.B1.model.ClassEntity;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountingAccountsDTO {

    private Integer accountNumber;
    private String сomponentsAccount;
    private ClassEntity classEntity;
}

