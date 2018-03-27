package chap06_03;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ArticleCacheAspect {

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
	
}
