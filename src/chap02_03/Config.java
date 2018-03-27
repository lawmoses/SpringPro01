package chap02_03;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;

//MainByJavaPackage에서 패키지 명으로 불러오기 위해서 Config는 사용 안하고 Config1, Config2 만 사용하기 위해서  @Configuration 주석 처리 해줄 수 있다.

//@Configuration
//실수 : @Configuration 빠뜨렸다.

@Configuration
public class Config {

	@Bean //xml의 <bean>이다. <bean id="user1" class="chap02.User">
	public User user1() {
		return new User("bkchoi", "1234"); //xml의 <constructor-arg value="bkchoi" /> <constructor-arg value="1234" /> 이다.
	}
	
	@Bean (name= "user2") //xml의 <bean>이다.  <bean id="user2" class="chap02.User">
	public User user() {
		return new User("madvirus", "qwer"); //xml의 <constructor-arg value="madvirus" /><constructor-arg value="qwer" />
	}
	
	@Bean //xml의 <bean>이다. 
	public UserRepository userRepository() { //xml의 <bean id="userRepository" class="chap02.UserRepository">
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(),user()));
		/* 
		 * xml의
		 * <property name="users">
				<list>
					<ref bean="user1" />
					<ref bean="user2" />
				</list>
			</property>
			*/
		return userRepo;
	}
	
	@Bean //xml의 <bean>이다. 
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
	}
	
	@Bean  //xml의 <bean>이다. 
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}
	
	
}


