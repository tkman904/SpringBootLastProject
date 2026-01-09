package com.sist.web.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final MemberService mService;
	
	@GetMapping("/member/idcheck_vue/")
	public String member_idCheck(@RequestParam("userid") String userid) {
		int count = mService.memberIdCheck(userid);
		
		return String.valueOf(count);
	}
}
