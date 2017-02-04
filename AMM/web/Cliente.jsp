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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Filippo Boi">
        <meta name="description" content="pagina del cliente, carrello">
        <meta name="keywords" content="Cliente, Articoli, Carrello">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css">
        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
        <script type="text/javascript" src="js/Filter.js"></script>

    </head>
    <body >

        <nav><hr>
            <ul>
                <c:if test="${sessionScope.utente != null}">

                    <li><a href="logout.html">Logout</a></li>
                    </c:if>
                    <c:if test="${sessionScope.utente==null}">
                    <li>  <a href="Login.jsp">Login</a></li>
                    </c:if>    

                <li> <a href="Descrizione.jsp">Descrizione</a> </li>
                <li>  <a href="Cliente.html">Cliente</a></li>
                <li> <a href="riepilogo.jsp">Carrello</a></li>
            </ul>
        </nav><hr>

        <div style="height:auto">
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
            <input type="text" name="filtra" value="" />

            <table style='width:100%' >
                <tr> 
                    <th>Immagine</th>
                    <th>Nome Articolo</th>
                    <th>Prezzo</th>
                    <th>Descrizione</th>
                    <th>Numero Pezzi</th>
                    <th>Aggiungi al <br>carrello</th>
                </tr>

                <c:forEach var="oggetto" items="${listaOggetti}">
                    <tr> 
                        <td><img title='${oggetto.nomeOggetto}' alt="Foto dell'oggetto ${oggetto.nomeOggetto}" src='${oggetto.indirizzoImg}' width='100' height='100'/></td> 
                        <td> ${oggetto.nomeOggetto} </td> 
                        <td> ${oggetto.prezzoUnita}€</td>
                        <td> ${oggetto.descrizione}</td>
                        <td> ${oggetto.quantita}</td>
                        <td><a  href="Cliente.html?id=${oggetto.id}">
                                <img src="Images/aggiungi.png" width="20" height="20"  alt="Aggiungi"/></a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div> 


        <div id='footer'>

            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
