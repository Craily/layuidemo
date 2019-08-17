package com.example.layuidemo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.layuidemo.dao.DeptMapper;
import com.example.layuidemo.po.Dept;
import com.example.layuidemo.po.DeptExample;
import com.example.layuidemo.service.DeptService;
import com.example.layuidemo.utils.ConstantUtil;
import com.example.layuidemo.utils.PageUtil;
import com.example.layuidemo.utils.ResponeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public ResponeUtil<Map<String, Object>> queryDept(PageUtil pageUtil) {
		// TODO 根据条件查询部门
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		resultMap.put("list", new ArrayList<>());
		ResponeUtil<Map<String, Object>> responeUtil = new ResponeUtil<Map<String,Object>>(ConstantUtil.Success.getCode(), ConstantUtil.Success.getMsg(), resultMap);
		try {
			if(pageUtil.getPage() != 0) {
				PageHelper.startPage(pageUtil.getPage(), pageUtil.getLimit());
			}
			
			DeptExample deptExample = new DeptExample();
			deptExample.createCriteria();
			List<Dept> deptList = deptMapper.selectByExample(deptExample);
			if(deptList == null || deptList.isEmpty()) {
				responeUtil.setStatus(ConstantUtil.Empty.getCode());
				responeUtil.setMsg(ConstantUtil.Empty.getMsg());
			}else {
				if(pageUtil.getPage() != 0) {
					//获取分页信息
					PageInfo<Dept> pageInfo = new PageInfo<>(deptList);
					resultMap.put("count", pageInfo.getTotal());
				}
				resultMap.put("list", deptList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responeUtil.setStatus(ConstantUtil.Error.getCode());
			responeUtil.setMsg(ConstantUtil.Error.getMsg() + e.getMessage());
		}
		return responeUtil;
	}

}
