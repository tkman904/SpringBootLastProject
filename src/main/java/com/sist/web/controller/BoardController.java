package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;

// RouterController => Pinia에서 router
@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService bService; // Reply
	// GET / POST => @RequestMapping
	
	// 사용자가 어떤 값을 보내는지 => 주고 받기 (Socket) C/S
	@GetMapping("/board/list")
	public String board_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		
		List<BoardVO> list = bService.boardListData((curpage-1)*10);
		int totalpage = bService.boardTotalPage();
		
		// 데이터가 많은 경우 : BLOCK별 / 적으면 이전 ~ 다음
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		model.addAttribute("main_jsp", "../board/list.jsp");
		
		return "main/main";
	}
	
	@GetMapping("/board/insert")
	public String board_insert(Model model) {
		model.addAttribute("main_jsp", "../board/insert.jsp");
		
		return "main/main";
	}
	
	/*
	 *   @RequestParam => 단일값
	 *   @ModelAttribute => VO 단위로 값을 받는 경우
	 *   @RequestBody => @RestController
	 *                   JSON => 객체 변환
	 *   --------------------- 사용자 전송한 값을 받는 경우
	 */
	
	@PostMapping("/board/insert_ok")
	public String board_insert_ok(@ModelAttribute BoardVO vo) {
		bService.boardInsert(vo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/detail")
	public String board_detail(@RequestParam("no") int no, Model model) {
		BoardVO vo = bService.boardDetailData(no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../board/detail.jsp");
		
		return "main/main";
	}
	
	@GetMapping("/board/update")
	public String board_update(@RequestParam("no") int no, Model model) {
		BoardVO vo = bService.boardUpdateData(no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../board/update.jsp");
		
		return "main/main";
	}
	
	@PostMapping(value = "/board/update_ok", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String board_update_ok(@ModelAttribute BoardVO vo) {
		String res = "";
		String s = bService.boardUpdate(vo);
		if(s.equals("yes")) {
			res = "<script>"
					+ "location.href=\"/board/detail?no="+vo.getNo()+"\""
					+ "</script>";
		} else {
			res = "<script>"
					+ "alert(\"올바른 비밀번호를 입력해주세요\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return res;
	}
	
	@GetMapping("/board/delete")
	public String board_delete(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		
		model.addAttribute("main_jsp", "../board/delete.jsp");
		
		return "main/main";
	}
	
	@PostMapping("/board/delete_ok")
	@ResponseBody
	public String board_delete_ok(@RequestParam("no") int no, @RequestParam("pwd") String pwd) {
		String res = "";
		boolean b = bService.booardDelete(no, pwd);
		if(b == true) {
			res = "<script>"
					+ "location.href=\"/board/list\""
					+ "</script>";
		} else {
			res = "<script>"
					+ "alert(\"올바른 비밀번호를 입력해주세요\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return res;
	}
}
