<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body{ 
background-image: url(resources/images/bgk19.jpg); 
background-size:     cover;                      
    background-repeat:   no-repeat;
 } 
 
 
</style>
</head>
<body>

 <div style="color:#000000;margin:40px 0px 0px 100px">
    <a style="color:#000000;font-size:2.0em" href="onLoad"><span class="glyphicon glyphicon-home"></span></a>
   </div>
<!-- Registration code -->
<div class="container" > 



   <div class="container" style="align:center; margin: 120px 0px 0px 10px"> 
   <div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
       
    
     
      
       <form:form method="POST" commandName="user" action="register/add" role="form">
       <h2 style="color:#000000;align:center">Please Sign Up</h2>
		<hr class="colorgraph">
       <div class="row">
				<div class="col-xs-12 col-md-6">
					<div class="form-group" >
                        <form:input style="background-color:#FFFFE0" required="true" path="name" type="text" name="name" id="first_name" class="form-control input-lg" placeholder="Name" tabindex="1" />
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input style="background-color:#FFFFE0" required="true" path="phoneNo" type="text" name="phoneno" id="phone_no" class="form-control input-lg" placeholder="Phone Number" tabindex="2" />
					</div>
				</div>
			
			</div>
		
			
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input style="background-color:#FFFFE0" path="address" required="true" type="text" name="address" id="address" class="form-control input-lg" placeholder="Address" tabindex="3" />
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input style="background-color:#FFFFE0" path="password" required="true"  type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="4" />
					</div>
				</div>
				
			</div>
			<div class="form-group">
				<form:input style="background-color:#FFFFE0" required="true"  path="mailId" type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="5" />
			</div>
			<!-- <div class="row">
				<div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>
                        <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
					</span>
				</div>
				
			</div> -->
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="6" ></div>
				
			</div>
       </form:form>
      </div>
       </div>
    </div>
   </div>
<!-- Modal -->
<!-- <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
			</div>
			<div class="modal-body">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
			</div>
		</div>/.modal-content
	</div>/.modal-dialog
</div>/.modal
 -->

</div>
   
 



	
	
	
	

</body>
</html>