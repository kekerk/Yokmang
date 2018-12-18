package chap7.xml;

public class ReadArticleServiceImpl implements ReadArticleService{
	
	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException{
		
		System.out.println("getArticleAndReadCnt("+id+") 호출됨");
		if(id==0) {
			throw new ArticleNotFoundException("id는 0이 안됨");
		}
		return new Article(id);
	}

}
