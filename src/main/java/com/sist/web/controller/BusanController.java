package com.sist.web.controller;

import java.util.*;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
 *   MVC : 오라클 / 컨트롤러 / JSP
 *         -------------- Vue / React
 *         
 *         => SQL / 사용자가 어떤 데이터를 보낼지
 */
@Controller
@RequiredArgsConstructor
public class BusanController {
	private final BusanService bService;
	
	@GetMapping("/busan/list")
	public String busan_list(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "cno") int cno, Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		map.put("start", (curpage-1)*12);
		map.put("contenttype", cno);
		
		List<BusanVO> list = bService.busanListData(map);
		int totalpage = bService.busanTotalPage(cno);
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage = totalpage;
		}
		
		for(BusanVO vo : list) {
			String[] addrs = vo.getAddress().split(" ");
			vo.setAddress(addrs[0]+" "+addrs[1]);
		}
		
		String name = "";
		if(cno == 12) {
			name = "부산 관광지";
		}
		else if(cno == 14) {
			name = "부산 문화시설";
		}
		else if(cno == 15) {
			name = "부산 축제 & 공연";
		}
		else if(cno == 32) {
			name = "부산 숙박";
		}
		else if(cno == 38) {
			name = "부산 쇼핑";
		}
		else if(cno == 39) {
			name = "부산 음식";
		}
		
		model.addAttribute("name", name);		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("cno", cno);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_jsp", "../busan/list.jsp");
		
		// include가 되는 파일을 올린다 => request를 공유할 수 있다
		return "main/main";
	}
	
	@GetMapping("/busan/find")
	public String busan_find(Model model) {
		model.addAttribute("main_jsp", "../busan/busan_find.jsp");
		
		return "main/main";
	}
}
