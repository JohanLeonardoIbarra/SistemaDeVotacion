<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SistemaDeVotacion</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" href="<c:url value ="/CSS/Estilos.css"/>" />
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-danger text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Elecciones Estudiantiles</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="/SistemaVotacion/Index">Index</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" aria-disabled="true"
						href="/SistemaVotacion/RegistrarVotante">Registro</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">Acceder</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Masthead-->
	<header class="masthead bg-light text-black text-center">
		<div class="container d-flex align-items-center flex-column">
			<h1 class="masthead-heading text-uppercase mb-0">Registro</h1>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Formulario -->
			<form action="/SistemaVotacion/RegistrarVotante/insert" method="POST" class="w-50">
				<fieldset>
					<legend>Digite Sus Datos</legend>
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre
						</label> <input name="nombre" type="text" id="nombreText"
							class="form-control" placeholder="Fulanito Detal">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Correo
							</label> <input name="email" type="email" id="emailInput"
							class="form-control" placeholder="example@email.com">
					</div>
					<div class="mb-3">
						<label for="document" class="form-label">Documento
							</label> <input name="documento" type="text" id="documentoInput"
							class="form-control" placeholder="Identificacion">
					</div>
					<div class="mb-3">
						<label for="tipoDocumento" class="form-label">Tipo De Documento
							</label> <select id="tipoDocumento" name="Tipodocumento" class="form-select">
							<c:forEach var="documento" items="${tipoDocumento}">
								<option value="${documento.id}">${documento.descripcion}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="eleccion" class="form-label">Eleccion
							</label> <select id="eleccion" name="eleccion" class="form-select">
							<c:forEach var="eleccion" items="${elecciones}">
								<option value="${eleccion.id}">${eleccion.nombre}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Registrarse</button>
				</fieldset>
			</form>


			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Graphic
				Artist - Web Designer - Illustrator</p>
		</div>
	</header>




	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Location</h4>
					<p class="lead mb-0">
						2215 John Daniel Drive <br /> Clark, MO 65243
					</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-facebook-f"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-twitter"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-linkedin-in"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-dribbble"></i></a>
				</div>
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="text-uppercase mb-4">About Freelancer</h4>
					<p class="lead mb-0">
						Freelance is a free to use, MIT licensed Bootstrap theme created
						by <a href="http://startbootstrap.com">Start Bootstrap</a> .
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Copyright Section-->
	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2021</small>
		</div>
	</div>
</body>
</html>