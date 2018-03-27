package bap;

import org.aspectj.lang.ProceedingJoinPoint;

public class WashHandAdvice2 {

	public void washHand2() {
		
		System.out.println();
		System.out.println("=============== Advice : Befre 의 Before 시작 ==================");
		System.out.println("A조는 어제 오랜만에 볼링장에 갔습니다.");
		System.out.println("A조는 2시간동안 볼링을 했습니다.");
		System.out.println("=============== Advice : Befre 의 Before 끝 ==================");
		System.out.println();
	}
}
