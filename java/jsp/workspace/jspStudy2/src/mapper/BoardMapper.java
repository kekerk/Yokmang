package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;

public interface BoardMapper {
@Select("select ifnull(max(num),0) from board")
int maxNum();
	
@Insert( "insert into board "
+ " (num,name,pass,title,content,file1,regdate,readcnt,ref,reflevel,refstep) " 
+ " values (#{num},#{name},#{pass},#{title},#{content},#{file1},now(),0,#{ref},#{reflevel},#{refstep}) ")
int insert(Board board);

@Update("update  board set "	+  " readcnt=readcnt+1 where num=#{num}")
int readcntadd(int num);

@Update( "update  board set " + " name=#{name},title=#{title},content=#{content},file1=#{file1} where num=#{num}")
int update(Board board);

@Update( "update board set refstep = refstep+1 "+ " where ref=#{ref} and refstep > #{refstep} ") // 기존의 답글이 있는 경우 refstep을 1씩 증가시켜서 위치 재설정
void refstepadd(Map map);

@Delete("delete from board where num=#{num}")
int delete(Board board);
}
