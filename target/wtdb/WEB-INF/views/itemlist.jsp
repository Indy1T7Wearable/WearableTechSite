<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>WTDB - Home</title>
    <link type="text/css" href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link type="text/css" href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"></link>
	<link rel="shortcut icon" href="<c:url value='/static/img/icon.ico' />">
</head>
	<body>
		<nav class="navbar navbar-default navbar-fixed-top no-margin">
    	    <div class="navbar-header fixed-brand">
        	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
            	    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="<c:url value='/list' />"><i class="fa fa-home fa-4"></i> WearableTechDB</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
 	           <ul class="nav navbar-nav">
    	           <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"><i class="fa fa-bars"></i></button></li>
               </ul>
            </div>
    	</nav>
    	<div id="wrapper">
        	<div id="sidebar-wrapper">
            	<ul class="sidebar-nav nav-pills nav-stacked" id="menu">
 	               	<li class="active">
						<a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a>
                       	<ul class="nav-pills nav-stacked" style="list-style-type:none;">
                       		<li><a href="#">link1</a></li>
                       		<li><a href="#">link2</a></li>
                   		</ul>
                	</li>
        	    	<li>
            		    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span> Shortcut</a>
                	    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                	        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link1</a></li>
                	        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link2</a></li>
                	    </ul>
                	</li>
                	<li>
                	    <a href="<c:url value='/newitem' />"><span class="fa-stack fa-lg pull-left"><i class="fa fa-plus fa-stack-1x "></i></span>New Item</a>
                	</li>
                	<li>
                	    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-youtube-play fa-stack-1x "></i></span>About</a>
                	</li>
                	<li>
                	    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-server fa-stack-1x "></i></span>Contact</a>
                	</li>
            	</ul>
        	</div><!-- /#sidebar-wrapper -->
			<div id="page-content-wrapper">
    			<div class="container-fluid xyz">
    		    	<c:forEach items="${items}" var="item">
    			    	<div id="itembox">
    	    					<div id="imgcont"><img src="<c:url value='/static/img/${item.id}.png' />" alt="image-${item.id}"></div>
    	        				<h3>${item.brand} - ${item.name}</h3>
    	        				<h4>$${item.price}</h4>
    	        				<!-- <a href="<c:url value='/edit-item-${item.id}' />" class="btn btn-success">edit</a><a href="<c:url value='/delete-item-${item.id}' />" class="btn btn-danger">delete</a>-->
    	        		</div>
    	        	</c:forEach>
    	        	 
    	   		</div>
    	 	</div>
    	</div>
	</body>
	<script type="text/javascript" src="<c:url value='/static/js/jquery-2.1.4.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
</html>