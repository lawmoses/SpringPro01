package chap02_03;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;

//MainByJavaPackage���� ��Ű�� ������ �ҷ����� ���ؼ� Config�� ��� ���ϰ� Config1, Config2 �� ����ϱ� ���ؼ�  @Configuration �ּ� ó�� ���� �� �ִ�.

//@Configuration
//�Ǽ� : @Configuration ���߷ȴ�.

@Configuration
public class Config {

	@Bean //xml�� <bean>�̴�. <bean id="user1" class="chap02.User">
	public User user1() {
		return new User("bkchoi", "1234"); //xml�� <constructor-arg value="bkchoi" /> <constructor-arg value="1234" /> �̴�.
	}
	
	@Bean (name= "user2") //xml�� <bean>�̴�.  <bean id="user2" class="chap02.User">
	public User user() {
		return new User("madvirus", "qwer"); //xml�� <constructor-arg value="madvirus" /><constructor-arg value="qwer" />
	}
	
	@Bean //xml�� <bean>�̴�. 
	public UserRepository userRepository() { //xml�� <bean id="userRepository" class="chap02.UserRepository">
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(),user()));
		/* 
		 * xml��
		 * <property name="users">
				<list>
					<ref bean="user1" />
					<ref bean="user2" />
				</list>
			</property>
			*/
		return userRepo;
	}
	
	@Bean //xml�� <bean>�̴�. 
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
	}
	
	@Bean  //xml�� <bean>�̴�. 
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


