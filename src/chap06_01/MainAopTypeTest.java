package chap06_01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAopTypeTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:chap06_xml/aopTypeTest.xml");
		
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("�ֹ���");
		ms.update("madvirus", updateInfo);
		ctx.close();
	}
	
	
	/*
	 * ���� updateInfo�� toString() �̴�.
	 * public String toString() {
		return "[newName=" + newName + "]";
		}
	
	*/
}

