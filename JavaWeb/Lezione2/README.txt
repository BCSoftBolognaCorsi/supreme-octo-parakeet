Lezione 2

Argomenti
	- Jsp


Esempi
	- HelloJsp (crud completo)


Jsp
JSP: “una tecnologia Java che fornisce una modalità semplificata e veloce per creare e mantenere facilmente pagine web dinamiche basate su HTML, XML o altri tipi di documento”
Sono una astrazione ad alto livello delle Java servlets: sono tradotte a runtime in servlets a partire da un file sorgente  JSP
Richiedono un Servlet container, per esempio Tomcat
Il ciclo di vita delle JSP è molto simile a quello Java Servlet:
Step 1: JSP Page Translation: Tradotte in Servlet source code
Step 2: JSP Page Compilation: Compilate in una Servlet class
Gli altri passi sono simili alle Java Servlet


Come scrivere codice in una jsp
Codice Java dentro l'HTML utilizzando speciali tag JSP, chiamati JSP Scriting elements
3 categorie di JSP Scriting elements:
Declaration Tags
Definiscono variabili e metodi in JSP, cominciano con <%! e finiscono con %>
Esempio <%! String username = Shan; %>
Expression Tags:
Producono un output (una stringa) che può essere utilizzata per mostrare un risultano nelle JSP, cominciano con <%= e finiscono con %>
esempio <%= name %>
Scriptlets:
Cominciano con <% e finiscono con  %>


Syntax 			Elements	Standard 		Syntax	XML Syntax
Comments		<%--.. --%>					<!-- .. -->
Declarations	<%! ..%>					<jsp:declaration> .. </jsp:declaration>
Directives		<%@ include .. %>			<jsp:directive.include .. />
				<%@ page .. %>				<jsp:directive.page .. />
				<%@ taglib .. %>			xmlns:prefix="tag library URL"
Expressions		<%= ..%>					<jsp:expression> .. </jsp:expression>
Scriptlets		<% ..%>						<jsp:scriptlet> .. </jsp:scriptlet>


Oggetti impliciti in Jsp
request		HttpServletRequest associato alla richiesta HTTP
response	HttpServletResponse associata con la risposta per il client
out			PrintWriter utilizzato per inviare l'ouput al client
session		HttpSession associata alla richiesta
application	ServletContext associato con il contesto dell'applicazione
config		ServletConfig associato alla pagina
pageContext	Incapsula l'utilizzo di funzionalità specifiche del server come per esempio high performance JspWriters
page		Sinonimo di this, utilizzato per chiamare metodi definiti nella Servlet class derivata dalla traduzione della JSP corrente

Servlet vs Jsp
le Servlet sono classi Java che supportano anche i tag HTML
sono generalmente utilzzate per sviluppare il business layer di una applicazione web
sono create e mantenute da sviluppatori Java
le JSP Sono codice HTML che supporta anche le istruzioni Java
Sono utilizzate per sviluppare il presentation layer di una applicazione web
Sono spesso utilizzate per disegnare siti web e utilizzate dai web designer





