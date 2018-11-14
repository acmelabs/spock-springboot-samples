package springbootsample.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalaryReceipt {
    private long payrollId;
    private LocalDateTime payTime;
}
