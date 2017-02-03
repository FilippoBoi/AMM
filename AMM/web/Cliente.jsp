<%-- 
    Document   : Cliente
    Created on : 14-dec-2016, 16.31.38
    Author     : Filippo Boi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerd-Help - Cliente</title>
        <meta charset="UTF-8">
        <meta name="author" content="Filippo Boi">
        <meta name="description" content="pagina del cliente, carrello">
        <meta name="keywords" content="Cliente, Articoli, Carrello">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css">
        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
        <script type="text/javascript" src="js/filter.js"></script>
    </head>
    <body>
        <c:if test="${sessionScope.utente != null}">
            <div id="logout"><a href="Logout.html">Logout</a></div>
        
        </c:if>
        <nav>
            <a href="Descrizione.jsp">Descrizione</a> 
            <a href="Login.jsp">Login</a> 
            <a href="Cliente.jsp">Cliente</a>
        </nav>
            <br><br>
            <div>
                <c:if test="${conferma==true}">
                    <c:choose>
                        <c:when test="${pagamento == true}" >
                            <p class="ok"> Pagamento avvenuto con successo! </p>
                        </c:when>
                        <c:otherwise>
                            <p class="errore"> Il tuo saldo non è sufficiente, riprova in un secondo momento! </p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                         
                     
                <c:if test="${errore == true}" >
                    <p class="errore"> Si è verificato un errore nel pagamento, riprova! </p>
                </c:if>
                    </div>
            <div>
                
                           <label for="filtra">Filtra</label>
                <input type="text" name="filtra" id="filtra" value="" />
       
           <table style='width:100%' >
                <tr> 
                    <th>Immagine</th>
                    <th>Nome Articolo</th>
                    <th>Prezzo</th>
                    <th>Descrizione</th>
                    <th>Numero Pezzi</th>
                    <th>Aggiungi al carrello</th>
                </tr>
                   
                    <c:forEach  items="${Oggetti}" var="oggetto" >
                        <tr> 
                            <td><img title='${oggetto.nomeOggetto}' alt="Foto dell'oggetto ${oggetto.nomeOggetto}" src='${oggetto.indirizzoImg}'/></td> 
                            <td> ${oggetto.nomeOggetto} </td> 
                            <td> ${oggetto.prezzoUnita}</td>
                            <td> ${oggetto.descrizione}</td>
                            <td> ${oggetto.quantita}</td>
                            <td><a  href="cliente.html?idOggetto=${oggetto.ID}">
                                    <img src="Images/aggiungi.png" width="40" height="40"  alt="Aggiungi"/></a>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
                </div> 
                        
                <c:if test="${size == 0}">
                    <p class="errore">Non ci sono oggetti in vendita ! Siamo dispiaciuti.</p>
                </c:if>
                    <jsp:include page="footer.jsp" />
    </body>
</html>
