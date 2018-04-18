package person.zxl.quart_learn.boot.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import person.zxl.quart_learn.boot.config.SchedulerConfig;

@Import({SchedulerConfig.class})
public class Application implements ApplicationContextAware{

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SchedulerFactoryBean schedulerFactoryBean = (SchedulerFactoryBean) applicationContext.getBean("schedulerFactoryBean");
		System.out.println(schedulerFactoryBean.getScheduler());
	}
	
	public void run() {
		System.out.println("2314234");
	}
	
	public static void main(String[] args) {
		String str = "_32";
		String[] arr = str.split("_");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}

}
