package com.company.B1.controller.dto;

import com.company.B1.model.DocumentEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {
    private String className;
    private DocumentEntity documentEntity;
}
