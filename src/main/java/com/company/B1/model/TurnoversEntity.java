package com.company.B1.model;

import lombok.*;

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
@Table(name = "turnovers")
public class TurnoversEntity extends BaseEntity{
    @NotNull
    @Column(name = "debit")
    private Double debit;
    @NotNull
    @Column(name = "credit")
    private Double credit;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Long classId;

    public TurnoversEntity(Double debit, Double credit, ClassEntity classEntity) {}
}
