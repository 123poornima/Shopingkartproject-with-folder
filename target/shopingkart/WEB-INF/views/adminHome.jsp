<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

body{ 
background-image: url(resources/images/bgk13.jpg); 
background-size:     cover;                      
    background-repeat:   no-repeat;
 }
 
</style>
<body>

<nav class="navbar navbar-inverse" style="margin: 20px 0px 0px 0px;background-color:#20B2AA">
  <div class="container-fluid">
   <div class="navbar-header">
      <h2 class="navbar-brand" style="color:#F5F5DC;margin:5px 0px 0px 0px">FURNITURES</h2>
    </div>
    <ul class="nav navbar-nav" style="text-align:center">   
      <li><a style="color:#F5F5DC;margin:5px 0px 0px 0px" href="onLoad"><span class="glyphicon glyphicon-home"></span></a></li>
    </ul>
      <ul class="nav navbar-nav" style="text-align:center">   
       <li><h2 style="color:#F5F5DC;margin:9px 0px 0px 380px" ><center>MANAGE PRODUCTS</center></h2></li>
              		
	 
    </ul>
      <ul class="nav navbar-nav navbar-right">       
          <li class="divider-vertical"></li>
           <c:if test="${pageContext.request.userPrincipal.name != null}"> 		
          <li><h4 class="text-right" style="color:#F5F5DC;margin:20px 0px 0px 0px">HELLO, ${pageContext.request.userPrincipal.name}</h4></li>
          <li><a style="color:#F5F5DC;margin:5px 0px 0px 0px" href="<c:url value="/j_spring_security_logout" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
		</c:if> 
		</ul>	
  </div>
 
</nav>
 <div class="container" style="align:center; margin: 100px 0px 0px 150px">
 
  
  <div class="row" >
    <div class="col-md-4" >
      <a href="category" >        
        <h3 style="color:#F5F5DC"><center>CATEGORIES</center></h3>
        <img class="img-rounded" src="resources/images/cate3.jpg" alt="CATEGORIES" style="width:350px;height:250px">
      </a>
     
    </div>
    <div class="col-md-4">
      <a href="supplier" >
       <h3 style="color:#F5F5DC"><center>SUPPLIERS</center></h3>
        <img class="img-rounded" src="resources/images/sup1.jpg" alt="SUPPLIERS" style="width:350px;height:250px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="product" >
           <h3 style="color:#F5F5DC"><center>PRODUCTS</center></h3>  
        <img class="img-rounded" src="resources/images/pro3.jpg" alt="PRODUCTS" style="width:350px;height:250px">
      </a>
    </div>
  </div>
</div>
</body>
</html>