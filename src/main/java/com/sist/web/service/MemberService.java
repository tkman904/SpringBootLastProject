package com.sist.web.service;

import com.sist.web.vo.*;

public interface MemberService {
	public int memberIdCheck(String userid);
	public void memberInsert(MemberVO vo);
	public void memberAuthorityInsert(String userid);
	public MemberVO memberInfoData(String userid);
}
