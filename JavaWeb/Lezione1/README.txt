Lezione 1

Argomenti
	- Cos'è una WebApp
	- Apache Tomcat
	- Struttura di un'applicazione web in java 
	- Il deployment descriptor : web.xml
	- Servlet
	- Jsp 

Eclipse
	- Installazione di tomcat
	- Creare un dynamic web project in eclipse

Esempi
	- HelloServlet
	- HelloJsp

Per approfondimenti
	- https://www.slideshare.net/sunilos/jspservlet
	- https://github.com/criluc/servlet-jsp-tutorial


Cos'è una WebApp?
è un' applicazione accessibile/fruibile via web che utilizza l'architettura tipica 
client/server. Possiamo distinguere le webapp in due macro categorie:
	- presentation oriented: generano pagine web dinamiche in funzione delle richieste ricevute.

	- service oriented: forniscono endpoint di un web-service che si appoggiano a tecologie come JAX-WS o JAX-RS.

Le applicazioni web scritte in java girano all'interno di application server (detti anche web containers)
che implementano tutta o parte della specifica JavaEE


Apache Tomcat
Sul server deve essere presente un server web che supporta le servlet (chiamato servlet container).
Uno dei piu noti è
Tomcat (http://tomcat.apache.org)
Quando una richiesta raggiunge il server, questo cerca la servlet ad essa associata e quest'ultima genera il codice HTML con cui rispondere
Per ogni richiesta HTTP, il server avvia un thread che richiama i metodi della classe che si occupa di generare la risposta

Apache Tomcat è un application server, il cui principale vantaggio è la leggerezza e la facile configurabilità.
Tomcat è configurato "out-of-the-box" già in modo che possano essere deployate la maggior parte delle
applicazioni web scritte in java. 
E' dotato di una semplice interfaccia di amministrazione 
che permette di effettuare il rilascio di nuove applicazioni, oppure rimuoverle, stopparne 
il contesto o riavviarlo.
Tomcat non implementa tutta la specifica JavaEE, ma solo Servlet, Jsp, EL, WebSocket (restano escluse JPA, Bean Validation Api, EJB, JMS)


Struttura di un'applicazione web in java 



Il deployment descriptor : web.xml
Per ogni cartella rappresentante un'applicazione web, Tomcat ricerca informazioni su questa applicazione nella sottocartella WEB-INF
Per motivi di sicurezza, la cartella non viene pubblicata in rete
In questa cartella deve essere presente un file web.xml che descrive l'applicazione nel formato XML
Per fare uso di servlet, la cartella deve inoltre contenere la sottocartella classes contenente i file class che realizzano le servlet
Nel file web.xml è necessario associare un nome alla servlet
<servlet>
  <servlet-name>ServletName</servlet-name>
  <servlet-class>ServletClass</servlet-class>
</servlet>
... e quindi associare il nome della servlet all'URL alla quale rispondere
<servlet-mapping>
  <servlet-name>ServletName</servlet-name>
  <url-pattern>/servlet.html</url-pattern>
</servlet-mapping>
In questo esempio, una richiesta al file servlet.html verrà servita dalla classe ServletClass.class
E' possibile anche l'utilizzo delle Annotazioni direttamente sulle servlet
@WebServlet(name="ServletName", urlPatterns="/servlet.html")

Servlet
Una servlet è una classe Java eseguita lato server che genera il contenuto della risposta da inviare ad un client che ha effettuato una richiesta
Una servlet generalmente riceve delle richieste HTTP e risponde generando del codice HTML che rappresenta una pagina web


Jsp
