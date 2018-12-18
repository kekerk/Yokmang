package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Allboard;
import model.Comments;

public interface AllBoardMapper {
	@Select("select ifnull(max(no),0) from allboard")
	int maxNum();
	
	
	@Insert("insert into allboard "
			+ " (no,id,nickname,password,dormi,seriesno,seriesname,title,content,file1,regdate,readcnt,boardtype) "
			+ " values (#{no},#{id},#{nickname},#{password},#{dormi},#{seriesno},#{seriesname},#{title},#{content},#{file1},now(),0,#{boardtype})")
	int insert(Allboard Allboard);

	@Update("update allboard set " + " readcnt=readcnt+1 where no=#{no} and boardtype=#{boardtype}")
	int readcntadd(Allboard allboard);

	@Update("update  allboard set "
			+ " nickname=#{nickname},title=#{title},content=#{content},file1=#{file1} where no=#{no} and boardtype=#{boardtype}")
	int update(Allboard Allboard);


	@Delete("delete from allboard where no=#{no}")
	int delete(Allboard Allboard);

}
