<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<title>eCommerce Product Detail</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
	<link href="css/displayproduct.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>	
	<div class="container-fluid">
		<div class="card">
			<div class="container-fluid">
					<div class="row">
					<div class="col-md-4 col-lg-4 col-sm-6 col-xs-6">
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="<c:url value="/images/${product.productid}/${image}"/>" class="col-md-12 col-lg-12 col-xs-12 col-sm-12" style="height:250px"/></div>
						  <!-- 
						  <div class="tab-pane" id="pic-2"><img src="http://placekitten.com/400/252" /></div>
						  <div class="tab-pane" id="pic-3"><img src="http://placekitten.com/400/252" /></div>
						  <div class="tab-pane" id="pic-4"><img src="http://placekitten.com/400/252" /></div>
						  <div class="tab-pane" id="pic-5"><img src="http://placekitten.com/400/252" /></div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
						  <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a data-target="#pic-2" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a data-target="#pic-3" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a data-target="#pic-4" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a data-target="#pic-5" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						</ul>
						 -->
					</div>
					</div>
					<div class="col-md-4 col-lg-4 col-sm-6 col-xs-6">
						<h3 class="product-title">${product.productname}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">${product.description}</p>
						<h4 class="price">current price: <span>Rs.${product.price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<h5 class="sizes">sizes:
							<span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span>
							<span class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						<h5 class="colors">colors:
							<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
							<span class="color green"></span>
							<span class="color blue"></span>
						</h5>
						</div>
						<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
								<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
									<a href="${pageContext.request.contextPath}/product/edit/${product.productid}" class="btn btn-primary btn-block" type="button">Edit</a>							
									<a href="${pageContext.request.contextPath}/product/delete/${product.productid}" class="btn btn-danger btn-block" type="button">Delete</a>
								</sec:authorize>						
								<a href="${pageContext.request.contextPath}/cartitem/add/${product.productid}" class="btn btn-secondary btn-block" >Add To Cart</a>
								<a href="${pageContext.request.contextPath}/order/buy/${product.productid}"  class="btn btn-warning btn-block" type="button">Buy</a>
						</div>
				</div>
				</div>
			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>