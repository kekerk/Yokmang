package chap9;

//구동 클래스 DaoTest 클래스의 main()메서드 에서 dbWork()메서드를 호출할때 

//
// OracleDao와 MySqlDao객체를 매개값으로 주고 호출합니다.
//
// dbWork()메서드는 두 객체를 모두 
//
// 매개값으로 받기 위해 DataAccessObject타입의 매개변수를 가지고 있습니다.
//
// 실행 결과를 보고 DataAccessObject 인터페이스와 OracleDao클래스, MySqlDao 클래스를 작성하시오.
//
//[결과]
//
//Oracle DB에서 검색
//
//Oracle DB에 삽입
//
//Oracle DB에 수정
//
//Oracle DB에서 삭제
//
//Mysql DB에서 검색
//
//Mysql DB에 삽입
//
//Mysql DB에 수정
//
//Mysql DB에서 삭제

interface DataAccessObject {
	
//	public static final int 상수명;
	
	public abstract void select();

	public abstract void insert();

	public abstract void update();

	public abstract void delete();

}

class Dao {
	String name;

	Dao(String name) {
		this.name = name;
	}
}

class OracleDao extends Dao implements DataAccessObject {

	OracleDao() {
		super("Oracle");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void select() {
		System.out.println(name + " DB에서 검색");

	}

	@Override
	public void insert() {
		System.out.println(name +" DB에서 삽입");

	}

	@Override
	public void update() {
		System.out.println(name +" DB에서 수정");

	}

	@Override
	public void delete() {
		System.out.println(name +" DB에서 삭제");

	}

}

class MySqlDao extends Dao implements DataAccessObject {

	MySqlDao() {
		super("Mysql");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void select() {
		System.out.println(name +" DB에서 검색");

	}

	@Override
	public void insert() {
		System.out.println(name +" DB에서 삽입");

	}

	@Override
	public void update() {
		System.out.println(name +" DB에서 수정");

	}

	@Override
	public void delete() {
		System.out.println(name +" DB에서 삭제");

	}

}

public class Q0813 {

	public static void main(String[] args) {

		dbWork(new OracleDao()); // 객체

		dbWork(new MySqlDao()); // 객체

	}

	private static void dbWork(DataAccessObject dao) {

		dao.select();

		dao.insert();

		dao.update();

		dao.delete();

	}

}
