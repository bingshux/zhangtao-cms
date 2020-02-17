<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
function goPage(page){
	$("#center").load("/my/article/articles?page="+page)
}
function articleDetail(id){
	alert(id)
	$.get("/my/article/select" ,{id:id},function(article){
		$("#articleConent").empty();
		$("#mytitle").append(article.title);
		$("#articleConent").append(article.content);
	})
	
}
</script>
</head>
<body>
	<div class="container">
     <div>
		<div>
			<p>我收藏的文章</p>
		</div>
		<hr>
		
    <c:forEach items="${collectInfo.list}" var="collect">
		<div class="media">
			
			<div class="media-body">
				<h5 class="mt-0">${collect.text }
					
				</h5>
				<p>
					<fmt:formatDate value="${collect.created }"
						pattern="yyyy-MM-dd HH:mm:ss" />
					0 评论    
				</p>
				<div style="float: right;"><button  class="btn btn-sm btn-warning" onclick="collect(${collect.id})">取消收藏</button></div>
			</div>
		</div>
		<hr>
	</c:forEach>

	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
	function collect(id){
		var url=window.location.href;
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
	</script>


</body>
</html>