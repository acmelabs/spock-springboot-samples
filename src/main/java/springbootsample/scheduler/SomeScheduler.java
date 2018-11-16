package springbootsample.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springbootsample.service.PayrollService;

@Slf4j
@Component
public class SomeScheduler {

    private final PayrollService payrollService;

    public SomeScheduler(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @Scheduled(cron = "${sample.cron-schedule}", zone = "${sample.cron-schedule-timezone}")
    @SchedulerLock(name = "pendingPayrollsScheduler")
    public void process() {
        payrollService.processPayrolls();
    }
}