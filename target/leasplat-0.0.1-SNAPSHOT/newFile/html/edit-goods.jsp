<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加出租商品</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont2/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/add-goods.css">
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
			<div>
				<p>
					<a href="javascript:;">我的出租单</a>
					<a href="javascript:;">业务咨询</a>
				</p>
			</div>
		</div>
		<!-- <div id="nav">
			<ul>
				<li><a href="javascript:;">首页</a></li>
				<li><a href="javascript:;">我要求租</a></li>
				<li><a href="javascript:;">我要出租</a></li>
				<li>
					<a href="javascript:;"><span class="iconfont">&#xe672;</span> 购物车</a>
				</li>
				<li><a href="javascript:;">关于我们</a></li>
			</ul>
		</div>
		-->
		<%@ include file = "menu.jsp"%>
			<div id="main">
				<div class="upload" style="padding-left:100px;">
				<form id="form" action=""  enctype="multipart/form-data">
					<div class="group">
						<label>商品名称：</label>
						<input type="text" name="name" id = "name" value="${goods.name }" /> 
					</div>
					<div class="group">
						<label>商品类别：</label>
						<select name="goodsClassId" id="goodsClassId" style="padding: 0px;border-radius: 5px; font-size: 15px;width:282px;height:34px; padding-left: 5px;">
							<c:forEach var="goodsClass" items="${goodsClassList}">
								<c:if test="${goodsClass.id == goods.goodsClassId}">
									<option value="${goodsClass.id }" selected="selected">${goodsClass.name}</option>
								</c:if>
								<c:if test="${goodsClass.id != goods.goodsClassId}">
									<option value="${goodsClass.id }" >${goodsClass.name}</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
					<div class="group">
						<label>单价：</label>
						<input type="text" name="price" id="price" value="${goods.price }" /> 元/
						<select name="basicUnit" id="basicUnit" style="padding: 0px;border-radius: 5px; font-size: 15px;width:45px;height:34px; padding-left: 5px;">
							<c:if test="${goods.basicUnit == 0}">
								<option value="0" selected="selected">日</option>
								<option value="1">月</option>
								<option value="2">年</option>
							</c:if>
							<c:if test="${goods.basicUnit == 1}">
								<option value="0" >日</option>
								<option value="1" selected="selected">月</option>
								<option value="2">年</option>
							</c:if>
							<c:if test="${goods.basicUnit == 2}">
								<option value="0">日</option>
								<option value="1">月</option>
								<option value="2" selected="selected">年</option>
							</c:if>
						</select>
					</div>	
					<div class="group">
						<label style="vertical-align:top;">商品描述：</label>
						<textarea rows="10" cols="100" name="goodsMessage" id="goodsMessage" maxlength="100">
							${goods.goodsMessage }
						</textarea>
					</div>	
						<input type="hidden" name="userId" id="userId" value="${goods.userId }">
						<input type="hidden" name="id" id="id" value="${goods.id }">
						<input type="hidden" name="image1" id="image1">
						<input type="hidden" name="image2" id="image2">
						<input type="hidden" name="image3" id="image3">
						<input type="hidden" name="image4" id="image4">
					</form>
					<div class="group">
						<label style="vertical-align:top;">商品图片：</label>
						<form enctype="multipart/form-data">
							<div class="img-place">
								<div id="img1" style="height:110px;width:110px;outline:0;border:1px solid #ccc;background:url(../newFile/images/addImage.png) no-repeat center center;background-size:80px;float:left;margin:5px;">
									<input type="file" id="imageOne" name="imageOne" style="filter: alpha(opacity=0);opacity: 0;height:110px;width:110px;">
								</div>
								<div id="img2" style="height:110px;width:110px;outline:0;border:1px solid #ccc;background:url(../newFile/images/addImage.png) no-repeat center center;background-size:80px;float:left;margin:5px;">
									<input type="file" id="imageTwo" name="imageTwo" style="filter: alpha(opacity=0);opacity: 0;height:110px;width:110px;">
								</div>
								<div id="img3" style="height:110px;width:110px;outline:0;border:1px solid #ccc;background:url(../newFile/images/addImage.png) no-repeat center center;background-size:80px;float:left;margin:5px;">
									<input type="file" id="imageThree" name="imageThree" style="filter: alpha(opacity=0);opacity: 0;height:110px;width:110px;">
								</div>
								<div id="img4" style="height:110px;width:110px;outline:0;border:1px solid #ccc;background:url(../newFile/images/addImage.png) no-repeat center center;background-size:80px;float:left;margin:5px;">
									<input type="file" id="imageFour" name="imageFour" style="filter: alpha(opacity=0);opacity: 0;height:110px;width:110px;">
								</div>
							</div>
						</form>
					</div>	
					<div class="upload-btn private-edit">确认上传</div>				
				</div>
			</div>
		
	</div>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../newFile/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(function () {
		var imgAttr = [];
		<c:forEach var="goodsImage" items="${goodsImageList}">
			imgAttr.push(${goodsImage.id});
		</c:forEach>
		for (var i = 1;i <= imgAttr.length;i++)
		{
			$("#image" + i).val(imgAttr[i - 1]);
			$("#img" + i).css({"background":"url(../file/readImgTwo.do?imageId=" + imgAttr[i - 1] + ")",backgroundSize:"100% 100%"});
		}
		
		$(".private-edit").click(function(){
			var imgs = [];
			var image1 = $("#image1").val();
			var image2 = $("#image2").val();
			var image3 = $("#image3").val();
			var image4 = $("#image4").val();
			var id = $("#id").val();
			var userId = $("#userId").val();
			if(image1) imgs.push(image1);
			if(image2) imgs.push(image2);
			if(image3) imgs.push(image3);
			if(image4) imgs.push(image4);
			var name = $("#name").val();
			var goodsClassId = $("#goodsClassId").val();
			var price = $("#price").val();
			var basicUnit = $("#basicUnit").val();
			var goodsMessage = $("#goodsMessage").val();
			if(!name) return alert("商品名称不能为空");
			if(!price) return alert("商品单价不能为空");
			var data = {
					id:id,
					userId:userId,
					name :name,
					goodsClassId : goodsClassId,
					price : price,
					basicUnit : basicUnit,
					goodsMessage : goodsMessage,
					imgs:imgs
			};
			console.log(data)
			console.log(imgs);
			$.post("./update.do",data,function(data){
				console.log(data);
				if(data.error.code == 1)
				{
					alert("修改成功！！！");
					window.location.reload();
				}
				else
				{
					alert("修改失败");
				}
			});
		});
		
		
		//图片1上传并获取id
		$("#imageOne").change(function () {
			 $.ajaxFileUpload(
				{
				 	url : "../file/save.do",
				 	secureuri: false,
				 	fileElementId:"imageOne",
				 	data:{imageName:"imageOne"},
				 	type:'post',
				 	success: function (data){
				 		$("#image1").val(data.data.id);
				 		$("#img1").css({"background":"url(../file/readImg.do?imgId=" + data.data.id + ")",backgroundSize:"100% 100%"});
				 		console.log(data);
				 	},
			 	    error: function (data)//服务器响应失败处理函数
	                {
	                    alert("失败");
	                }
			 	}
			 );
		});
		
		
		//图片2上传并获取id
		$("#imageTwo").change(function () {
			 $.ajaxFileUpload(
				{
				 	url : "../file/save.do",
				 	secureuri: false,
				 	fileElementId:"imageTwo",
				 	data:{imageName:"imageTwo"},
				 	type:'post',
				 	success: function (data){
				 		$("#image2").val(data.data.id);
				 		$("#img2").css({"background":"url(../file/readImg.do?imgId=" + data.data.id + ")",backgroundSize:"100% 100%"});
				 		console.log(data);
				 	},
			 	    error: function (data)//服务器响应失败处理函数
	                {
	                    alert("失败");
	                }
			 	}
			 );
		});
		
		
		//图片3上传并获取id
		$("#imageThree").change(function () {
			 $.ajaxFileUpload(
				{
				 	url : "../file/save.do",
				 	secureuri: false,
				 	fileElementId:"imageThree",
				 	data:{imageName:"imageThree"},
				 	type:'post',
				 	success: function (data){
				 		$("#image3").val(data.data.id);
				 		$("#img3").css({"background":"url(../file/readImg.do?imgId=" + data.data.id + ")",backgroundSize:"100% 100%"});
				 		console.log(data);
				 	},
			 	    error: function (data)//服务器响应失败处理函数
	                {
	                    alert("失败");
	                }
			 	}
			 );
		});
		
		
		//图片4上传并获取id
		$("#imageFour").change(function () {
			 $.ajaxFileUpload(
				{
				 	url : "../file/save.do",
				 	secureuri: false,
				 	fileElementId:"imageFour",
				 	data:{imageName:"imageFour"},
				 	type:'post',
				 	success: function (data){
				 		$("#image4").val(data.data.id);
				 		$("#img4").css({"background":"url(../file/readImg.do?imgId=" + data.data.id + ")",backgroundSize:"100% 100%"});
				 		console.log(data);
				 	},
			 	    error: function (data)//服务器响应失败处理函数
	                {
	                    alert("失败");
	                }
			 	}
			 );
		});
	})
</script>
</html>