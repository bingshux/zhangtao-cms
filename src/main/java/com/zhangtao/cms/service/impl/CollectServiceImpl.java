package com.zhangtao.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangtao.cms.dao.CollectMapper;
import com.zhangtao.cms.domain.Collect;
import com.zhangtao.cms.service.CollectService;
import com.zhangtao.cms.util.CMSException;
import com.zhangtao.util.StringUtil;
@Service
public class CollectServiceImpl implements CollectService {
	@Resource
	private CollectMapper collectMapper;
	@Override
	public int insert(Collect collect) {
		//判断传入的url是否合法
		if(!StringUtil.isHttpUrl(collect.getUrl())) {
			throw new CMSException("不是合法的url!");
		}
		return collectMapper.insert(collect);
	}

	@Override
	public int delete(Integer id) {
		
		return collectMapper.delete(id);
	}

	@Override
	public PageInfo<Collect> select(Integer userId, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Collect> list = collectMapper.select(userId);
		return new PageInfo<>(list);
	}

	@Override
	public Collect selectByTitleAndUserID(String title, Integer userId) {
		
		return collectMapper.selectByTitleAndUserID(title, userId);
	}
	
}
