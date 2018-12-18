package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import model.Members;

public interface MembersMapper {
	
	@Insert( "insert into members "
	 	+  " (id,nickname,password,name,gender,tel,email,dormi,grade)"
	 	+  " values(#{id},#{nickname},#{password},#{name},#{gender},#{tel},#{email},#{dormi},#{grade})")
		int insert(Members mem);
	
	@Update( "update members set "	+  " nickname=#{nickname},tel=#{tel},email=#{email} where id=#{id}")
	int update(Members mem);
	
	@Delete("delete from members where id=#{id}" )
	int delete(Members mem);
	
	@Update("update members "+ " set password=#{password} where id=#{id}")
		int updatepass(Map<String,String> map);
	
	@Update("update members set boardcnt=boardcnt+1 where id=#{id}")
	int boardcnt(Map<String,String> map);
	
	@Update("update members set grade=grade+1 where id=#{id}")
	int gradeup(Map<String,String> map);
	
}
