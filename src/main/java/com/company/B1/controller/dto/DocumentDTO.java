package com.company.B1.controller.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private String nameOrganization;
    private String documentName;
    private String documentDescription;
    private Date dateOfSubmission;
}
