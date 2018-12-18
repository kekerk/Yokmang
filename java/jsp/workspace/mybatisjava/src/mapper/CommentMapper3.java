package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatis.Comment;

/*
 * interface�� �̿��� mybatis ����ϱ�.
 * 1. xml�� ������ ��� interface ������� ������ ���� ���� -> ���� �±� ����� ��� �Ұ�
 * 
 * 2. �ݵ�� �ֵ��� xml�� mybatis-config.xml(��������)d�� ����ؾ��Ѵ�.
 * 		�� ��, �ֵ��� xml�� namespace�� ��Ű��.�������̽������� �����ؾ���.
 * 
 * 3. �������̽��� �̸��� namespace��.
 * 4.	�������̽��� �޼����̸���  id �Ӽ����̴�.
 * 		�������̽��� �޼����̸��� �����ε� �Ǹ� �ȵ�.
 * 		�ֵ��� xml�� id�� ���� �޼����̸��� �� �� ����.
 * 
 * 5. �������̽��� �ֵ��� xml�� ���ÿ� ������ ������.
 * 		���� �ֵ��� xml�� ���� �±� �κ��� ����Ѵ�.
 */
public interface CommentMapper3 {
	@Select("select * from comment")
	List<Comment> select(); //select ��ü�� id�� �ߺ� �Ұ�. �Ű���������� �־ �ȵ�. �����ε� �Ұ�.
	
	@Insert("insert into comment (no,id,content,regdate) "+" values (#{no},#{id},#{content},#{regdate})")
	int  insert(Comment comment);
	
	@Update("update comment set id=#{id}, content=#{content},regdate=#{regdate} where no=#{no}")
	int update(Comment comment);
	
	@Delete("delete from comment where no=#{no}")
	int delete(int num);
}

