package com.example.layuidemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.layuidemo.service.DeptService;
import com.example.layuidemo.utils.PageUtil;
import com.example.layuidemo.utils.ResponeUtil;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@PostMapping(value="/queryDept", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponeUtil<Map<String, Object>> queryDept(PageUtil pageUtil) {
		return deptService.queryDept(pageUtil);
	}

}
