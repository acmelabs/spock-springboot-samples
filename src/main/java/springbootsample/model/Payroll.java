package springbootsample.model;

import lombok.Data;

import java.time.Month;

@Data
public class Payroll {
    private long payrollId;
    private long employeeId;
    private double amount;
    private Month month;
    private int year;
}
