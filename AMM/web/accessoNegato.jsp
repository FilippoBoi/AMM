<%-- 
    Document   : accessoNegato
    Created on : 21-gen-2017, 18.20.37
    Author     : Filippo Boi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="author" content="Filippo Boi">
        <meta name="description" content="pagina del cliente">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css">
        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
        <script type="text/javascript" src="js/Filter.js"></script>
    </head>
      <title>Il mio Account</title>
    </head>
    <body>
            <header>

           <c:if test="${sessionScope.utente != null}">
            <div id="logout"><a href="logout.html">Logout</a></div>
        
        </c:if>
        <nav><hr>
            <ul>
                <li> <a href="Descrizione.jsp"> info </a></li>
                <li> <a href="Cliente.jsp">Il mio profilo</a></li>
                <li> <a href="Venditore.jsp">Il mio negozio</a></li>
            </ul>
        </nav><hr>
        
            </header>
            
        

            <div >
                
                <h1>Accesso negato</h1>
                <p id="divieto">Non hai i permessi necessari per accedere a questa pagina</p>        
            </div>
        
    <div id='footer'>
    
    <jsp:include page="footer.jsp" />
    </div>
    </body>
</html>
