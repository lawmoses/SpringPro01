package chap02_03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainByjavaConfig {

	//다시 쳐보기
	
	
	public static void main(String[] args) {
		useSingleClass(); //아래의 private static void useSingleClass()를 불러온다.
		useMultipleClass(); //아래의 private static void useMultipleClass()를 불러온다.
	}
	
	//이거 실행하기 위해서는 Config에 가서  맨 상단에 @Configuration 해줘야한다.
	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);
		useBean(ctx); //밑에 있다.
		ctx.close(); //닫아준다.
	}

	//이거 실행하기 위해서는 Config에 가서  맨 상단에 @Configuration를 지우줘야한다.
	//Config1과  Config2에 가서  맨 상단에 @Configuration 해줘야한다.
	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx); //밑에 있다.
		ctx.close(); //닫아준다.
	}

	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}
	
	
}
