package chap06_04;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import chap06_01.UpdateInfo;
import chap06_03.Article;

@Aspect
public class AspectAll {
	
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();

	@Around("execution(public * *..ReadArticleService.*(..))")
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if (article != null) {
			System.out.println();
			System.out.println("[ACA] 캐시에서 Article[" + id + "] 구함");
			return article;
		}
		Article ret = (Article) joinPoint.proceed();
		if (ret != null) {
			cache.put(id, ret);
			System.out.println();
			System.out.println("[ACA] 캐시에 Article[" + id + "] 추가함");
		}
		return ret;
	}
	
	
	
	
	@Pointcut("execution(public * net.madvirus.spring4.chap06.board..*(..))")
	private void profileTarget() {
	}

	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
					(finish - start) + "ms");
		}
	}
	
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
