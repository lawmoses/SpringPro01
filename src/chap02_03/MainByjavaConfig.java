package chap02_03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap02.AuthenticationService;
import chap02.PasswordChangeService;

public class MainByjavaConfig {

	//�ٽ� �ĺ���
	
	
	public static void main(String[] args) {
		useSingleClass(); //�Ʒ��� private static void useSingleClass()�� �ҷ��´�.
		useMultipleClass(); //�Ʒ��� private static void useMultipleClass()�� �ҷ��´�.
	}
	
	//�̰� �����ϱ� ���ؼ��� Config�� ����  �� ��ܿ� @Configuration ������Ѵ�.
	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);
		useBean(ctx); //�ؿ� �ִ�.
		ctx.close(); //�ݾ��ش�.
	}

	//�̰� �����ϱ� ���ؼ��� Config�� ����  �� ��ܿ� @Configuration�� ��������Ѵ�.
	//Config1��  Config2�� ����  �� ��ܿ� @Configuration ������Ѵ�.
	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx); //�ؿ� �ִ�.
		ctx.close(); //�ݾ��ش�.
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
