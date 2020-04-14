<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.calendario.entity.Login"%>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/webjars/fontawesome/5.12.0/css/all.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">

<title>Pagina de Login</title>
</head>
<body>

<%
	if(session.getAttribute("erro")!=null){
		request.setAttribute("msg", "Dados Invalidos!");
		session.invalidate();
	}
%>
	

<style>
h1,h5 {
	color: #FFFAFA;
	text-shadow: black 0.1em 0.1em 0.2em;
}
</style>

<div class="jumbotron text-center" style="background: #7B68EE;">
	<h1>Seu Calendário Virtual  <i class="far fa-calendar-alt"> </i></h1>
</div>	 

	<div class="bg-dark text-center text-white">	
	<div class="bg-dark"  style="height:47px; margin-top:-34px"></div>
	<h3 style="margin-top:-50px;">Area de Login</h3>	
	</div>


	<div class="container-fluid" style="margin-top:-10px; height:400px; background:#F5F5F5">
	</div>
		<div class="card-body text-center shadow col-md-6 offset-md-3" style="margin-top:-338px;background:#F8F8FF">
			<form method="post" action="login">
				<br/><b>Email</b><br />
				<input type="email" name="email" value=""/> 
				<br/><b>Senha</b><br/>
				<input type="password" name="senha" value="" /><br />
				<button type="submit" class="btn text-white btn-dark" style="margin-top: 10px; background: ;">Logar</button>
				<br/>
				${msg}
			</form>
		</div>
			
	<div class="bg-dark text-center">	
	<div class="bg-dark"  style="height:75px; margin-top:58px"></div>
	<h5 style="margin-top:-50px;">Faça seu login para entrar no site de Agendamento de Eventos pessoais</h5>	
	</div>
	
</body>
</html>