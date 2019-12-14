package com.brewster.financialplanning.calc;

import com.brewster.financialplanning.data.AmortizationSchedule;
import com.brewster.financialplanning.data.FinanceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class AmortizationCalculations {

    public AmortizationSchedule getAmortization(FinanceEntity loan) {
        List<SnapShot> snapshots = new ArrayList<>();

        double principle = loan.getBalance();
        Calendar snapShotDate = Calendar.getInstance();

        SnapShot start = new SnapShot();
        start.setPrinciple(principle);
        start.setDate(snapShotDate);
        snapshots.add(start);

        AmortizationSchedule schedule = new AmortizationSchedule();

        while (principle > 0.0) {
            SnapShot ss = new SnapShot();
            principle += (principle * (loan.getAccrualAmount() / 100)) / 12;
            principle -= loan.getPayment();
            ss.setPrinciple(principle);

            snapShotDate.add(Calendar.MONTH, 1);
            ss.setDate(snapShotDate);
            snapshots.add(ss);

            if (principle <= 0.0) {
                schedule.setPayoffDate(snapShotDate);
            }
        }
        schedule.setLoan(loan);
        schedule.setSnapshots(snapshots);
        return schedule;
    }

    @Data
    @NoArgsConstructor
    public class SnapShot {
        Calendar date;
        double principle;
    }

}
