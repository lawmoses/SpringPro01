package chap06_03;

public interface ArticleDao {

	void insert(Article article);

	Article selectById(Integer id);
	
}
