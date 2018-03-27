package chap02_03;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;


@Configuration
public class Config1 {
	
	@Autowired
	public UserRepository userRepository;
	//Autowired �� �ؼ� �޼ҵ尡 �ƴ� ������ ������ �� ���̴�.
	// Config2�� public UserRepository userRepository()�� �ҷ����� ���� ��ġ �̴�.
	
	@Bean
	public PasswordChangeService pwChangeSvc() {
		// Config2�� �ִ� ���̴�.
		//return new PasswordChangeService(userRepository()); ==> (userRepository());�� �޼ҵ尡 �ƴ� ������ �ٲ��ش�. (userRepository);
		return new PasswordChangeService(userRepository);
	}
	
	@Bean 
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean 
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		// Config2�� �ִ� ���̴�.
		//authSvc.setUserRepository(userRepository()); ==> (userRepository());�� �޼ҵ尡 �ƴ� ������ �ٲ��ش�. (userRepository);
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
	
	
	
}
