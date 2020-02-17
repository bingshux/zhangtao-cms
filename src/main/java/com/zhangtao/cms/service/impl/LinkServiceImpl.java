package com.zhangtao.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangtao.cms.dao.LinkMapper;
import com.zhangtao.cms.domain.Link;
import com.zhangtao.cms.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService {
	@Resource
	private LinkMapper linkMapper;
	@Override
	public List<Link> select() {
		
		return linkMapper.select();
	}

}
