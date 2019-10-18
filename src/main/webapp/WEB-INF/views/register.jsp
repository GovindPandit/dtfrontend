<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<spring:form action="registercontroller" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass" modelAttribute="user">
		<div class="form-group">
			<label>Enter Username</label>
			<spring:input path="username" placeholder="Enter Username" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Email</label>
			<spring:input path="email" placeholder="Enter Email" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Mobile</label>
			<spring:input path="mobile" placeholder="Enter Mobile" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter City</label>
			<spring:input path="address.city" placeholder="Enter City" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter State</label>
			<spring:input path="address.state" placeholder="Enter State" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Pincode</label>
			<spring:input path="address.pincode" placeholder="Enter Pincode" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Password</label>
			<spring:password path="password" placeholder="Enter Password" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Register" class="btn btn-block btn-primary"/>
			<input type="reset" value="Reset" class="btn btn-block btn-danger"/>
		</div>
	</spring:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>