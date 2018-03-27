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
		
		
		//������
		System.out.println();
		System.out.println();
		System.out.println("***************   xml read   ***************Xml ���� ���� ��");
		ctx.close(); //�̰� �ּ�ó�� �ϸ� destroy() �� ������ �ʴ´�.
	}
	
	private static void useJava() {
		System.out.println();
		System.out.println();
		System.out.println("=====   Java Meta   =====");
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ConfigForLifecycle.class);
		
		//������
		System.out.println();
		System.out.println();
		System.out.println("***************   annotation read   ***************annotation ���� ���� ��");
		ctx.close(); //�̰� �ּ�ó�� �ϸ� destroy() �� ������ �ʴ´�.
	}
	
}
