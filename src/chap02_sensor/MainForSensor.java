package chap02_sensor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSensor {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:chap02_04/config-sensor.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		ctx.close();

	}

}
