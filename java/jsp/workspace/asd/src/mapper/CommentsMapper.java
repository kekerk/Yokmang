package mapper;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Comments;

public interface CommentsMapper {
	@Select("select ifnull(max(ref_no),0) from comments")
	int maxreplyNo();
	
	@Insert("insert into comments "
			+ " (no,ref_no,id,nickname,dormi,grade,content,boardtype) "
			+ " values (#{no},#{ref_no},#{id},#{nickname},#{dormi},#{grade},#{content},#{boardtype})")
	int insert(Comments comments);
	
	@Delete("delete from comments where ref_no=#{ref_no}")
	int delete(Comments Comments);
	
	@Delete("delete from comments where no=#{no}")
	int deleteall(Comments Comments);
	

}
