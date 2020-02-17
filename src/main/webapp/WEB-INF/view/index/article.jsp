<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${article.title }</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

</head>

<body>
	<div class="container">
		<!-- 文章标题,占12列 -->
		<div class="row">
			<div class="col-md-12">
				<h2>${article.title }</h2>
				<p>${article.user.username}
					<fmt:formatDate value="${article.created }"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</p>
				<c:if test="${null !=collect }">
					<a href="javascript:collect(1)"><span style="color:red;">★(已收藏)</span></a>
				</c:if>
				<c:if test="${null ==collect}">
					<a href="javascript:collect(0)"><span >☆(未收藏)</span></a>
				</c:if>
			</div>
			
		</div>

		<hr>
		<div class="row">
		
			<div class="col-md-9">${article.content }</div>
			<div class="col-md-3">
					<!-- 热门推荐文章 -->
				<div class="card" style="width: 18rem;">
					<div class="card-header" style="text-align: center;">热门推荐文章</div>
					<div class="card-body">
						<c:forEach items="${hot24Articles.list}" var="hot24Article">
							<ul class="list-unstyled">
								<li class="media"><img src="/pic/${hot24Article.picture }"
									class="mr-3" alt="..." width="60" height="60">
									<div class="media-body">
										<p style="font-size: 14px">
											<a href="/articleDetail?id=${hot24Article.id}" target="_blank">${hot24Article.title }</a>
										</p>
									</div></li>
							</ul>
							<hr>
						</c:forEach>
					</div>
				</div>
	  		</div>
		</div>
		

	</div>
	
	<div class="col-10 offset-1 breadcrumb" style="margin-bottom: 200px;">
			友情链接：
			<c:forEach items="${linkList }" var="item">
				<div style="margin-left: 20px;">
					<a href="${item.url }" target="_blank">${item.text }</a>
				</div>
			</c:forEach>
		</div>
</body>
	<script type="text/javascript">
		//收藏或者取消收藏
		function collect(flag) {
			//获取当前文章的url
			var url=window.location.href;
			var text='${article.title}';
			if(flag==0){
				//收藏
				$.post(
						"/collect",	
						{url:url,text:text},
						function(msg){
							if(msg){
								alert("收藏成功!")
								location.reload();//刷新页面
							}else{
								alert("收藏失败")
							}
						}
					)
			}else{
				//取消收藏
				var id='${collect.id}'
				$.post(
						"/unCollect",	
						{id:id},
						function(msg){
							if(msg){
								alert("取消收藏成功!")
								location.reload();
							}else{
								alert("取消收藏失败")
							}
						}
					)
			}
		
			
		}
	</script>
</html>