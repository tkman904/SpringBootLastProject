package com.sist.web.vo;
/*
    NO        NOT NULL NUMBER         
	TYPE               VARCHAR2(20)   
	NAME               VARCHAR2(20)   
	SUBJECT   NOT NULL VARCHAR2(1000) 
	CONTENT   NOT NULL CLOB           
	REGDATE            DATE           
	HIT                NUMBER         
	FILENAME           VARCHAR2(1000) 
	FILECOUNT          NUMBER
 */

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {
	private int no, hit, filecount;
	private String type, name, subject, content, filename, dbday;
	private Date regdate;
	private List<MultipartFile> files;
}
