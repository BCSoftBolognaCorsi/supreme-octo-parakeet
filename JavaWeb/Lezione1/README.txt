Lezione 1

Argomenti
	- Cos'è una WebApp
	- Apache Tomcat
	- Struttura di un'applicazione web in java 
	- Il deployment descriptor : web.xml
	- Servlet
	- Servlet Lifecycle
	- Sessioni Http
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
Per ogni richiesta HTTP, il server avvia un thread (prendendolo da un pool di thread chiamato connector pool o executor pool) che richiama i metodi della classe che si occupa di generare la risposta

Apache Tomcat è un application server, il cui principale vantaggio è la leggerezza e la facile configurabilità.
Tomcat è configurato "out-of-the-box" già in modo che possano essere deployate la maggior parte delle
applicazioni web scritte in java. 
E' dotato di una semplice interfaccia di amministrazione 
che permette di effettuare il rilascio di nuove applicazioni, oppure rimuoverle, stopparne 
il contesto o riavviarlo.
Tomcat non implementa tutta la specifica JavaEE, ma solo Servlet, Jsp, EL, WebSocket (restano escluse JPA, Bean Validation Api, EJB, JMS)


Struttura di un'applicazione web in java 
	WebContent
		WEB-INF
			lib
			classes
			web.xml
		META-INF
			MANIFEST
		OTHER-FOLDERS


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

Per realizzare una servlet HTTP, occorre estendere la classe
HttpServlet del package javax.servlet.http
questa classe, insieme ad altre che implementano funzionalità delle servlet in javax.servlet.*, non sono presenti nel JDK ma vengono fornite separatamente
<dependency>
 <groupId>javax.servlet</groupId>
 <artifactId>javax.servlet-api</artifactId>
 <version>3.1.0</version>
</dependency>
per ogni servlet è possibile riscrivere i metodi di HttpServlet che vogliamo utilizzare per rispondere alle richieste HTTP

per realizzare una servlet, implementare il metodo
doGet(HttpServletRequest request, HttpServletResponse response)
che viene richiamato quando una richiesta GET viene fatta alla pagina
analogamente, i metodi doPost, doPut, doTrace, doDelete e
doOptions gestiscono gli altri tipi di richiesta HTTP
L'oggetto HttpServletRequest passato rappresenta la richiesta
HTTP e può essere utilizzato per estrarne i vari campi

HttpServletRequest: interfaccia che estende ServletRequest e fornisce l'accesso alle proprietà specifiche di una richiesta HTTP.
HttpServletResponse: interfaccia che estende ServletResponse e fornisce l'accesso alle proprietà specifiche di una risposta HTTP.

tramite il metodo setContentType(String contentType) di HttpServletResponse si imposta il tipo di dato che verrà restituito;
da utilizzare prima dell'invio del contenuto della pagina
con il metodo getWriter() si ottiene il Writer sul quale si può scrivere il contenuto della risposta HTTP
alternativamente, si può usare il metodo getOutputStream() per ottenere lo stream in uscita
avere l'OutputStream è necessario quando si inviano al client dati non testuali. Altrimenti l'utilizzo di un Writer è solitamente piu` comodo
richiamare solo uno dei due metodi getWriter() e getOutputStream().
getWriter() deve inoltre essere richiamato dopo setContentType() per garantire una codifica corretta

I metodi che manipolano l'intestazione della risposta HTTP devono essere richiamati prima dell'invio di qualsiasi contenuto
Il metodo setStatus(int sc) assegna un determinato valore al codice di risposta
E' possibile utilizzare le costanti pubbliche della classe per questi codici, come in  
response.setStatus(HttpServletResponse.SC_OK);
Il metodo setError(int sc, String msg) permette di specificare un codice ed un messaggio di errore
Infine il metodo sendRedirect(String location) richiede la redirezione ad un'altra pagina

per manipolare le intestazioni HTTP della richiesta, si possono usare I metodi getHeader(String name) e getHeaderNames() di HttpServletRequest
analogamente, gli header della risposta possono essere impostati tramite I metodi della interfaccia HttpServletResponse
setHeader(String name, String value) e
addHeader(String name, String value)


i parametri inviati al server in GET o POST possono essere recuperati tramite il metodo getParameter(String name) di HttpServletRequest
il metodo richiede in ingresso il nome del parametro desiderato e ne restituisce il contenuto come una stringa
nel caso il parametro con il nome richiesto non sia stato inviato, il metodo restituisce null

Servlet Lifecycle
Il ciclo di vita di una servlet è controllato dal container nel quale ne è stato fatto il deploy. Quando una richiesta è associata ad una servlet, il container:
se non esiste un'istanza della servlet il web container carica la servlet class
crea un'instanza della servlet
Inizializza l'istanza della servlet passando i parametri al metodo chiamando il metodo init
invoca il metodo service passandogli la richiesta e l'oggetti per la risposta
se deve rimuovere la servlet, il container si occupa di chiamare I metodo destroy della servlet
I metodi del lifecycle
public void init()
invocato dal Servlet Container
precede qualunque ulteriore invocazione
termina prima di qualsiasi ulteriore invocazione
tipicamente si effettua overriding di questo metodo per creare le connessioni ad altri oggetti Container-managed, utili durante tutto il resto del ciclo di vita
public void destroy()
invocato dal Servlet Container
termina solo dopo che ogni altra invocazione ha terminato la propria esecuzione
tipicamente si effettua overriding di questo metodo per rilasciare le risorse occupate prima che la Servlet venga distrutta




Sessioni Http
In Java una sessione HTTP viene rappresentata tramite un oggetto HttpSession
tramite le sessioni si realizza la gestione dello stato degli oggetti tra una richiesta HTTP e l'altra
le servlet forniscono un meccanismo di gestione delle sessioni tramite cookie.
se questo non è possibile si può alternativamente passare l'ID di sessione tra I parametri della pagina
per questo scopo, il metodo encodeURL(String URL) di HttpServletResponse aggiunge il parametro con l'id di sessione all'URL passata nel caso in cui questo sia necessario
il metodo getSession() in HttpServletRequest restituisce la sessione corrente o ne crea una nuova se questa non esiste

altri metodi utili di HttpSession per la gestione della sessione
per ottenere o impostare il tempo di inattivit`a dopo il quale la sessione scade
getMaxInactiveInterval()
setMaxInactiveInterval(int time)
	restituire l'identificativo di sessione
getId()
	rimuovere gli attributi della sessione o per la sua distruzione
removeAttribute(String name)
	rimuove un attributo dalla sessione
invalidate()
	distrugge la sessione corrente, scollegando tutti gli oggetti associati ed invalidandola

metodi per settare e recupare valori di un attributo in session:
setAttribute()
getAttribute()



Jsp

