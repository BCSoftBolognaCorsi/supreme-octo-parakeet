<%@ page import="net.bcsoft.corsi.models.*, java.util.*" %>
<% 
	Optional<Object> modelAttribute =  Optional.ofNullable(request.getAttribute("utente"));
	Utente utente = modelAttribute.isPresent() ? (Utente) modelAttribute.get() : null;
%>
<div class="card bg-light" style= "margin: 15px;">
	<div class="card-header">Sign Up</div>
	<div class="card-body">
		<h5 class="card-title">Form</h5>
		<form action="FormServlet" method="post">
			<input type="hidden" name="idUtente" value="<%= utente != null ? utente.getId() : "" %>" />
			<input type="hidden" name="cmd" value="sign_up" /> 
			<div class="form-group">
				<label for="exampleFormControlInput1">Email address</label> <input
					type="email" name="email" value="<%= utente != null ? utente.getEmail() : "" %>" class="form-control" id="exampleFormControlInput1"
					placeholder="name@example.com">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput2">Nome</label> <input
					type="text" name="nome"  value= "<%= utente != null ? utente.getNome() : "" %>" class="form-control" id="exampleFormControlInput2"
					placeholder="Nome">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Età</label> <select
					class="form-control" name="eta" id="exampleFormControlSelect1">
					<% for (int i = 1; i<100; i++){ %>
						<option <%= utente != null && utente.getEta() == i ? "selected" : "" %> ><%= i %></option>
					<%} %>
				
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect2">Linguaggi di Programmazione Preferiti
					</label> <select multiple class="form-control" name="linguaggi"
					id="exampleFormControlSelect2">
					<option <%= utente!=null && utente.getLinguaggi().contains("Java") ? "selected" : "" %>>Java</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("C++") ? "selected" : "" %>>C++</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("Python") ? "selected" : "" %>>Python</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("Go") ? "selected" : "" %>>Go</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("Php") ? "selected" : "" %>>Php</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("Typescript") ? "selected" : "" %>>Typescript</option>
					<option <%= utente!=null && utente.getLinguaggi().contains("Javascript") ? "selected" : "" %>>Javascript</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>