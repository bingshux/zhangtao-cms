package com.zhangtao.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangtao.cms.dao.ChannelMapper;
import com.zhangtao.cms.domain.Category;
import com.zhangtao.cms.domain.Channel;
import com.zhangtao.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
@Resource
private ChannelMapper channelMapper;
	@Override
	public List<Channel> selects() {
		
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectsByCid(Integer channelId) {
		return channelMapper.selectsByCid(channelId);
	}

}
