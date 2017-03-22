<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de nascimento</th>
		</tr>
		<!-- percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
				<!-- <c:if test="${not empty contato.email}">
	        			<a href="mailto:${contato.email}">${contato.email}</a>
	      			</c:if>
				    <c:if test="${empty contato.email}">
				       	E-mail não informado
				    </c:if> -->
				</td>
				<td>${contato.endereco}</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy" />
				</td>
				<td>
				${id.count} 
				</td>
				<td>
					<a href="mvc?logica=AlteraContatoLogic&id=${contato.id}">Editar</a>
				</td>
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center"><a href="mvc?logica=AdicionaContatoLogic">Adicionar novo</a></td>
		</tr>
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>