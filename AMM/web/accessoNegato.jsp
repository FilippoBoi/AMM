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
        <script type="text/javascript" src="js/filter.js"></script>
    </head>
      <title>Il mio Account</title>
    </head>
    <body>
            <header>

           <c:if test="${sessionScope.utente != null}">
            <div id="logout"><a href="logout.html">Logout</a></div>
        
        </c:if>
        <nav>
            <ul>
                <li> <a href="descrizione.html"> info </a></li>
                <li> <a href="cliente.html">Il mio profilo</a></li>
                <li> <a href="venditore.html">Il mio negozio</a></li>
            </ul>
        </nav>
        
            </header>
            
            <div id="sidebar1">
                
            </div>

            <div id="central">
                
                <h1>Accesso negato</h1>
                <p id="divieto">Non hai i permessi necessari per accedere a questa pagina</p>

                    <jsp:include page="footer.jsp" />
            </div>
    </body>
</html>
