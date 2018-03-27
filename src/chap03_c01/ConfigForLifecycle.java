package chap03_c01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForLifecycle {

	@Bean
	public MyBean mybean() {
		MyBean myBean = new MyBean();
		myBean.setProperty1("prop");
		return myBean;
	}
	
	@Bean 
	public ConnPool1 connPool1() {
		return new ConnPool1();
	}
	
	@Bean 
	public ConnPool2 connPool2() {
		return new ConnPool2();
	}

	@Bean (initMethod = "init", destroyMethod = "destroy")
	public ConnPool3 connPool3() {
		return new ConnPool3();
	}
	
	@Bean
	public MyExtension extention() {
		return new MyExtension();
	}
	
}
