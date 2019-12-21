package com.brewster.financialplanning.calc;

import com.brewster.financialplanning.data.AmortizationSchedule;
import com.brewster.financialplanning.data.FinanceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.*;

@Component
public class AmortizationCalculations {

    public AmortizationSchedule getAmortization(FinanceEntity loan) {
        List<SnapShot> snapshots = new ArrayList<>();

        double principle = loan.getBalance();
        Calendar snapShotDate = getInstance();

        if (loan.getPaymentDate() == null) {
            loan.setPaymentDate(new Date());
        }

        snapShotDate.setTime(loan.getPaymentDate());

        SnapShot start = new SnapShot();
        start.setPrinciple(principle);
        start.setDate(snapShotDate);
        snapshots.add(start);

        AmortizationSchedule schedule = new AmortizationSchedule();
        schedule.setInterestPaid(0.0);

        while (principle > 0.0) {
            SnapShot ss = new SnapShot();

            double interest = principle * (loan.getAccrualAmount() / 100) / 12;
            schedule.setInterestPaid( schedule.getInterestPaid() + interest );
            principle += interest;

            principle -= loan.getPayment();
            ss.setPrinciple(principle);

            snapShotDate.add(MONTH, 1);
            ss.setDate(snapShotDate);
            snapshots.add(ss);

            if (principle <= 0.0) {
                schedule.setPayoffDate(ss.getDate());
            }
        }
        schedule.setInterestPaid( Math.round( schedule.getInterestPaid() ) );
        schedule.setLoan(loan);
        schedule.setSnapshots(snapshots);
        return schedule;
    }

    @Data
    @NoArgsConstructor
    public class SnapShot {
        String date;
        double principle;

        public void setDate(Calendar date) {
            SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
            this.date = format1.format(date.getTime());
        }
    }

}
