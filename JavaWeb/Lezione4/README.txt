Lezione 4

Argomenti
	- MVC
	- IOC e Dependency Injection: Spring Framework
	- Spring MVC
	- Spring Boot vs Spring

Esempi
	- Hello Spring MVC
	- Hello Spring Boot (Goodbye applicationContext.xml)
	

MVC
E' un design pattern per relazionare efficientemente l'interfaccia utente con il sottostante data models
Tre componenti principali
Model: classi che rappresentano le strutture dati gestite dall'applicazione e si occupano di prelevarli, inserirli ed aggiornarli. Nota: Non hanno informazioni sulla user interface.
View: un insieme di classi che rappresentano gli elementi della user interface usati per mostrare le informazioni all'utente
Controller: classi che mettono in comunicazione il Model e la View e si occupano della gestione della richiesta dell'utente e della comunicazione tra le classi del Model e della View.

Vantaggi MCV
Migliore gestione della complessità:
Separazione della presentazione (view) dalla logica applicativa (model)
Di conseguenza il codice è pulito e facile da capire
Abilita lo sviluppo parallelo di più programmatori
Flessibilità: il frontend può essere modificato senza preoccuparsi del backend
Riusabilità: Lo stesso modello può essere riutilizzato su diverse user interface 

MCV in Java
Model: Plain Old Java Object (POJO) o Java Beans
View: Java Server Pages (JSP)
Controller: Java Servlet:
gestisce le richieste in ingresso
decide quale logica applicativa utlizzare per la gestione del modello
decide la pagina JSP appropriata per mostrare i dati specifici in funzione della richiesta ricevuta
Instanzia gli oggetti del modello ed invoca I metodi del modello in funzione della richiesta del client
demanda la presentazione del risultato delle elaborazioni fatte alla view opportuna (file JSP)  → RequestDispatcher
Al suo interno vengono utilizzati I metodi request.setAttribute o session.setAttribute per passare oggetti alla view

