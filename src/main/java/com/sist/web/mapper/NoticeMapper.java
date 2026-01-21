package com.sist.web.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface NoticeMapper {
	@Select("SELECT no, type, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') AS dbday, hit "
			+ "FROM notice_1 "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<NoticeVO> noticeListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM notice_1")
	public int noticeTotalPage();
	
	@Insert("INSERT INTO notice_1(no, type, subject, content, filename, filecount) "
			+ "VALUES(no1_no_seq.nextval, #{type}, #{subject}, #{content}, #{filename}, #{filecount})")
	public void noticeInsert(NoticeVO vo);
	
	@Update("UPDATE notice_1 SET "
			+ "hit = hit+1 "
			+ "WHERE no = #{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, type, name, subject, content, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday, hit, filename, filecount "
			+ "FROM notice_1 "
			+ "WHERE no = #{no}")
	public NoticeVO noticeDetailData(int no);
	
	@Select("SELECT filename, filecount "
			+ "FROM notice_1 "
			+ "WHERE no = #{no}")
	public NoticeVO noticeFileInfoData(int no);
	
	@Delete("DELETE FROM notice_1 "
			+ "WHERE no = #{no}")
	public void noticeDelete(int no);
	
	@Update("UPDATE notice_1 SET "
			+ "type = #{type}, subject = #{subject}, content = #{content} "
			+ "WHERE no = #{no}")
	public void noticeUpdate(NoticeVO vo);
}
