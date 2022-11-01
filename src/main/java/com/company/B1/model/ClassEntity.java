package com.company.B1.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "class")
public class ClassEntity extends BaseEntity{
    @NotNull
    @Column(name = "class_name")
    private String className;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "document_id")
    private Long documentId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "accountingAccountsEntity")
    private Set<AccountingAccountsEntity> accountingAccounts;
    @OneToMany(mappedBy = "incomingBalanceEntity", fetch = FetchType.EAGER)
    private Set<IncomingBalanceEntity> incomingBalance;
    @OneToMany(mappedBy = "turnoversEntity", fetch = FetchType.EAGER)
    private Set<TurnoversEntity> turnoversEntity;
    @OneToMany(mappedBy = "outgoingBalanceEntity", fetch = FetchType.EAGER)
    private Set<OutgoingBalanceEntity> outgoingBalanceEntity;

    public ClassEntity(String className, DocumentEntity documentEntity) {
    }
}
