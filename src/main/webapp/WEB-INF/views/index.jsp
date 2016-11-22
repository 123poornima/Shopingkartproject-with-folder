<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.reg
{
  font-family:italic;
}

h3.modal-title
{ 
   font-size: 120%;
   color:black;
   align:center;
}
body{ 
background-image: url(resources/images/bgk19.jpg); 
background-size:     cover;                      
    background-repeat:   no-repeat;
    background-color:black;
 }
 navbar {
  background-color: white;
  border-color: #1495fe;
}
</style>

</head>
<body bgcolor="black">


<h1 align="center" ><img src="resources/images/head1.png" height="60" width="400"/></h1>
<nav class="navbar navbar-inverse"  >
  <div class="container-fluid" style="color:white">
    <div class="navbar-header" style="color:white">
      <a style="color:#F5F5DC" class="navbar-brand" href="#">FURNITURE SHOP</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a style="color:#F5F5DC" href="#">HOME</a></li>
      <c:forEach items="${categoryList}" var="category">
      <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href=${category.c_Name}>${category.c_Name}<span class="caret"></span> </a>
      <ul class="dropdown-menu">
      <c:forEach items="${category.products}" var="product">
      <li><a style="color:#000000" href="<c:url value='product/get/${product.p_id}'/>"> ${product.p_name} </a>
    
     </c:forEach>
       <li><a style="color:#F5F5DC" href="#"></a></li>
     </ul>
      </li>       
      </c:forEach>
      
      <li><a style="color:#F5F5DC" href="aboutUs">CONTACT US</a></li> 
    </ul>
    
    
    
    <ul class="nav navbar-nav navbar-right">   
    
      <li class="divider-vertical"></li>
       <c:if test="${pageContext.request.userPrincipal.name != null}">
      <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
      <li><a  href="<c:url value="/myCart" />"><span class="glyphicon glyphicon-shopping-cart"></span> CART</a>${cartSize}</li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
       <li><a style="color:#F5F5DC" href="<c:url value="/admin" />">VIEW ALL</a></li>
       </c:if>
       <li><a style="color:#F5F5DC">HELLO, ${pageContext.request.userPrincipal.name}</a></li>
       <li><a  style="color:#F5F5DC;margin:0px 0px 0px 0px" href="<c:url value="/j_spring_security_logout" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
       </c:if>
       <c:if test="${pageContext.request.userPrincipal.name  == null}">
       <li><a  style="color:#F5F5DC;margin:0px 0px 0px 0px" href="<c:url value="/login" />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a  style="color:#F5F5DC;margin:0px 0px 0px 0px" href="<c:url value="register" />"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       </c:if>
    
    
<!--           <li><a href="register" ><span class="glyphicon glyphicon-log-in"></span>Sign Up</a></li>  -->
<!--              <li><a href="admin" ><span class="glyphicon glyphicon-log-in"></span>Admin Page</a></li>  -->
<!--           <li><a data-toggle="modal" data-target="#loginmodal"><span class="glyphicon glyphicon-user"></span>Login</a></li>  -->
    </ul>
  </div>
</nav>


<%--product list declartion  --%>	
			
			<div class="container" style="align:center">
			<div class="row">
				<c:if test="${!empty selectedProduct.p_name}">
				  <div class="col-md-10 col-md-offset-1">

                    <div class="panel panel-info">
                     <div class="panel-body">
					<table class="table table-striped table-bordered table-list">
					  
						<tr>
<!-- 							<th align="center" width="125" ><font color="grey">Product ID</font></th> -->
							<th align="center" width="175"><font color="black">Product Name</font></th>
							<th align="center" width="190"><font color="black">Product Description</font></th>
							<th align="center" width="90"><font color="black">Price</font></th>
							<th align="center" width="150"><font color="black">Product Category</font></th>
							<th align="center" width="150"><font color="black">Product Supplier</font></th>
							<th align="center" width="150"><font color="black">Product Image</font></th>
                           
						</tr>
						<tr>
<%-- 							<td align="left" ><font color="grey">${selectedProduct.id}</font></td> --%>
							<td align="left" ><font color="black">${selectedProduct.p_name}</font></td>
							<td align="left" ><font color="black">${selectedProduct.p_description}</font></td>
							<td align="left" ><font color="black">${selectedProduct.p_price}</font></td>
							<td align="left" ><font color="black">${selectedProduct.category.c_Name}</font></td>
							<td align="left" ><font color="black">${selectedProduct.supplier.s_Name}</font></td>
							<td align="left" ><img src="<c:url value="/resources/images/${selectedProduct.p_id}.jpg"/>" /></td>
						
<%-- 							<td align="left" ><a href="<c:url value='cart/add/${selectedProduct.p_id}' />"><button type="button" class="btn btn-primary">Add to Cart</button></a></td> --%>
							
						</tr>
						
					</table>
					<hr>
					</div>
					<div class="panel-footer">
					<div class="row text-center">
						
						<div class="col-xs-3">
							<a style="align:right" href="<c:url value='cart/add/${selectedProduct.p_id}' />"><button  type="button" class="btn btn-primary">Add to Cart</button></a>
						</div>
					</div>
     				</div>  
					</div>
					</div>
				</c:if>
			</div>
</div>




<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox" >
    <div class="item active">
      <img src="resources/images/fur35.jpg" alt="Chania" class="img-rounded center-block" width="1020px" height="920px">
    
    </div>

    <div class="item">
      <img src="resources/images/img6.jpg" alt="Chania" width="1020px" height="920px" class="img-rounded center-block">
      <div class="carousel-caption">
       
     
      </div>
    </div>

    <div class="item">
      <img src="resources/images/img7.jpg" alt="Flower" width="1020px" height="920px" class="img-rounded center-block">
      <div class="carousel-caption">
       
      
      </div>
    </div>

    <div class="item">
      <img src="resources/images/fur39.jpg" alt="Flower" width="1020px" height="920px" class="img-rounded center-block">
      <div class="carousel-caption">
      
        
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>
