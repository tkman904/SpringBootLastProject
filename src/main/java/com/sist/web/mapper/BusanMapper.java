package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface BusanMapper {
	public List<BusanVO> busanListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM busantravel "
			+ "WHERE contenttype = #{contenttype}")
	public int busanTotalPage(int contenttype);
	
	/*
      <select id="busanFindData" resultType="com.sist.web.vo.BusanVO" parameterType="hashmap">
	    SELECT no, contentid, hit, title, image1, address, contenttype
	    FROM busantravel
	    WHERE address LIKE '%'||#{address}||'%'
	    ORDER BY no ASC
	    OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY
	  </select>
	
	  <select id="busanFindTotalPage" resultType="int" parameterType="string">
	    SELECT CEIL(COUNT(*)/12.0)
	    FROM busantravel
	    WHERE address LIKE '%'||#{address}||'%'
	  </select>
	 */
	public List<BusanVO> busanFindData(Map map);
	public int busanFindTotalPage(String address);
	
	/*
      <select id="busanTop4Data" resultType="com.sist.web.vo.BusanVO">
	    SELECT no, contentid, hit, title, image1, address, ROWNUM
	    FROM (SELECT no, contentid, hit, title, image1, address
	    FROM busantravel ORDER BY hit DESC)
	    WHERE ROWNUM&lt;=4
	  </select>
	 */
	public List<BusanVO> busanTop4Data();
}
