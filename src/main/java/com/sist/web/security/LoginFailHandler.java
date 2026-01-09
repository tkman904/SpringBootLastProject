package com.sist.web.security;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;

@Component
@RequiredArgsConstructor
public class LoginFailHandler implements AuthenticationFailureHandler {
	private final MemberService mService;
//	private final BCryptPasswordEncoder encoder;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String errorMsg = "";
		try {
//			String id = request.getParameter("userid");
//			String pwd = request.getParameter("userpwd");
//			
//			int count = mService.memberIdCheck(id);
//			if(count == 0) {
//				errorMsg = "아이디가 존재하지 않습니다";
//			} else {
//				MemberVO vo = mService.memberInfoData(id);
//				if(encoder.matches(pwd, vo.getUserpwd())) {
//					errorMsg = "이미 로그인 상태입니다";
//				} else {
//					errorMsg = "잘못된 비밀번호입니다";
//				}
//			}
			
			
			if(exception instanceof BadCredentialsException) {
				errorMsg = "잘못된 아이디 또는 비밀번호입니다";
			}
			else if(exception instanceof InternalAuthenticationServiceException) {
				errorMsg = "잘못된 아이디 또는 비밀번호입니다";
			}
			else if(exception instanceof DisabledException) {
				errorMsg = "휴면 상태의 계정입니다";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("message", errorMsg);
		request.getRequestDispatcher("/member/login").forward(request, response);
	}

}
