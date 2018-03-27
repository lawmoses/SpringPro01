package chap06_02;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06_01.MemberRegRequest;
import chap06_01.MemberService;
import chap06_01.UpdateInfo;
import chap06_03.ReadArticleService;

public class MainQuickStart {

				
		public static void main(String[] args) {
			GenericXmlApplicationContext ctx =
					new GenericXmlApplicationContext("classpath:acQuickStart.xml");

			WriteArticleService writeArticleService =
					ctx.getBean("writeArticleService", WriteArticleService.class);
			writeArticleService.write(new NewArticleRequest("writer", "title", "content"));

			ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
			readArticleService.read(1);
			readArticleService.read(1);

			MemberService memberService = ctx.getBean(MemberService.class);
			MemberRegRequest memberRegReq =
					new MemberRegRequest("id", "name", "pw");
			memberService.regist(memberRegReq);

			UpdateInfo updateInfo = new UpdateInfo();
			updateInfo.setNewName("ªı¿Ã∏ß");
			memberService.update("madvirus", updateInfo);

			ctx.close();

	}

}
