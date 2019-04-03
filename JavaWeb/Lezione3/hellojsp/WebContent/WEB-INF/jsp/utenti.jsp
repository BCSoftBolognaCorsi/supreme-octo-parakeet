<%@page import="java.util.stream.Collectors"%>
<%@page
	import="net.bcsoft.corsi.dao.UtenteDao, java.util.*, net.bcsoft.corsi.models.*"%>
<div class="card" style="margin: 15px;">
	<h5 class="card-header">Utenti</h5>
	<div class="card-body">
		<a href="http://localhost:8080/hellojsp/viewer?cmd=sign_up"
			class="btn btn-success">Registra Utente</a>
<br><br>
		<%
			UtenteDao utenteDao = new UtenteDao();
			List<Utente> utentiList = utenteDao.getUtenti();
		%>
		<%
			if (utentiList != null && !utentiList.isEmpty()) {
		%>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col">Eta</th>
					<th scope="col">Linguaggi</th>
					<th scope="col">Azioni</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Utente utente : utentiList) {
				%>
				<tr>
					<th scope="row"><%=utentiList.indexOf(utente) + 1%></th>
					<td><%=utente.getNome()%></td>
					<td><%=utente.getEmail()%></td>
					<td><%=utente.getEta()%></td>
					<td><%=utente.getLinguaggi().stream().collect(Collectors.joining(",")) %></td>
					<td><a href="http://localhost:8080/hellojsp/viewer?op=DEL&idUtente=<%=utente.getId()%>"><i class="fas fa-trash-alt"></i></a>
						<a href="http://localhost:8080/hellojsp/viewer?cmd=sign_up&idUtente=<%=utente.getId()%>"><i class="fas fa-edit"></i></a>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>
</div>