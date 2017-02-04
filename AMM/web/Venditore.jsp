<%-- 
    Document   : Venditore
    Created on : 22-gen-2017, 12.52.43
    Author     : Filippo Boi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerd-Help - Venditore</title>
        <meta charset="UTF-8">
        <meta name="description" content="pagina del venditore, carica articoli">
        <meta name="author" content="Filippo Boi">
        <meta name="keywords" content="Carrello, articoli, vendita">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
               <nav><hr>
            <ul>
        <c:if test="${sessionScope.utente != null}">
            <li><a href="logout.html">Logout</a></li>

        </c:if>
        <c:if test="${sessionScope.utente==null}">
                      <li><a href="Login.html">Login</a> </li>
        </c:if>
                <li><a href="Descrizione.jsp">Descrizione</a> </li>
                <li><a href="Cliente.html">Cliente</a></li>
            </ul>
        </nav><hr>
        <div >    

            <h3><center>  Inserisci i dati dell'articolo da vendere:</center></h3>
            <form class='formCenter' action="venditore.html" method="post">
                <div><label for="NomeArticolo">Nome articolo:</label></div>
                <input type="text" name="NomeArticolo" 
                       id="NomeArticolo" placeholder="Nome Articolo" value="${param["nomeoggetto"]}" required/>
                <br/>
                <div><label for="linkImg">Immagine:</label></div>
                <input type="url" name="linkImg" id="linkImg" placeholder="http://" value="${param["indirizzoImg"]}" required/>
                <br/>
                <br/>
                <div><label for="descrizione">Descrizione Oggetto:</label></div>
                <textarea rows="4" name="descrizione" id="descrizione" value="${param["descrizione"]}"></textarea>
                <br/>
                <div><label for="prezzo">prezzo dell'articolo:</label></div>
                <input type="number" name="prezzo" id="prezzo" placeholder="00,00€" value="${param["prezzo"]}" required/>
                <br/>
                <div><label for="categoria"> categoria:</label></div>
                <input type="text" name="categoria" id="categoria" placeholder="Inserisci la categoria del prodotto" value="${param["categoria"]}" required/>
                <br>
                <div> <label for="numeroArt"> numero articoli:</label></div>
                <input type="number" name="numeroArt" id="numeroArt" placeholder="1" value="${param["quantita"]}" required/><br>
                <input type="submit" value="Carica Prodotto"/>
            </form>
        </div>

        <div id='footer' style='position:absolute;bottom:1%'>

            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
