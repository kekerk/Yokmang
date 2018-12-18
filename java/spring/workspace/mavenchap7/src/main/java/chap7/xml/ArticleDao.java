package chap7.xml;

public interface ArticleDao {
	void insert(Article article);
	void updateReadCount(int id, int i);
}
