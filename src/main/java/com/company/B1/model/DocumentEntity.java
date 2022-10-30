package com.company.B1.model;

import lombok.*;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "document")
public class DocumentEntity extends BaseEntity{
    @NotNull
    @Column(name = "name_organization")
    private String nameOrganization;
    @NotNull
    @Column(name = "document_name")
    private String documentName;
    @NotNull
    @Column(name = "document_description")
    private String documentDescription;
    @NotNull
    @Column(name = "date_of_submission")
    private Date dateOfSubmission;
    @OneToMany(mappedBy = "class", fetch = FetchType.EAGER)
    private Set<ClassEntity> classes;

    public DocumentEntity(String nameOrganization, String documentName, String documentDescription, Date dateOfSubmission) {}
}
