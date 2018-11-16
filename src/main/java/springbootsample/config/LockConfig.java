package springbootsample.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.SpringLockableTaskSchedulerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.sql.DataSource;
import java.time.Duration;

public class LockConfig {
    public static final int MAX_LOCK_HOLD_MINS = 300000;
    public static final int MIN_LOCK_HOLD_MINS = 60000;

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource);
    }

    @Bean
    public TaskScheduler taskScheduler(LockProvider lockProvider) throws Exception {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        SpringLockableTaskSchedulerFactoryBean factoryBean = new SpringLockableTaskSchedulerFactoryBean(taskScheduler, lockProvider, Duration.ofMillis(MAX_LOCK_HOLD_MINS), Duration.ofMillis(MIN_LOCK_HOLD_MINS));
        return factoryBean.getObject();
    }
}