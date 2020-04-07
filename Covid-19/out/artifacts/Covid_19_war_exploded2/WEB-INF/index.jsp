<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Covid-19 Blog</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CMuli:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="../css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="../css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- HEADER -->
	<header id="header">
		<!-- NAV -->
		<div id="nav">
			<!-- Top Nav -->

			<div id="nav-top">
				<div class="container" >
					<!-- social -->
					<ul class="nav-social">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#"><i class="fa fa-instagram"></i></a></li>
					</ul>
					<!-- /social -->

					<!-- logo -->
					<div class="nav-logo" style="height: 180px; width:180px">
						<a href="index.html" class="logo"><img src="../img/logoCovid2.jpg" alt=""></a>
					</div>
					<!-- /logo -->

					<!-- search & aside toggle -->
					<div class="nav-btns">
						<button class="aside-btn"><i class="fa fa-bars"></i></button>
						<button class="search-btn"><i class="fa fa-search"></i></button>
						<div id="nav-search">
							<form>
								<input class="input" name="search" placeholder="Enter your search...">
							</form>
							<button class="nav-close search-close">
								<span></span>
							</button>
						</div>
					</div>
					<!-- /search & aside toggle -->
				</div>
			</div>
			<!-- /Top Nav -->


			<div id="nav-bottom">
				<div class="container">
					<ul class="nav-menu">
						<li class="has-dropdown" >
							<a href="/home">Home</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="category.html">Category page</a></li>
										<li><a href="blog-post.html">Post page</a></li>
										<li><a href="author.html">Author page</a></li>
										<li><a href="about.html">About Us</a></li>
										<li><a href="contact.html">Contacts</a></li>
										<li><a href="blank.html">Regular</a></li>
									</ul>
								</div>
							</div>
						</li>

						<li class="has-dropdown">
							<a href="index.html">ABOUT US</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">Who we are</a></li>
										<li><a href="#">What we do</a></li>
										<li><a href="#">Our values</a></li>
										<li><a href="#">Where we work</a></li>
									</ul>
								</div>
							</div>
						</li>

						<li class="has-dropdown">
							<a href="index.html">CONTACTS</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">Gmail</a></li>
										<li><a href="#">Facebook</a></li>
										<li><a href="#">Instagram</a></li>
										<li><a href="#">Twitter</a></li>
									</ul>
								</div>
							</div>
						</li>

						<li class="has-dropdown">
							<a href="index.html">COUNTRIES</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">Viet Nam</a></li>
										<li><a href="#">China</a></li>
										<li><a href="#">Italia</a></li>
										<li><a href="#">Korea</a></li>
										<li><a href="#">More...</a></li>
									</ul>
								</div>
							</div>
						</li>


						<li>
							<a href="/home?action=login">PRIMACY</a>
						</li>
					</ul>
				</div>
			</div>
			</div>
	</header>


	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2 class="title">RECENT POSTS</h2>
							</div>
						</div>
						<c:forEach items="${requestScope['news']}" var="news">
						<div class="col-md-6 clearfix visible-md visible-lg">
							<div class="post">
								<a class="post-img" href="/home?action=news&id=${news.getId()}"><img class="img-responsive" src="${news.getImg()}" alt=""></a>
								<div class="post-body">
									<h3 class="post-title"><a href="/home?action=news&id=${news.getId()}">${news.getTitle()}</a></h3>
									<ul class="post-meta">
										<li>${news.getDate()}</li>
									</ul>
								</div>
							</div>
						</div>
							<c:if test = "${news.getId() % 2 != 0}">
								<div class="clearfix"></div>
							</c:if>
						</c:forEach>
					</div>
				</div>

         <div class="col-md-4">
				<div class="aside-widget">
					<div class="section-title">
						<h2 class="title">Social Media</h2>
					</div>
					<div class="social-widget">
						<ul>
							<li>
								<a href="#" class="social-facebook">
									<i class="fa fa-facebook"></i>
									<span>21.2K<br>Followers</span>
								</a>
							</li>
							<li>
								<a href="#" class="social-twitter">
									<i class="fa fa-twitter"></i>
									<span>10.2K<br>Followers</span>
								</a>
							</li>
							<li>
								<a href="#" class="social-google-plus">
									<i class="fa fa-google-plus"></i>
									<span>5K<br>Followers</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
		 </div>


			</div>
		</div>
	</div>

	<div class="section" >
		<!-- container -->
		<div class="container" >
			<!-- row -->
			<div id="hot-post" class="row hot-post" >
	            <div class="aside-widget">
		           <div>
					   <div class="section-title">
				            <h2 class="title">CORONAVIRUS CASES</h2>
					   </div>

		         	     <div style="border:2px solid black; box-sizing: border-box; height: 250px">
				            <iframe class="embed-responsive-item" src="https://datawrapper.dwcdn.net/6TcVK/5/" style="border: none" height="400px" width="1136px"></iframe>
						 </div>
				   </div>
				</div>
			</div>
		</div>
	</div>



	<!-- FOOTER -->
	<footer id="footer">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-3">
					<div class="footer-widget">
						<div class="footer-logo">
							<a href="index.jsp" class="logo"><img src="../img/logo-alt.png" alt=""></a>
						</div>
						<p>Nec feugiat nisl pretium fusce id velit ut tortor pretium. Nisl purus in mollis nunc sed. Nunc non blandit massa enim nec.</p>
						<ul class="contact-social">
							<li><a href="#" class="social-facebook"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="social-twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="social-google-plus"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="social-instagram"><i class="fa fa-instagram"></i></a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Categories</h3>
						<div class="category-widget">
							<ul>
								<li><a href="#">About us</a></li>
								<li><a href="#">Contacts </a></li>
								<li><a href="#">Advertise</a></li>
								<li><a href="#">Primacy</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Tags</h3>
						<div class="tags-widget">
							<ul>
								<li><a href="#">CORONA</a></li>
								<li><a href="#">Nguyen Hong Nhung</a></li>
								<li><a href="#">VIET NAM</a></li>
								<li><a href="#">COVID-19</a></li>
								<li><a href="#">WU HAN</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Newsletter</h3>
						<div class="newsletter-widget">
							<form>
								<p>Nec feugiat nisl pretium fusce id velit ut tortor pretium.</p>
								<input class="input" name="newsletter" placeholder="Enter Your Email">
								<button class="primary-button">Subscribe</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</footer>

	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>

</body>

</html>
