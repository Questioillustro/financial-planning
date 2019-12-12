package com.brewster.financialplanning.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class LoanEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long dollarAmount;

    private Double apr;

    private String label;
}
