package com.example.layuidemo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.layuidemo.dao.EmpMapper;
import com.example.layuidemo.po.Emp;
import com.example.layuidemo.po.EmpExample;
import com.example.layuidemo.service.EmpService;
import com.example.layuidemo.utils.ConstantUtil;
import com.example.layuidemo.utils.PageUtil;
import com.example.layuidemo.utils.ResponeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper;

	@Override
	public ResponeUtil<Map<String, Object>> queryEmp(PageUtil pageUtil) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		resultMap.put("list", new ArrayList<>());
		ResponeUtil<Map<String, Object>> responeUtil = new ResponeUtil<Map<String,Object>>(ConstantUtil.Success.getCode(), ConstantUtil.Success.getMsg(), resultMap);
		try {
			if(pageUtil.getPage() != 0) {
				PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
			}
			EmpExample empExample = new EmpExample();
			empExample.createCriteria();
			List<Emp> empList = empMapper.selectByExample(empExample);
			if(empList == null || empList.isEmpty()) {
				responeUtil.setStatus(ConstantUtil.Empty.getCode());
				responeUtil.setMsg(ConstantUtil.Empty.getMsg());
			}else {
				//获取分页信息
				if(pageUtil.getPage() != 0) {
					PageInfo<Emp> pageInfo = new PageInfo<>(empList);
					resultMap.put("count", pageInfo.getTotal());
				}
				resultMap.put("list", empList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responeUtil.setStatus(ConstantUtil.Error.getCode());
			responeUtil.setMsg(ConstantUtil.Error.getMsg() + e.getMessage());
		}
		return responeUtil;
	}

}
