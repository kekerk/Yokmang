package mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Update;

public interface ActornSeriesMapper {
	@Update("update series set seriescnt=seriescnt+1 where seriesno=#{seriesno}")
	int seriescnt(Map<String,Object> map);
}
