<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>口罩预约系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Bootstrap -->
		<link href="css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="js/jquery-3.3.1.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="js/bootstrap.js"></script>

		<!-- 导航栏 -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					 aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="">口罩预约系统</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="index.jsp">首页 <span class="sr-only">(current)</span></a></li>
						<li><a href="index.jsp">预约登记<span class="sr-only">(current)</span></a></li>
						<li><a href="query.jsp">中签查询<span class="sr-only">(current)</span></a></li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		<nav class="container">
			<div>
				<!-- 标签 -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">预约查询</a></li>
				</ul>
				<br />
				<!-- 标签内容 -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="home">
							<form action="select" method="post">
								<div class="form-group" >
								  <label>预约编号</label>
								  <input class="form-control" id="exampleInputName" placeholder="Number" name="id">
								</div>
								<button type="submit" class="btn btn-primary">提交查询</button>
							  </form>

					</div>
					<div id="purchase-voucher">
						<h1>购买凭证</h1>
						<table class="table table-hover">
							<tr>
								<th>姓名</th>
								<th>身份证号</th>
								<th>手机号</th>
								<th>购买数量</th>
							</tr>
							<%
							String result=request.getParameter("result");
							if(result!=null&&result.equals("success")){
							%>		
							<tr>
								<td><%=request.getAttribute("name") %>><td>
								<td><%=request.getAttribute("id") %>><td>
								<td><%=request.getAttribute("tel") %>><td>
								<td><%=request.getAttribute("number") %>><td>
							<tr>	
							<% }%>
						  </table>
					</div>
				</div>
				
			</div>

		</nav>



	</body>
</html>
