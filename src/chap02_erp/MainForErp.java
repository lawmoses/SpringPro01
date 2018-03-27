package chap02_erp;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap02_erp.ErpClient;

public class MainForErp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:chap02_04/config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory", ErpClientFactory.class);
		ErpClient client = factory.create();
		System.out.println("====================");
		client.connect();
		client.close();
		System.out.println("====================");
		ctx.close();
	}
}





