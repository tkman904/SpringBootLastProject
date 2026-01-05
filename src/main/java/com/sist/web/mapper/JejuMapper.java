package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface JejuMapper {
	public List<JejuVO> jejuListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM jejutravel "
			+ "WHERE contenttype = #{contenttype}")
	public int jejuTotalPage(int contenttype);
}
