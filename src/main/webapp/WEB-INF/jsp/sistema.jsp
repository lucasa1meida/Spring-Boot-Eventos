<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.calendario.entity.Login" %>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/webjars/fontawesome/5.12.0/css/all.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">

<c:set var="caminho" value="${pageContext.request.contextPath}"/>
<c:out value="${caminho}" />

<title>Calendario de Evento</title>
</head>
<body>

<%
	if(session.getAttribute("login")==null){
		session.invalidate();
		response.sendRedirect("/");
	}else{
		Login login = (Login) session.getAttribute("login");
		out.print("<h5 class='text-right text-white' style='background: #7B68EE;height:30px;'> Bem Vindo " + login.getNome() + "</h5><br/>");
%>

<style>
h1{
	color: #FFFAFA;
	text-shadow: black 0.1em 0.1em 0.2em;
}
</style>

<h1 class="jumbotron text-center" style="background: #7B68EE;margin-top:-33px;"><b>Sistema Calendário de Evento</b></h1>

<div class="text-center shadow bg-light" style="margin-top:-32px">
	<form method="post" action="gravar" style="margin-top:-20px;">
	<div class="card header text-center bg-dark text-white">
	<h5 style="margin-top:10px;">Cadastrar Evento <a href="logoff" class="offset-md-11 btn-sm btn btn-link" style="margin-top:-25px;">Logout</a></h5>
	</div>
	<div class="card-body" style="margin-top:-28px;">
	<br/><b>- Nome -</b><br/><input class="text-center" type="text" name="nome" value=""/>
	<br/><b>- Data -</b><br/><input class="text-center" type="text" name="data" value=""/>
	<br/><b>- Horário -</b><br/><input class="text-center" type="text" name="horario" value=""/>
	<br/><b>- Descrição -</b><br/><input class="text-center" type="text" name="descricao" value=""><br/><br/>
	<button type="submit" class="btn btn-sm btn-dark" style="margin-top:-10px;">Gravar Evento</button><br/>
	</div>
</form>
</div>

<form method="post" class="jumbotron" style="margin-top:-15px">
	<table class="container col-md-6">
	<thead class="">
		<tr>
		<th>Nome</th>
		<th>Data</th>
		<th>Horário</th>
		<th>Descrição</th>
		<th></th>
		<th></th>
		</tr>
			<tbody>
			 <c:forEach items="${lista}" var="linha">
			 	<tr>
			 	<td>${linha.nome}</td>
			 	<td>${linha.data}</td>
			 	<td>${linha.horario}</td>
			 	<td>${linha.descricao}</td>			 	
			 	<td><a href="${caminho}/excluir/${linha.cod}">Excluir</a></td>			 	
			 	</tr>
			 	
			 </c:forEach>			
			</tbody>			
	</thead>	
	</table>
</form>

<div style="margin-top:-32px">
	<div class="bg-dark"  style="height:10px;"></div>
	<div class="bg-dark"  style="height:40px;"></div>
	<div class="bg-dark text-white text-center " style="margin-top:-33px;">
	<h5 style="font-size:13px;">@Copyright Lucas Santos de Almeida</h5>
</div>
</div>
</div>
<%
}
%>
</body>
</html>