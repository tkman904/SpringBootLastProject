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

@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String errorMsg = "";
		try {
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
		request.getRequestDispatcher("/main").forward(request, response);
	}

}
