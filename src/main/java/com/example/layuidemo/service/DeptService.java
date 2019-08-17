package com.example.layuidemo.service;

import java.util.Map;

import com.example.layuidemo.utils.PageUtil;
import com.example.layuidemo.utils.ResponeUtil;

public interface DeptService {

	ResponeUtil<Map<String, Object>> queryDept(PageUtil pageUtil);
}
