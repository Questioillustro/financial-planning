package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

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

    private Double payment;

    private Calendar paymentDate;

    private String accrualType;

    private String financeType;

    private String accrualFrequency;
}
