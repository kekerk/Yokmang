package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatis.Comment;

/*
 * interface를 이용한 mybatis 사용하기.
 * 1. xml의 설정을 모두 interface 방식으로 변경할 수는 없음 -> 동적 태그 방식은 사용 불가
 * 
 * 2. 반드시 쌍둥이 xml을 mybatis-config.xml(설정파일)d에 등록해야한다.
 * 		이 때, 쌍둥이 xml의 namespace는 패키지.인터페이스명으로 설정해야함.
 * 
 * 3. 인터페이스의 이름은 namespace다.
 * 4.	인터페이스의 메서드이름이  id 속성값이다.
 * 		인터페이스의 메서드이름은 오버로딩 되면 안됨.
 * 		쌍둥이 xml의 id에 같은 메서드이름을 쓸 수 없다.
 * 
 * 5. 인터페이스와 쌍둥이 xml은 동시에 설정이 가능함.
 * 		보통 쌍둥이 xml에 동적 태그 부분을 사용한다.
 */
public interface CommentMapper3 {
	@Select("select * from comment")
	List<Comment> select(); //select 자체가 id라서 중복 불가. 매개변수목록을 넣어도 안됨. 오버로딩 불가.
	
	@Insert("insert into comment (no,id,content,regdate) "+" values (#{no},#{id},#{content},#{regdate})")
	int  insert(Comment comment);
	
	@Update("update comment set id=#{id}, content=#{content},regdate=#{regdate} where no=#{no}")
	int update(Comment comment);
	
	@Delete("delete from comment where no=#{no}")
	int delete(int num);
}

