package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

/*
 *   1. 일반 보안 => 자동 로그인 => 프로시저 / 트리거 / 람다식
 *   2. JWT => 카카오 / 구글 로그인
 *   3. 소켓 : 실시간 : 그룹 / 1:1 => Spring AI (챗봇)
 *   4. 실시간 메시지 전송 : Kafka / batch
 *   5. MSA : React => NodeJS => JPA / MySQL
 *   6. CI/CD => 통합 => Spring Data => elasticSearch / Redis
 */
@Controller
@RequiredArgsConstructor
public class MainController {
	private final SeoulService sService;
	private final BusanService bService;
	private final JejuService jService;
	private final RealFindDataService rService;
	
	@GetMapping("/main")
	public String main_page(Model model) {
		// => 데이터베이스
		List<SeoulVO> sList = sService.seoulTop5Data();
		for(SeoulVO vo : sList) {
			String[] datas = vo.getAddress().split(" ");
			vo.setAddress(datas[0]+" "+datas[1]);
		}
		
		List<BusanVO> bList = bService.busanTop4Data();
		for(BusanVO vo : bList) {
			String[] datas = vo.getAddress().split(" ");
			vo.setAddress(datas[0]+" "+datas[1]);
		}
		
		List<JejuVO> jList = jService.jejuTop4Data();
		for(JejuVO vo : jList) {
			String[] datas = vo.getAddress().split(" ");
			vo.setAddress(datas[0]+" "+datas[1]);
		}
		
		List<RealFindDataVO> rList = rService.realFindDataAllData();
		
		model.addAttribute("sList", sList);
		model.addAttribute("bList", bList);
		model.addAttribute("jList", jList);
		model.addAttribute("rList", rList);
		
		model.addAttribute("main_jsp", "../main/home.jsp");
		
		return "main/main";
	}
}
