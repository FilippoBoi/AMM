<%-- 
    Document   : riepilogo
    Created on : 22-gen-2017, 12.36.47
    Author     : Filippo Boi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nerd-Help - Carrello</title>
        <meta charset="UTF-8">
        <meta name="description" content="Login al sito">
        <meta name="author" content="Filippo Boi">
        <meta name="keywords" content="Nerd-Help, Login">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <nav><hr>
            <ul>
                <c:if test="${sessionScope.utente != null}">
                    <li><a href="logout.html">Logout</a></li>
                    </c:if>
                <li> <a href="Descrizione.jsp"> info </a></li>
                <li> <a href="Cliente.jsp">Il mio profilo</a></li>
                <li> <a href="Venditore.jsp">Il mio negozio</a></li>
            </ul>
        </nav><hr>
        <table style='width:100%' >
            <tr> 
                <th>Immagine</th>
                <th>Nome Articolo</th>
                <th>Prezzo</th>
                <th>Descrizione</th>
                <th>Numero Pezzi</th>
                <th>Aggiungi al carrello</th>
            </tr>
            <tr> 
                <td> ${oggetto.nomeOggetto} </td> 
                <td> 
                    <c:if test="${ oggetto.IndirizzoIMG!= null}">   
                        <img title="${oggetto.nomeOggetto}" alt="${oggetto.nomeOggetto}" src="${oggetto.IndirizzoImg}" />
                    </c:if>
                </td> 
                <td> 

                    <c:choose>
                        <c:when test="${utente == 'venditore'}" >
                            ${oggetti.quantita} 
                        </c:when>
                        <c:otherwise>
                            1
                        </c:otherwise>
                    </c:choose>
                </td>
                <td> ${oggetti.prezzoUnita} </td>
            </tr>
        </table>


        <div id="descr_oggetto">
            <h3>Descrizione Oggetto</h3>       
            <p>${oggetto.descrizione}</p>       
        </div>


        <c:if test="${utente == 'venditore'}">
            <c:if test="${conferma != null}">        
                <c:if test="${conferma == true}">     
                    <p class="ok"> Inserimento avvenuto con successo! </p>
                </c:if>
            </c:if>

            <c:if test="${modifica != null}">        
                <c:if test="${modifica != null}">        
                    <c:if test="${modifica == true}">     
                        <p class="ok"> Modifica avvenuta con successo! </p>
                    </c:if>
                </c:if>
            </c:if>
        </c:if>

        <c:if test="${utente == 'cliente'}">
            <p class="messaggio"> Clicca sul pulsante per confermare l'acquisto<p>

            <form action="cliente.html?idOggetto=${oggetto.id}" method="post">
                <input type="submit" value="Conferma" id="conferma" name="conferma"/>
            </form>
        </c:if>

    <div id='footer'>
    
    <jsp:include page="footer.jsp" />
    </div>
</body>
</html>
