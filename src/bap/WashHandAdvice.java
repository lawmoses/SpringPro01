package bap;

import org.aspectj.lang.ProceedingJoinPoint;

public class WashHandAdvice {

	public void washHand() {
		
		System.out.println();
		System.out.println("=============== Advice : Befre ���� ==================");
		System.out.println("�� ������");
		System.out.println("A���� ��������Ʈ�� ���� �������ϴ�.");
		System.out.println("A���� �� �Ա� ���� ���� ������ �Ľ��ϴ�");
		System.out.println("=============== Advice : Befre �� ==================");
		System.out.println();
	}
}
