package com.example.layuidemo.service;

import java.util.Map;

import com.example.layuidemo.utils.PageUtil;
import com.example.layuidemo.utils.ResponeUtil;

public interface EmpService {

	ResponeUtil<Map<String, Object>> queryEmp(PageUtil pageUtil);
}
