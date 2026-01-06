package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface BusanService {
	public List<BusanVO> busanListData(Map map);
	public int busanTotalPage(int contenttype);
	public List<BusanVO> busanFindData(Map map);
	public int busanFindTotalPage(String address);
	public List<BusanVO> busanTop4Data();
}
