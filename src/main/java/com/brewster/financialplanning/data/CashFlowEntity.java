package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class CashFlowEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long dollarAmount;

    private String label;

    private String debitType;

    private String flowType;
}
