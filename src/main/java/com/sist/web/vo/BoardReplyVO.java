package com.sist.web.vo;
/*
    NO      NOT NULL NUMBER       
	BNO              NUMBER       
	ID               VARCHAR2(20) 
	NAME    NOT NULL VARCHAR2(51) 
	SEX              VARCHAR2(6)  
	MSG     NOT NULL CLOB         
	REGDATE          DATE
 */
import java.util.*;

import lombok.Data;

@Data
public class BoardReplyVO {
	private int no, bno;
	private String id, name, sex, msg, dbday;
	private Date regdate;
}
