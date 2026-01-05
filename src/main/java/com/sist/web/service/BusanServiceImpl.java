package com.sist.web.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {
	private final BusanMapper mapper;

	@Override
	public List<BusanVO> busanListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.busanListData(map);
	}

	@Override
	public int busanTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return mapper.busanTotalPage(contenttype);
	}
}
