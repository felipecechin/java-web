<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.Contato,
				dao.ContatoDao,
				java.util.*" %>
<html>
  <body>
    <table>
      <tr>
      	<th>Nome</th>
      	<th>E-mail</th>
      	<th>Endereço</th>
      	<th>Data de nascimento</th>
      </tr>
      <%
      ContatoDao dao = new ContatoDao();
      List<Contato> contatos = dao.getLista();
      
      for (Contato contato : contatos ) {
      %>
        <tr>
          <td><%=contato.getNome() %></td> 
          <td><%=contato.getEmail() %></td>
          <td><%=contato.getEndereco() %></td>
          <td>
          <% 
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String dataFormatada = sdf.format(contato.getDataNascimento());
          out.print(dataFormatada);
          %>
          </td>
        </tr>
      <%
      }
      %>
    </table>
  </body>
</html>