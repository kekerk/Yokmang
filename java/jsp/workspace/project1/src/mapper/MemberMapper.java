package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface MemberMapper {
	@Insert( "insert into member "
	 	+  " (id,pass,name,gender,tel,email,picture)"
	 	+  " values(#{id},#{pass},#{name},#{gender},#{tel},#{email},#{picture})")
		int insert(Member mem);
	
	@Update( "update member set "	+  " name=#{name},gender=#{gender},tel=#{tel},email=#{email},picture=#{picture} where id=#{id}")
	int update(Member mem);
	
	@Delete("delete from member where id=#{id}" )
	int delete(Member mem);
	
	@Update("update member "+ " set pass=#{pass} where id=#{id}")
		int updatepass(Map<String,String> map);
	
}
