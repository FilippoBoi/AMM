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
            
                 <label>
        Inserisci i dati dell'articolo da vendere:
    </label>
        <div>
        <form action="venditore.html" method="post">
            <label for="NomeArticolo">Nome articolo:</label>
            <input type="text" name="NomeArticolo" 
                   id="NomeArticolo" placeholder="Nome Articolo" value="${param["nomeoggetto"]}" required/>
            <br/>
            <label for="linkImg">Immagine:</label>
            <input type="url" name="linkImg" id="linkImg" placeholder="http://" value="${param["indirizzoImg"]}" required/>
            <br/>
            <br/>
           <label for="descrizione">Descrizione Oggetto:</label>
           <textarea rows="4" cols="30" name="descrizione" id="descrizione" value="${param["descrizione"]}"></textarea>
           <br/>
           <label for="prezzo">prezzo dell'articolo:</label>
           <input type="number" name="prezzo" id="prezzo" placeholder="00,00€" value="${param["prezzo"]}" required/>
           <br/>
           <label for="categoria"> categoria:</label>
           <input type="text" name="categoria" id="categoria" placeholder="Inserisci la categoria del prodotto" value="${param["categoria"]}" required/>
           <br>
           <label for="numeroArt"> numero articoli:</label>
           <input type="number" name="numeroArt" id="numeroArt" placeholder="1" value="${param["quantita"]}" required/>
           <input type="submit" value="Carica Prodotto"/>
        </form>
        
               <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
