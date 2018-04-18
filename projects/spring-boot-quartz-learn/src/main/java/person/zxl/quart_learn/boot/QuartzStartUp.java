package person.zxl.quart_learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import person.zxl.quart_learn.boot.config.DataSourceConfig;
import person.zxl.quart_learn.boot.config.SchedulerConfig;

@SpringBootApplication
@Import({DataSourceConfig.class, SchedulerConfig.class})
public class QuartzStartUp {
	
	public static void main(String[] args) {
		SpringApplication.run(QuartzStartUp.class, args);
	}

}
