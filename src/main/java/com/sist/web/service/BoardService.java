package com.sist.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.sist.web.vo.*;

// 1. 게시판 / 댓글
public interface BoardService {
	public List<BoardVO> boardListData(int start);
	public int boardTotalPage();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public BoardVO boardUpdateData(int no);
	public String boardUpdate(BoardVO vo);
	public boolean booardDelete(int no, String pwd);
//	public void boardReplyCountUpdate(int replycount, int no);
}
