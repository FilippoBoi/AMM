<%-- 
    Document   : Descrizione
    Created on : 22-gen-2017, 12.31.21
    Author     : Macinino
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <title>Nerd-Help - descrizione</title>
        <meta charset="UTF-8">
        <meta name="description" content="descrizione del sito di E-Commerce">
        <meta name="author" content="Filippo Boi">
        <meta name="keywords" content="Info, Nerd-Help, payment">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
           <c:if test="${sessionScope.utente != null}">
            <div id="logout"><a href="logout.html">Logout</a></div>
        
        </c:if>
        <nav>
            <a href="Descrizione.jsp">Descrizione</a> 
            <a href="Login.jsp">Login</a> 
            <a href="Cliente.jsp">Cliente</a>
        </nav>
        
        <div>
		<ul>
            <li><a href="#contenuti">Contenuti</a></li>
            <li><a href="#funzioni">Funzionalità</a></li>
            <li><a href="#pagamento">Metodi di pagamento e Sistema rimborso</a></li>
            <li><a href="#funzioniclient">Funzionalità Cliente </a></li>
            <li><a href="#funzionivenditore">Funzionalità Venditore</a></li>
            <li><a href="#articoli">Articoli in vendita</a></li>
            <li><a href="#contenuti_categorie">Contenuti delle Categorie</a></li>
            <li><a href="#Libri">Libri</a></li>
            <li><a href="#Merchandise">Merchandise ed Oggettistica</a></li>
            <li><a href="#Giochi">Giochi e Videogiochi</a></li>
            <li><a href="periferiche">Periferiche</a></li>
        </ul>
        </div>
        <h1 id="contenuti">Contenuti</h1>
        <p> In questo sito sarà possibile trovare svariate tipologie di articoli, orientati principalmente ad un pubblico
            di appassionati di serie tv, videogiochi e libri. Saranno presenti delle funzionalità considerabili esclusive in base alla tipologia di utente</p>
        <h2 id="funzioni">Funzionalità</h2>
        <h3 id="funzioniclient"> Funzionalità Cliente</h3>
        <p>Dal punto di vista del cliente, il sito offrirà lui funzionalità quali:
        aggiungi alla lista desideri, salva per dopo, segui questo articolo, contatta il venditore
        Fai una domanda, vendi un prodotto, metti nel carrello e chiedi un rimborso. Una volta effettuato un acquisto, sarà necessario dare una
        valutazione sia all'articolo che al venditore. Qualora non venga effettuata
        questa valutazione, verrà inviato un promemoria al cliente ogni settimana.</p>
        <h3 id="funzionivenditore">Funzionalità Venditore</h3>
        <p> Il cliente, una volta messo in vendita un articolo, verrà considerato venditore solo per quell'articolo,
        e avrà a disposizioni le funzionalità seguenti: modifica numero articoli, modifica prezzo,
        rispondi alla domanda, effettua un rimborso, modifica stato(esaurito/ disponibile/in rifornimento) e modifica stato spedizione.
        Sarà inoltre possibile per il venditore appoggiarsi ad un sito di tracking. in quel caso, l'aggiornamento della 
        spedizione sarà automatizzato.</p>
        <h2 id="articoli">Articoli in Vendita</h2>
        <p>Gli articola in vendita rientreranno nelle seguenti categorie: Libri; Merchandise ed Oggettistica; Film e Serie Tv; Giochi e Videogiochi; Periferiche.</p>
        <h3 id="contenuti_categorie">Contenuti delle Categorie</h3>
        <h4 id="libri">Libri:</h4>
        <p> questa categoria conterrà libri italiani e stranieri, classici, nuove uscite e fumettistica.</p>
        <h4 id="Merchandise">Merchandise ed Oggettistica:</h4>
        <p>In questa categoria saranno presenti modellini, portachiavi, magliette, poste e tutto quello correlato alle serie tv e ai libri presenti</p>
        <h4 id="Giochi">Giochi e videoGiochi:</h4>
        <p>Questa categoria conterrà sia videogiochi per console e pc, che giochi da tavolo e giochi di carte</p>
        <h4 id="periferiche">Periferiche:</h4>
        <p>In questa categorie saranno presenti monitor, componenti per pc, tastiere, cuffie e mouse.</p>
        <h2 id="pagamento">Metodi Pagamento</h2>
        <p>Il cliente potrà pagare tramite carta di credito o di debito, siano esse mastercard, visa o american express, e tramite PayPal.
        Il sistema di rimborso sarà gestito dal cliente e dal venditore. Qualora entro 15 giorni non si sia raggiunto un accordo,
        Il rimborso verrà gestito da un responsabile terzo.</p>
    </body>
    <jsp:include page="footer.jsp" />
</html>
