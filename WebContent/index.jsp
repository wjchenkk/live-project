<%--
  Created by IntelliJ IDEA.
  User: 86169
  Date: 25/2/2020
  Time: 下午3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>口罩预约系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
	<link href="css/bootstrap.css" rel="stylesheet">

	<link rel="stylesheet" href="css/forindex.css">
	<script src="js/forindex.js"></script>
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
				<a class="navbar-brand" href="#">口罩预约系统</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">首页 <span class="sr-only">(current)</span></a></li>
					<li><a href="index.jsp">预约登记</a></li>
					<li><a href="query.jsp">中签查询<span class="sr-only">(current)</span></a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>

	<!-- 主界面 -->
	<nav class="container">
		<div>
			<!-- 标签 -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人信息登记</a></li>
				<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">预约定时</a></li>
			</ul>
			<br />
			<!-- 标签内容 -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in active" id="home">
						<form action="order" method="post">
							<div class="form-group">
							  <label>真实姓名</label>
							  <input class="form-control" id="exampleInputName" placeholder="Name" name="name">
							</div>
							<div class="form-group">
							  <label>身份证号</label>
							  <input class="form-control" id="IDnum" placeholder="ID Card" name="ID">
								<p id="mes2" class="mes">请输入正确的身份证号！</p>
							</div>
							<div class="form-group">
								<label>手机号</label>
								<input class="form-control" id="PhoneNum" placeholder="Phone Num" name="Phone">
								<p id="mes3" class="mes">请输入正确的手机号！</p>
							  </div>
							  <div class="form-group">
								<label for="exampleInputPassword1">预约口罩数量（不得超过3个）</label>
								<select class="form-control" name="num">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								  </select>
							  </div>
							<button type="submit" class="btn btn-primary">提交预约</button>
						  </form>

					
				</div>
				<%
				
					String status = (String)request.getAttribute("status");
					if(status!=null&&status.equals("success")){
						int record=(int)request.getAttribute("record");
				%>
				<div class="alert alert-success">成功！很好地完成了提交，编号：<%=record %></div>
				<%}else{ %>
				<div class="alert alert-success">提交失败</div>
				<%} %>
				<div role="tabpanel" class="tab-pane fade" id="profile">
					<form action="sub.jsp" action="post" style="margin-top: 25px;">
					<div class="form-group">
								  <label>口罩数量</label>
								  <input type="number" class="form-control" id="exampleInputName" placeholder="50" style="margin-bottom: 10px;">
								  <!-- <button type="submit" class="btn btn-success">开始新的预约</button> -->
								  <button type="submit" class="btn btn-success"> 开始新的预约</button>  
							  </div>
					</form>
					<a href="out" class="btn btn-warning"> 结束当前预约</a>
					</div>
			</div>
			
		</div>
		<div id="kk"></div>
	</nav>


</body>
</html>
