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
			System.out.println("[ACA] ĳ�ÿ��� Article[" + id + "] ����");
			return article;
		}
		Article ret = (Article) joinPoint.proceed();
		if (ret != null) {
			cache.put(id, ret);
			System.out.println();
			System.out.println("[ACA] ĳ�ÿ� Article[" + id + "] �߰���");
		}
		return ret;
	}
	
	
	
	
	@Pointcut("execution(public * net.madvirus.spring4.chap06.board..*(..))")
	private void profileTarget() {
	}

	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " ����");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
					(finish - start) + "ms");
		}
	}
	
	@AfterReturning(pointcut = "args(memberId,info)", returning = "result", argNames="joinPoint,memberId, info,result")
	public void traceReturn(JoinPoint joinPoint, String memberId, UpdateInfo info, boolean result) {
		System.out.printf("=============>  [TA] ���� ����: ���ȸ��=%s, ��������=%s, ���=%s\n",
				memberId, info, result);
	}
	
	/*
	 * pointcut�� �ɾ��ִ� �κ��̴�.
	 * "args(memberId,info)" �� �Ʒ��� String memberId, UpdateInfo info���� memberId, info�� �Ѿ�Եȴ�.
	 * boolean result �� ���� �Ѿ�� �ȴ�.
	 * */
	
	
	
}
