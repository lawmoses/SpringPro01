package chap06_03;


import org.springframework.context.support.GenericXmlApplicationContext;

import chap06_02.NewArticleRequest;
import chap06_02.WriteArticleService;


public class MainQuickStart1 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:chap06_xml/acQuickStart.xml");

		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		   
		ctx.close();
	}
}
