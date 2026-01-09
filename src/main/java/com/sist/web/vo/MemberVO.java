package com.sist.web.vo;
/*
    USERID   NOT NULL VARCHAR2(20)  
	USERNAME NOT NULL VARCHAR2(50)  
	USERPWD  NOT NULL VARCHAR2(300) 
	ENABLED           NUMBER(1)     
	SEX               VARCHAR2(6)   
	BIRTHDAY NOT NULL VARCHAR2(20)  
	EMAIL             VARCHAR2(100) 
	POST     NOT NULL VARCHAR2(10)  
	ADDR1    NOT NULL VARCHAR2(300) 
	ADDR2             VARCHAR2(300) 
	PHONE             VARCHAR2(20)  
	CONTENT           CLOB          
	REGDATE           DATE
 */
import java.util.*;

import lombok.Data;

@Data
public class MemberVO {
	private int enabled;
	private String userid, username, userpwd, sex, birthday, email, 
		post, addr1, addr2, phone, content, dbday, phone1, phone2;
	private Date regdate;
}
