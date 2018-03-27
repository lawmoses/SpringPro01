package bap;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEet {
	

		public static void main(String[] args) {
			
			/*String meal = "¾Æ¿ô¹é ½ºÅ×ÀÌÅ©";
		    String kind = "Àú³á";*/
			
			 /*Bap bap2 = new Bap();
			 meal = bap2.getMeal(meal);
			 kind = bap2.getKind(kind);*/
		      
			/*String meal = "¾Æ¿ô¹é ½ºÅ×ÀÌÅ©";
		    String kind = "Àú³á";*/
		      
		      GenericXmlApplicationContext ctx = 
		            new GenericXmlApplicationContext("bap/bap.xml");
		      Bap bap = ctx.getBean("insert", Bap.class);
		      bap.eat();
		      ctx.close();
		   }
		}





		