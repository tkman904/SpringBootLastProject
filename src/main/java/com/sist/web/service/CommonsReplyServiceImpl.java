package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;
/*
 *   Service : DataBase, OpenAPI, AI => 요청처리 => Back-End의 중심
 *   => Security : BI
 *   
 *   Repository : 오라클 / MySQL만 연동
 *   ------------------------------
 *      | DispatcherServlet : 요청 / 응답 => FrontController
 *   Controller : 결과값을 받아서 브라우저로 전송
 *      | Front-End => 조립 => 결과값 추출
 *   
 *   Component : 기타
 *      | AOP / Task / Batch
 *      
 *   = Controller
 *   = RestController :데이터 전송
 *   
 *   Server ====== Client
 *     |
 *   순수하게 서버 역할만...(화면 제어가 없다) => Front에서 자체 처리
 *                                     router => Vue/React
 */
@Service
@RequiredArgsConstructor
public class CommonsReplyServiceImpl implements CommonsReplyService{
	private final CommonsReplyMapper mapper;

	@Override
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start) {
		// TODO Auto-generated method stub
		return mapper.commonsReplyListData(cno, start);
	}

	@Override
	public int commonsReplyTotalPage(int cno) {
		// TODO Auto-generated method stub
		return mapper.commonsReplyTotalPage(cno);
	}

	@Override
	public void commonsReplyInsert(CommonsReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.commonsReplyInsert(vo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void commonsReplyDelete(int no) {
		// TODO Auto-generated method stub
		CommonsReplyVO vo = mapper.commonsInfoData(no);
		if(vo.getDepth() == 0) {
			mapper.commonsReplyDelete(no);
		} else {
			CommonsReplyVO rvo = new CommonsReplyVO();
			rvo.setNo(no);
			rvo.setMsg("이미 삭제된 댓글 입니다");
			mapper.commonsMsgUpdate(rvo);
			mapper.commonsDepthDecrement(vo.getRoot());
		}
	}
}
