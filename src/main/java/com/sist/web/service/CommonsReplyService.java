package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface CommonsReplyService {
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start);
	public int commonsReplyTotalPage(int cno);
	public void commonsReplyInsert(CommonsReplyVO vo);
	public void commonsReplyDelete(int no);
}
