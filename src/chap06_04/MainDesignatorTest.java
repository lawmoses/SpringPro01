package chap06_04;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06_02.NewArticleRequest;
import chap06_02.WriteArticleService;
import chap06_03.ReadArticleService;

public class MainDesignatorTest {

	public static void main(String[] args) {
		

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap06_xml/designatorTest.xml");

		
		WriteArticleService writeScv =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeScv.write(new NewArticleRequest("writer", "title", "content"));
		
		ReadArticleService readSvc = ctx.getBean("readArticleService", ReadArticleService.class);
		System.out.println("---------- 첫 번째 readSvc.read(1)");
		readSvc.read(1);
		
		System.out.println("---------- 두 번째 readSvc.read(1)");
		readSvc.read(1);
		
		ctx.close();
		
	}

}
