package chap06_03;

public class ReadArticleServiceImpl implements ReadArticleService{

	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article read(Integer id) {
		System.out.println();
		System.out.printf("ReadArticleServiceImpl.read(%d) »£√‚µ \n", id);
		return articleDao.selectById(id);
	}
	
	
	
}
