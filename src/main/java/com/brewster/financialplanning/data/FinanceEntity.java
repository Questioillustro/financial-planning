package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class FinanceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Double balance;

    private String label;

    private Double accrualAmount;

    private String accrualType;

    private String financeType;

    private String accrualFrequency;
}
