package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface ReserveService {
	public List<SeoulVO> seoulReserveData(Map map);
	public int seoulReserveTotalPage(Map map);
	public String reserveInsert(ReserveVO vo);
	public List<ReserveVO> reserveMyData(String id);
	public List<ReserveVO> reserveAdminData();
}
