package chap7.spring;

public class MariadbArticleDao implements ArticleDao{
	public void insert() {
		System.out.println("MariadbArticleDao.insert() 메서드 호출");
	}
}
