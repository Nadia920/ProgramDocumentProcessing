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
    @OneToMany(mappedBy = "accounting_accounts", fetch = FetchType.EAGER)
    private Set<AccountingAccountsEntity> accountingAccounts;
    @OneToMany(mappedBy = "incoming_balance", fetch = FetchType.EAGER)
    private Set<IncomingBalanceEntity> incomingBalance;
    @OneToMany(mappedBy = "turnovers", fetch = FetchType.EAGER)
    private Set<TurnoversEntity> turnoversEntity;
    @OneToMany(mappedBy = "outgoing_balance", fetch = FetchType.EAGER)
    private Set<OutgoingBalanceEntity> outgoingBalanceEntity;

}
