package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface CommonsReplyService {
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start);
	public int commonsReplyTotalPage(int cno);
	public void commonsReplyInsert(CommonsReplyVO vo);
	public void commonsMsgUpdate(CommonsReplyVO vo);
//	public void commonsAllReplyDelete(int group_id);
//	public void commonsMyReplyDelete(int no);
	public void commonsReplyDelete(int no);
	public void commonsReplyReplyInsert(CommonsReplyVO vo);
}
