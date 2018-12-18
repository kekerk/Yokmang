package chap7.xml;

public interface ReadArticleService {
	Article getArticleAndReadCnt(int id) throws ArticleNotFoundException;
}
