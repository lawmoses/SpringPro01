package chap03_c01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements 
	BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

	public void setProperty1 (String property1) {
		System.out.println("MyBean.setProperty1() 角青");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() 角青");
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware...context() 角青");
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() 角青");
		
	}
	
	//Xml俊辑 贸府
	public void customInit() {
		System.out.println("MyBean.customInit() 角青");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("@PostConstruct() 角青");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("@preDestroy() 角青");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() 角青");
		
	}
	
	//Xml俊辑 贸府
	public void customDestroy() {
		System.out.println("MyBean.customDestroy() 角青");
	}

}
