package com.sist.web.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;

import lombok.RequiredArgsConstructor;

/*
 *   VO / Entity / DTO / Record
 *    |     |       |      | getter => Kotlin (data)
 *    |     |    getter / setter
 *    |   테이블 제어 (컬럼과 일치)
 *    |     => JPA
 *   불변 (setter가 없다)
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService, BoardReplyService {
	private final BoardMapper mapper;
	private final BoardReplyMapper bMapper;
	
	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return mapper.boardListData(start);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return mapper.boardDetailData(no);
	}

	@Override
	public String boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		String result = "no";
		String db_pwd = mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result = "yes";
			mapper.boardUpdate(vo);
		}
		
		return result;
	}

	@Override
	public boolean booardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		String db_pwd = mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			mapper.boardDelete(no);
			return true;
		}
		
		return false;
	}

	// 댓글
	@Override
	public List<BoardReplyVO> boardReplyListData(int bno) {
		// TODO Auto-generated method stub
		return bMapper.boardReplyListData(bno);
	}

	@Override
	public int boardReplyCount(int bno) {
		// TODO Auto-generated method stub
		int count = bMapper.boardReplyCount(bno);
		mapper.boardReplyCountUpdate(count, bno);
		
		return count;
	}

	@Override
	public void boardReplyInsert(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		bMapper.boardReplyInsert(vo);
	}

	@Override
	public void boardReplyDelete(int no) {
		// TODO Auto-generated method stub
		bMapper.boardReplyDelete(no);
	}

	@Override
	public void boardReplyUpdate(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		bMapper.boardReplyUpdate(vo);
	}
}
