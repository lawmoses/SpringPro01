package chap.bap;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PartyAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:ms01/applicationContext.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		Party party = ctx.getBean("party", Party.class);
		party.party();
		
	}

}
