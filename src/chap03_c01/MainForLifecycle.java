package chap03_c01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForLifecycle {

	public static void main(String[] args) {
		useXml();
		useJava();
	}
	
	private static void useXml() {
		System.out.println();
		System.out.println();
		System.out.println("=====   XML Meta   =====");
		String configLocation = "classpath:chap03_xml/config-for-lifecycle.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		
		//선생님
		System.out.println();
		System.out.println();
		System.out.println("***************   xml read   ***************Xml 에서 읽은 것");
		ctx.close(); //이거 주석처리 하면 destroy() 가 나오지 않는다.
	}
	
	private static void useJava() {
		System.out.println();
		System.out.println();
		System.out.println("=====   Java Meta   =====");
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ConfigForLifecycle.class);
		
		//선생님
		System.out.println();
		System.out.println();
		System.out.println("***************   annotation read   ***************annotation 에서 읽은 것");
		ctx.close(); //이거 주석처리 하면 destroy() 가 나오지 않는다.
	}
	
}
