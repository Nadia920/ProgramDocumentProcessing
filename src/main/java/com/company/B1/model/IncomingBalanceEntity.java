package com.company.B1.model;

import lombok.*;


import org.hibernate.annotations.DynamicUpdate;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "incoming_balance")
public class IncomingBalanceEntity extends BaseEntity{
    @NotNull
    @Column(name = "asset")
    private Double asset;
    @NotNull
    @Column(name = "passive")
    private Double passive;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Long classId;
}
