package com.zhangtao.cms.service;

import java.util.List;

import com.zhangtao.cms.domain.Link;

public interface LinkService {
	/**
	 * 
	 * @Title: select 
	 * @Description: 查询所有的友情链接
	 * @return
	 * @return: List<Link>
	 */
	List<Link> select();
}
