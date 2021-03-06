<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta charset="utf-8">
	<base href="${pageContext.request.contextPath }/user/"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Health Line HTML5 template</title>
	<link href="css/font-awesome.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/settings.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">
	<link href="css/owl.carousel.css" rel="stylesheet">
	<link href="css/owl.transitions.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/color.css" rel="stylesheet">
	<link href="css/datepicker.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<![endif]-->
</head>

<body class="single-page">

<!--preloader start-->
        <!--preloader end-->
	<!-- page-wraper -->
	<main class="page-wraper">

	<div id="services">
		<!-- services section -->
		
		<!-- appointment section -->
		<article class="section">
			<div class="section-image" style="background-image:url(imges/bg-image-1.png);">
				<div class="container">
					<!-- appointment-area -->
					<div class="appointment-area">
						<div class="row">
							<div class="col-sm-10 col-md-6">
								<!-- appointment-box -->
								<div class="appointment-box">
									<header>
										<h4>Register Complaint</h4>
									</header>
									<div class="text">
										<form class="appointment-form" method="post" action="<%=request.getContextPath()%>/ComplaintController">
										<input type="hidden" name="flag" value="complaint"/>
											<ul class="row">
												
												<li class="col-sm-12">
													<label>COMPLAINT TITLE</label>
													<input type="text" placeholder="enter complaint title" class="form-control" name="ctitle">
												</li>
												
											
												<li class="col-sm-12">
													<label>COMPLAINT MESSAGE</label>
													<ul class="row form-buttons">
														<textarea placeholder="Type your Complaint description" class="form-control" name="cdesc"></textarea>
						
													</ul>
												</li>
											</ul>
											<div class="appintment-form-btm">
												
												<input type="submit" class="btn btn-primary" value="Send Message">
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-sm-6 appointment-box-snap"> <img src="imges/img-1.png" alt="image doctor"> </div>
						</div>
					</div>
				</div>
			</div>`
		</article>
	</div><!-- /#services -->

	
</body>
</html>