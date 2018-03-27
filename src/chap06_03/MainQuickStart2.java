package chap06_03;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainQuickStart2 {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:chap06_xml/asQuickStartAll2.xml");
		
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(2);
		ctx.close();
		
	}
}
