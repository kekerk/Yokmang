package test;


public class Project {

	private OracleArticleDao articleDao;

	private String dir;

	public void test() {

		System.out.println("프로젝트 테스트 시작");

		articleDao.insert(articleDao + "insert 메서드 실행됨");

	}
	// dir과 articleDao의 getter setter 생성
	// project 빈 객체의 dir과 articleDao를 위해 생성
	public OracleArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(OracleArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
}