package com.sist.web.vo;
/*
    NO        NOT NULL NUMBER       
	CNO                NUMBER       
	ID                 VARCHAR2(20) 
	RDAY      NOT NULL VARCHAR2(30) 
	RTIME     NOT NULL VARCHAR2(30) 
	RINWON    NOT NULL VARCHAR2(20) 
	REGDATE            DATE         
	ISRESERVE          NUMBER
 */
import java.util.*;

import lombok.Data;

@Data
public class ReserveVO {
	private int no, cno, isreserve, iscancel;
	private String id, rday, rtime, rinwon, dbday;
	private Date regdate;
	
	private SeoulVO svo = new SeoulVO();
}
