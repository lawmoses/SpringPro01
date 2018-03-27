package chap.bap;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class Party implements  InitializingBean{
	List <String> foods;
	Person person;

	
	public void party() {
		person.getFriend();
		System.out.println(foods);
	}
	
	public void setFood(List <String> foods) {
		this.foods=foods;
	}
	
	public void setPerson(Person person) {
		this.person=person;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		person.bap();
	}
	
	
	
}
