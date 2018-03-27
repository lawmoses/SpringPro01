package chap06_02;

import chap06_03.Article;
import chap06_03.ArticleDao;

public class WriteArticleServiceImpl implements WriteArticleService {

	
	private ArticleDao articleDao;

	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public void write(NewArticleRequest newArticleReq) {
		System.out.println("WriteArticleServiceImpl.write() »£√‚µ ");
		Article article = toArticle(newArticleReq);
		articleDao.insert(article);
	}
	
	private Article toArticle(NewArticleRequest newArticleReq) {
		return new Article(
				newArticleReq.getWriterName(),
				newArticleReq.getTitle(),
				newArticleReq.getContent());
	}


	
	
	
}
