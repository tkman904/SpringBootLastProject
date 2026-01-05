package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

//	@Autowired
//	private SeoulMapper mapper;
//	
//	@Autowired
//	public SeoulServiceImpl(SeoulMapper mapper) {
//		this.mapper = mapper;
//	}

// 데이터베이스 관련
@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService {
	private final SeoulMapper mapper;

	@Override
	public List<SeoulVO> seoulLocationListData(int start) {
		// TODO Auto-generated method stub
		return mapper.seoulLocationListData(start);
	}

	@Override
	public int seoulLocationTotalPage() {
		// TODO Auto-generated method stub
		return mapper.seoulLocationTotalPage();
	}
}
