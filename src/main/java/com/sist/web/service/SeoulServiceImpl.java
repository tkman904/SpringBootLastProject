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
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.seoulListData(map);
	}

	@Override
	public int seoulTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return mapper.seoulTotalPage(contenttype);
	}

	@Override
	public SeoulVO seoulAttractionDetailData(int contentid) {
		// TODO Auto-generated method stub
		mapper.seoulHitIncrement(contentid);
		return mapper.seoulAttractionDetailData(contentid);
	}

	@Override
	public List<SeoulVO> seoulFindData(Map map) {
		// TODO Auto-generated method stub
		return mapper.seoulFindData(map);
	}

	@Override
	public int seoulFindTotalPage(String address) {
		// TODO Auto-generated method stub
		return mapper.seoulFindTotalPage(address);
	}

	@Override
	public List<SeoulVO> seoulTop5Data() {
		// TODO Auto-generated method stub
		return mapper.seoulTop5Data();
	}

	@Override
	public SeoulVO seoulFestivalDetailData(int contentid) {
		// TODO Auto-generated method stub
		return mapper.seoulFestivalDetailData(contentid);
	}
	
	// 구현 => mapper
	// 통합 => service
	// 브라우저로 전송 : request(model) => Controller
	//              JSON => RestController => ResponseBody
}
