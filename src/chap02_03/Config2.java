package chap02_03;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.AuthFailLogger;
import chap02.AuthenticationService;
import chap02.PasswordChangeService;
import chap02.User;
import chap02.UserRepository;


@Configuration
public class Config2 {

	@Bean //xml의 <bean>이다. <bean id="user1" class="chap02.User">
	public User user1() {
		return new User("bkchoi", "1234"); //xml의 <constructor-arg value="bkchoi" /> <constructor-arg value="1234" /> 이다.
	}
	
	@Bean (name= "user2") //xml의 <bean>이다.  <bean id="user2" class="chap02.User">
	public User user() {
		return new User("madvirus", "qwer"); //xml의 <constructor-arg value="madvirus" /><constructor-arg value="qwer" />
	}
	
	@Bean
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
	
}
