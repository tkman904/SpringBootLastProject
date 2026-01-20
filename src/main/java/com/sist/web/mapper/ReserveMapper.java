package com.sist.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface ReserveMapper {
	public List<SeoulVO> seoulReserveData(Map map);
	public int seoulReserveTotalPage(Map map);
	
	// 예약 저장
	@Insert("INSERT INTO reserve_1(no, cno, id, rday, rtime, rinwon) "
			+ "VALUES(r1_no_seq.nextval, #{cno}, #{id}, #{rday}, #{rtime}, #{rinwon})")
	public void reserveInsert(ReserveVO vo);
	
//	@Results({
//		@Result(column = "title", property = "svo.title"),
//		@Result(column = "image1", property = "svo.image1"),
//		@Result(column = "address", property = "svo.address")
//	})
	@ResultMap("resMap")
	@Select("SELECT r.no, cno, rday, rtime, rinwon, "
			+ "TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday, "
			+ "isReserve, title, image1, address "
			+ "FROM reserve_1 r, seoultravel s "
			+ "WHERE r.cno = contentid "
			+ "AND id = #{id} "
			+ "ORDER BY no DESC")
	public List<ReserveVO> reserveMyData(String id);
	
	@ResultMap("resMap")
	@Select("SELECT r.no, cno, rday, rtime, rinwon, id, "
			+ "TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday, "
			+ "isReserve, title, image1, address "
			+ "FROM reserve_1 r, seoultravel s "
			+ "WHERE r.cno = contentid "
			+ "ORDER BY no DESC")
	public List<ReserveVO> reserveAdminData();
}
