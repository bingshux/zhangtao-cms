package com.zhangtao.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangtao.cms.domain.Article;
import com.zhangtao.cms.domain.Category;
import com.zhangtao.cms.domain.Channel;
import com.zhangtao.cms.domain.Collect;
import com.zhangtao.cms.domain.Link;
import com.zhangtao.cms.domain.Slide;
import com.zhangtao.cms.domain.User;
import com.zhangtao.cms.service.ArticleService;
import com.zhangtao.cms.service.ChannelService;
import com.zhangtao.cms.service.CollectService;
import com.zhangtao.cms.service.LinkService;
import com.zhangtao.cms.service.SlideService;
import com.zhangtao.util.DateUtil;

@Controller
public class IndexController {
	
	@Resource
	private ChannelService channelService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	@Resource
	private CollectService collectService;
	@Resource
	private LinkService linkService ;
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		article.setStatus(1);//查询审核过的文章
		article.setDeleted(0);//未删除
		//查询出所有的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		
		
		if(article.getChannelId()!=null) {//如果栏目不为空空则显示栏目及分类下文章
		//根据栏目查询其下所有分类
		List<Category> categorys = channelService.selectsByCid(article.getChannelId());
		model.addAttribute("categorys", categorys);
		model.addAttribute("article", article);
		//根据栏目或分类查询文章
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		}else {
	       //显示热点文章
			PageInfo<Article> hotInfo = articleService.selects(article, page, pageSize);
			model.addAttribute("info", hotInfo);
			//查询广告
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides",slides);
		}
		
		
		//查询出最新的5篇文章
		Article lastArticle = new Article();
		lastArticle.setStatus(1);//只能查询最新的并且审过的文章
		lastArticle.setDeleted(0);//未删除
		PageInfo<Article> lastInfo = articleService.selects(null, 1, 5);
		model.addAttribute("lastInfo", lastInfo);
		//查询24小时热文
		Article hot24Article = new Article();
		hot24Article.setStatus(1);//审核后的文章
		hot24Article.setHot(1);//1是热门文章
		hot24Article.setCreated(DateUtil.subDate(new Date()));//调用工具类门系统时间向前减一天
		PageInfo<Article> hot24Articles = articleService.selects(lastArticle, 1, 10);//24小时热文,默认显示4条
		model.addAttribute("hot24Articles", hot24Articles);
		return "index/index";
		
	}
	
	//文章详情
	@RequestMapping("articleDetail")
	public String articleDetail(Model model ,Integer id,HttpSession session) {
		//文章内容
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		//查询该文章是否被用户收藏过
		User user = (User) session.getAttribute("user");//从session中获取当前登录的用户
		if(user!=null) {
			Collect collect = collectService.selectByTitleAndUserID(article.getTitle(), user.getId());
			model.addAttribute("collect", collect);
			
		}
		List<Link> linkList = linkService.select();
		model.addAttribute("linkList", linkList);
		//查询出最新的5篇文章
				Article lastArticle = new Article();
				lastArticle.setStatus(1);//只能查询最新的并且审过的文章
				lastArticle.setDeleted(0);//未删除
				PageInfo<Article> lastInfo = articleService.selects(null, 1, 5);
				model.addAttribute("lastInfo", lastInfo);
				//查询24小时热文
				Article hot24Article = new Article();
				hot24Article.setStatus(1);//审核后的文章
				hot24Article.setHot(1);//1是热门文章
				hot24Article.setCreated(DateUtil.subDate(new Date()));//调用工具类门系统时间向前减一天
				PageInfo<Article> hot24Articles = articleService.selects(lastArticle, 1, 10);//24小时热文,默认显示4条
				model.addAttribute("hot24Articles", hot24Articles);
		 
		return "index/article";
	}
	@RequestMapping("collect")
	@ResponseBody
	public boolean collect(Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(null==user) {
			//sessoin 过期
			return false;
		}
		collect.setUser(user);
		collect.setCreated(new Date());
		return collectService.insert(collect)>0;
	}
	//取消收藏
	@RequestMapping("unCollect")
	@ResponseBody
	public boolean unCollect(Integer id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(null==user) {
			//sessoin 过期
			return false;
		}
		return collectService.delete(id)>0;
	}
}
