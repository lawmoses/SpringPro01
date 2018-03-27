package bap;

import org.aspectj.lang.ProceedingJoinPoint;

public class WashHandAdvice {

	public void washHand() {
		
		System.out.println();
		System.out.println("=============== Advice : Befre 시작 ==================");
		System.out.println("그 다음날");
		System.out.println("A조는 팀프로젝트를 위해 만났습니다.");
		System.out.println("A조는 밥 먹기 전에 손을 깨끗이 씻습니다");
		System.out.println("=============== Advice : Befre 끝 ==================");
		System.out.println();
	}
}
