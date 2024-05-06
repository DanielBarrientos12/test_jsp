<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicación gestion de usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #ff4436" >
			<div>
				<a href="#" class="navbar-brand">Gestión de usuarios</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Usuarios</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<section>
		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">
					<c:if test="${usuario != null}">
						<form action="update" method="post">
					</c:if>
					<c:if test="${usuario == null}">
						<form action="insert" method="post">
					</c:if>
					
					<caption>
						<h2>
							<c:if test="${usuario != null}">
								Editar usuario
							</c:if>
							<c:if test="${usuario == null}">
								Agregar nuevo usuario
							</c:if>
						</h2>
					</caption>
					
					<c:if test="${usuario != null}">
						<input type="hidden" name="id" value="<c:out value='${usuario.id}'/>"> 
					</c:if>
					
					<fieldset class="form-group">
						<label>Nombre de usuario</label> <input type="text" value="<c:out value='${usuario.nombre}'/>" class="form-control" name="nombre" required="required">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Correo del usuario</label> <input type="text" value="<c:out value='${usuario.email}'/>" class="form-control" name="email">
					</fieldset>
					
					<fieldset class="form-group">
						<label>País del usuario</label> <input type="text" value="<c:out value='${usuario.pais}'/>" class="form-control" name="pais">
					</fieldset>
					
					<br>
					<button type="submit" class="btn btn-success">Guardar</button>
					</form>
				</div>
			</div>			
		</div>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>