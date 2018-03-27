package chap02_04;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainByXmlNamespace {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ctx = 
					new GenericXmlApplicationContext("classpath:chap02_04/Config-aaa-*.xml");
					//�Ǽ� : ("classpath:chap02_04/Config-aaa-*.xml"); ���� chap02_04/�� ���߷ȴ�. ���߸��� ���� ���Ѵ�.
		
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
			pwChgSvc.changePassword("bkchoi", "1234", "5678");
			authSvc.authenticate("bkchoi", "5678");
		
		ctx.close(); //�ݴ� ��.
	}
	
}
