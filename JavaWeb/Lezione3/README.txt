Lezione 3

Argomenti
	- Filtri


Esempi
	- HelloJsp (auth filter)
	
Per Approfondire
https://www.journaldev.com/1933/java-servlet-filter-example-tutorial
	
	
L’utilizzo dei filtri, nelle applicazioni Web, è stato promosso, a “standard de jure”, con l’avvento delle specifiche 2.3 delle Servlet,
 sebbene alcuni produttori di Application Server avessero già in precedenza fornito delle funzionalità simili, anche se differenti l’una dall’altra.

Cosa sono i Filtri?
Supponiamo di aver scritto una Servlet che gestisca l’autenticazione degli utenti relativamente ad una certa applicazione Web. 
Probabilmente, avremo costruito la nostra servlet in modo che verifichi l’esistenza delle credenziali di accesso fornite dagli utenti, 
interrogando un DataBase e, in caso positivo, istanziando una nuova sessione per ogni utente riconosciuto.

Supponiamo, adesso, che la nostra applicazione Web necessiti di tenere traccia di tutti i tentativi di accesso,
da parte degli utenti (sia quelli riconosciuti dal sistema che quelli errati o potenzialmente illeciti),
 a causa di un presunto tentativo di login con credenziali non autenticate.

La prima cosa che ci viene in mente è quella di modificare la nostra Servlet in modo che scriva da qualche parte tali informazioni. 
La modifica (semplice o meno che sia) implicherà, comunque, una nuova operazione di deployment sull’Application Server.

Lo scenario appena descritto è uno dei classici esempi in cui l’utilizzo di un filtro casca a fagiolo. 
I filtri rappresentano un modo per fornire una funzionalità aggiuntiva a una applicazione Web.

La potenza dei filtri risiede nel fatto che essi consentono di cambiare il comportamento delle applicazioni Web agendo sul deployment descriptor
 e sollevando il programmatore dalla necessità di modificare ogni volta il codice (e rieffettuare il deployment dell’applicazione).
 
 
Casi d'uso di un filtro: 
Filtri di Autenticazione (Authentication filters)
Filtri di Logging e Auditing
Filtri per la compressione dei dati (Data compression Filters)
Filtri di criptazione (Encryption Filters)
Filtri di conversione delle immagini (Image conversion Filters)


Come si implementa un Filtro
Per utilizzare un filtro all’interno di un’applicazione Web sono necessarie due cose:

Scrivere una classe che implementi l’interfaccia javax.servlet.Filter
Modificare il Deployment Descriptor per istruire il container relativamente alle modalità di utilizzo del filtro che abbiamo definito
Per prima cosa andiamo a scoprire quali sono i metodi definiti nell’interfaccia javax.servlet.Filter:

void init(FilterConfig filterConfig): Viene invocato, dal web container, subito dopo la creazione dell’istanza di un filtro e appena prima della messa in servizio del filtro stesso.
void doFilter(ServletRequest request, ServletResponse response, FilterChain chain): Viene invocato, dal web container, e contiene l’implementazione vera e propria del filtro.
void destroy(): Viene invocato, dal web container, per indicare ad un filtro il termine del suo ciclo di vita.


Per soddisfare le richieste pervenute, il container invoca il metodo doFilter() e, 
al termine del ciclo di vita del filtro stesso, richiama il metodo destroy(). 
Come è possibile osservare, il metodo doFilter() definisce al suo interno un parametro chain, di tipo FilterChain,
che fornisce un riferimento alla catena di filtri a cui la richiesta iniziale dovrà essere sottoposta. 
Infatti, è possibile filtrare le richieste pervenute dai client con una sorta di catena di filtri che prevede 
l’invocazione a cascata di tutti i filtri coinvolti nella catena stessa.

L’unico metodo definito nell’interfaccia javax.servlet.FilterChain è il seguente:

void doFilter(ServletRequest request, ServletResponse response): Richiama il successivo Filtro da invocare, 
nella catena di filtri definita dal parametro chain.
Nel caso in cui il filtro chiamante sia l’ultimo, o l’unico, della catena allora verrà richiamata la risorsa posta al termine della catena stessa.

Implementazione:
	- nel web.xml (deployment descriptro)
	<filter>
		<filter-name>Il nome del filtro</filter-name>
		<display-name>Il nome del filtro visualizzato dai tool di gestione</display-name>
		<description>Una descrizione del filtro</description>
		<filter-class>Il nome completo della classe del filtro</filter-class>
		<init-param>
			<param-name>il nome di un parametro di inizializzazione del filtro</param_name>
			<param-value>il valore del parametro di inizializzazione</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>Lo stesso nome utilizzato all’interno del tag filter</filter name>
		<url-pattern>La URL del componente a cui applicare il filtro</url-pattern>
	</filter-mapping>
	- classe che implementa javax.servlet.Filter