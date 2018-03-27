package chap06_01;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UpdateMemberInfoTraceAspect {

	@AfterReturning(pointcut = "args(memberId,info)", returning = "result", argNames="joinPoint,memberId, info,result")
	public void traceReturn(JoinPoint joinPoint, String memberId, UpdateInfo info, boolean result) {
		System.out.printf("=============>  [TA] 정보 수정: 대상회원=%s, 수정정보=%s, 결과=%s\n",
				memberId, info, result);
	}
	
	/*
	 * pointcut을 걸어주는 부분이다.
	 * "args(memberId,info)" 가 아래의 String memberId, UpdateInfo info에서 memberId, info로 넘어가게된다.
	 * boolean result 도 같이 넘어가게 된다.
	 * */
	
}





