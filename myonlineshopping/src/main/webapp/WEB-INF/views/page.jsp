<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/bootstrap-readable.css" rel="stylesheet">
  

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
	<script>
		window.menu = '${title}';
	</script>
  </head>

  <body>
  
	<div class="wrapper">
    <!-- Navigation -->
	<%@include file = "./shared/navbar.jsp" %>
	    
    <!-- Page Content -->
    <!-- Loading the Home content -->
    <c:if test="${userClickHome == true }">
		<%@include file = "home.jsp" %>
	</c:if>
	
	<!-- Load only if user clicks on About -->
	<c:if test="${userClickAbout == true }">
		<%@include file = "about.jsp" %>
	</c:if>
    
	<!-- Load only if user clicks on Contact -->
	<c:if test="${userClickContact == true }">
		<%@include file = "contact.jsp" %>
	</c:if>
	
	<!-- Load only if user clicks on Contact -->
	<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
		<%@include file = "listProducts.jsp" %>
	</c:if>
	

    <div class="push"></div>
    </div>
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>
    
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/popper/popper.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    
    <!-- custom js -->
    <script src="${js}/myApp.js"></script>

  </body>

</html>
