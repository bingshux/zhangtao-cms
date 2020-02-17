package com.zhangtao.cms.dao;

import java.util.List;

import com.zhangtao.cms.domain.Link;

public interface LinkMapper {
	/**
	 * 
	 * @Title: select 
	 * @Description: 查询所有的友情链接
	 * @return
	 * @return: List<Link>
	 */
	List<Link> select();
}
