package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface SeoulMapper {
	/*
	  <select id="seoulListData" resultType="com.sist.web.vo.SeoulVO" parameterType="hashmap">
	    SELECT no, contentid, hit, title, image1, address
	    FROM seoultravel
	    WHERE contenttype = #{contenttype}
	    ORDER BY no ASC
	    OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY 
	  </select>
	 */
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM seoultravel "
			+ "WHERE contenttype = #{contenttype}")
	public int seoulTotalPage(int contenttype);
	
	/*
      <select id="seoulAttractionDetailData" resultMap="attMap" parameterType="int">
	    SELECT s.no, title, image1, address, x, y, infocenter, restdate, usetime, parking, msg
	    FROM seoultravel s JOIN attraction a
	    ON s.contentid = a.contentid
	    AND s.contentid = #{contentid}
	  </select>
	 */
	public SeoulVO seoulAttractionDetailData(int contentid);
	
	/*
      <update id="seoulHitIncrement" parameterType="int">
	    UPDATE seoultravel SET
	    hit = hit+1
	    WHERE contentid = #{contentid}
	  </update>
	 */
	public void seoulHitIncrement(int contentid);
}
