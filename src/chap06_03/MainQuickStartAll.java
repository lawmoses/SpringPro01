package chap06_03;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06_01.MemberRegRequest;
import chap06_01.MemberService;
import chap06_01.UpdateInfo;
import chap06_02.NewArticleRequest;
import chap06_02.WriteArticleService;

public class MainQuickStartAll {

public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:chap06_xml/asQuickStartAll_in.xml");
		
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
		updateInfo.setNewName("ªı¿Ã∏ß");
		memberService.update("madvirus", updateInfo);
		
		ctx.close();
		
	}

}
