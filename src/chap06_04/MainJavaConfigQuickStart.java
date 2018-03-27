package chap06_04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap06_01.MemberRegRequest;
import chap06_01.MemberService;
import chap06_01.UpdateInfo;
import chap06_02.NewArticleRequest;
import chap06_02.WriteArticleService;
import chap06_03.ReadArticleService;

public class MainJavaConfigQuickStart {

public static void main(String[] args) {
		
		/*GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:chap06_xml/asQuickStartAll_in.xml");*/
		
		// QuickStartConfig.java에서 
		// @Configuration
		// @EnableAspectJAutoProxy
		// @Bean
		// Annotation 방식을 해주기 위해 위의 GenericXmlApplicationContext 를 AnnotationConfigApplicationContext로 바꿨음.
		//
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartConfig.class);
		
		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		System.out.println();
		System.out.println("=========================================");
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(2);
		
		System.out.println();
		System.out.println("=========================================");
		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRegRequest memberRegReq = new MemberRegRequest("id", "name", "password");
		memberService.regist(memberRegReq);
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("새이름");
		memberService.update("madvirus", updateInfo);
		
		ctx.close();
		
	}

}
