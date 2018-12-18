package chap9;

//���� Ŭ���� DaoTest Ŭ������ main()�޼��� ���� dbWork()�޼��带 ȣ���Ҷ� 

//
// OracleDao�� MySqlDao��ü�� �Ű������� �ְ� ȣ���մϴ�.
//
// dbWork()�޼���� �� ��ü�� ��� 
//
// �Ű������� �ޱ� ���� DataAccessObjectŸ���� �Ű������� ������ �ֽ��ϴ�.
//
// ���� ����� ���� DataAccessObject �������̽��� OracleDaoŬ����, MySqlDao Ŭ������ �ۼ��Ͻÿ�.
//
//[���]
//
//Oracle DB���� �˻�
//
//Oracle DB�� ����
//
//Oracle DB�� ����
//
//Oracle DB���� ����
//
//Mysql DB���� �˻�
//
//Mysql DB�� ����
//
//Mysql DB�� ����
//
//Mysql DB���� ����

interface DataAccessObject {
	
//	public static final int �����;
	
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
		System.out.println(name + " DB���� �˻�");

	}

	@Override
	public void insert() {
		System.out.println(name +" DB���� ����");

	}

	@Override
	public void update() {
		System.out.println(name +" DB���� ����");

	}

	@Override
	public void delete() {
		System.out.println(name +" DB���� ����");

	}

}

class MySqlDao extends Dao implements DataAccessObject {

	MySqlDao() {
		super("Mysql");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void select() {
		System.out.println(name +" DB���� �˻�");

	}

	@Override
	public void insert() {
		System.out.println(name +" DB���� ����");

	}

	@Override
	public void update() {
		System.out.println(name +" DB���� ����");

	}

	@Override
	public void delete() {
		System.out.println(name +" DB���� ����");

	}

}

public class Q0813 {

	public static void main(String[] args) {

		dbWork(new OracleDao()); // ��ü

		dbWork(new MySqlDao()); // ��ü

	}

	private static void dbWork(DataAccessObject dao) {

		dao.select();

		dao.insert();

		dao.update();

		dao.delete();

	}

}
