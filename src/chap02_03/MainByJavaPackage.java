package chap02_03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainByJavaPackage {

	//안됨.
	
	public static void main(String[] args) {
		//어노테이션이 아닌 패키지로 불러올 수도 있다. 패키지에 있는 Config1, Config2를 불러오기 위한 것이다. Config는 사용하지 않으므로 상단의 @Configuration를 주석처리 해주었다.
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext("chap02_03"); //패키지로 바꾼다.
	
		AuthenticationService authSvc =
					ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
	
		PasswordChangeService pwChgSvc = 
					ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	
		ctx.close(); //닫아준다.
		
	}
	
}
