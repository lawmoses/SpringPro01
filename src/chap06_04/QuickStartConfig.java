package chap06_04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chap06_01.MemberServiceImpl;
import chap06_01.UpdateMemberInfoTraceAspect;
import chap06_02.WriteArticleServiceImpl;
import chap06_03.ArticleDao;
import chap06_03.MemoryArticleDao;
import chap06_03.ProfilingAspect;
import chap06_03.ReadArticleServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig {

	@Bean
	public ProfilingAspect performanceTraceAspect() {
		return new ProfilingAspect();
	}
	
	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}
	
	
	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}
	
	@Bean
	public WriteArticleServiceImpl writeArticleService() {
		return new WriteArticleServiceImpl(articleDao());
	}
	
	@Bean
	public MemberServiceImpl memberService() {
		return new MemberServiceImpl();
	}
	
	@Bean
	public ReadArticleServiceImpl readArticleService() {
		ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
		svc.setArticleDao(articleDao());
		return svc;
	}

	
	
}
