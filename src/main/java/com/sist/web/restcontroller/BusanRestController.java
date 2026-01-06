package com.sist.web.restcontroller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/busan/")
public class BusanRestController {
	private final BusanService bService;
	
	@GetMapping("find_vue/")
	public ResponseEntity<Map> busan_find_vue(@RequestParam("page") int page, @RequestParam("address") String address) {
		Map map = new HashMap();
		try {
			map.put("start", (page-1)*12);
			map.put("address", address);
			List<BusanVO> list = bService.busanFindData(map);
			for(BusanVO vo : list) {
				String[] addrs = vo.getAddress().split(" ");
				vo.setAddress(addrs[1]+" "+addrs[2]);
			}
			int totalpage = bService.busanFindTotalPage(address);
			
			final int BLOCK = 10;
			int startPage = ((page-1)/BLOCK*BLOCK)+1;
			int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage) {
				endPage = totalpage;
			}
			
			// JSON으로 묶어서 => 브라우저로 전송
			map = new HashMap();
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("address", address);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			// INTERNAL_SERVER_ERROR: 500 Error
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
