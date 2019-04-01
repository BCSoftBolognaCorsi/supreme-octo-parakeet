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
è un application server, il cui principale vantaggio è la leggerezza e la facile configurabilità.
Tomcat è configurato "out-of-the-box" già in modo che possano essere deployate la maggior parte delle
applicazioni web scritte in java. 
E' dotato di una semplice interfaccia di amministrazione 
che permette di effettuare il rilascio di nuove applicazioni, oppure rimuoverle, stopparne 
il contesto o riavviarlo.
Tomcat non implementa tutta la specifica JavaEE, ma solo Servlet, Jsp, EL, WebSocket (restano escluse JPA, Bean Validation Api, EJB, JMS)


Struttura di un'applicazione web in java 



Servlet
Una servlet è una classe Java eseguita lato server che genera il contenuto della risposta da inviare ad un client che ha effettuato una richiesta
Una servlet generalmente riceve delle richieste HTTP e risponde generando del codice HTML che rappresenta una pagina web


Jsp
