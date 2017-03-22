<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
	<head>
		<link href="<c:url value="/jquery-ui-1.12.1.custom/jquery-ui.css"/>" rel="stylesheet">
		<link href="<c:url value="/jquery-ui-1.12.1.custom/jquery-ui.structure.css"/>" rel="stylesheet">
		<link href="<c:url value="/jquery-ui-1.12.1.custom/jquery-ui.theme.css"/>" rel="stylesheet">
	    <script src="<c:url value="/jquery-ui-1.12.1.custom/external/jquery/jquery.js"/>"></script>
	    <script src="<c:url value="/jquery-ui-1.12.1.custom/jquery-ui.js"/>"></script>
	    <script src="<c:url value="/jquery-ui-1.12.1.custom/jquery.maskedinput.min.js"/>"></script>
	    
	</head>
  <body>
	  <c:import url="cabecalho.jsp"></c:import>
	    <form action="mvc?logica=SalvaContatoLogic&id=${contato.id}" method="post">
	      Nome: <input type="text" name="nome" value="${contato.nome}"/><br />
	      E-mail: <input type="text" name="email" value="${contato.email}"/><br />
	      Endereço: <input type="text" name="endereco" value="${contato.endereco}" /><br />
	      Data Nascimento: <caelum:campoData id="dataNascimento" valor="${contato.dataFormatada}"/><br />
	      
	      <input type="submit" value="Gravar" />
	    </form>
	   <c:import url="rodape.jsp"></c:import>
  </body>
</html>