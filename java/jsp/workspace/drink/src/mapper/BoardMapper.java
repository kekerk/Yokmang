package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;
import model.Rec;
import model.Reply;

public interface BoardMapper {
	@Select("select ifnull(max(num),0) from board")
	int maxNum();
	
	@Insert("insert into board (num,name,pass,title,content,code,file1,regdate,readcnt)"
				+ " values(#{num},#{name},#{pass},#{title},#{content},#{code},#{file1},now(),0)")
	int insert(Board board);

	@Update("update board set readcnt=readcnt+1 where num=#{num}")
	int readcntadd(int num);

	@Update("update board set " 
		+" title=#{title}, content=#{content}, file1=#{file1} where num =#{num}")
	int update(Board bd);

	@Delete("delete  from board where num = #{num}")
	int delete(Board bd);
	
	@Delete("delete from reply where num = #{num}")
	int del(Board bd);
	
	@Insert("insert into reply (rnum,rating,rname,rcontent,num) "
			+ " values(#{rnum},#{rating},#{rname},#{rcontent},#{num})")
	int reply(Reply reply);
	
	@Select("select ifnull(max(rnum),0) from reply")
	int rpnum();
	
	@Delete("delete from reply where rnum=#{rnum}")
	int rdelete(Reply rp);

	
	@Select("select num,title,content,file1,avg from board b JOIN (select num n,ifnull(avg(rating),0) avg from reply group by num) a "+
	"on b.num=a.n order by avg desc")
	List<Rec> rank(List<Rec> list);


}
