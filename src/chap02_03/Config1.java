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
	//Autowired 로 해서 메소드가 아닌 변수로 연결해 준 것이다.
	// Config2의 public UserRepository userRepository()를 불러오기 위한 조치 이다.
	
	@Bean
	public PasswordChangeService pwChangeSvc() {
		// Config2에 있는 것이다.
		//return new PasswordChangeService(userRepository()); ==> (userRepository());를 메소드가 아닌 변수로 바꿔준다. (userRepository);
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
		// Config2에 있는 것이다.
		//authSvc.setUserRepository(userRepository()); ==> (userRepository());를 메소드가 아닌 변수로 바꿔준다. (userRepository);
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
	
	
	
}
