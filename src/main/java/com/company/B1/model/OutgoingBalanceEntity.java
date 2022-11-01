package com.company.B1.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "outgoing_balance")
public class OutgoingBalanceEntity extends BaseEntity{
    @NotNull
    @Column(name = "asset")
    private Double asset;
    @NotNull
    @Column(name = "passive")
    private Double passive;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Long classId;

    public OutgoingBalanceEntity(Double asset, Double passive, ClassEntity classEntity) {}
}
