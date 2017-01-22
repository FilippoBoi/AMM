<%-- 
    Document   : Login
    Created on : 22-gen-2017, 12.33.50
    Author     : Macinino
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Nerd-Help - Login</title>
        <meta charset="UTF-8">
        <meta name="description" content="Login al sito">
        <meta name="author" content="Filippo Boi">
        <meta name="keywords" content="Nerd-Help, Login">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--inserisco il foglio di stile CSS -->
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
  <body>
      
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
        
        <div>
            Inserisci le tue credenziali:<hr>
        <form action="segnaposto.asp" method="post">
            <label for="username">username:</label>
        <input type="text" name="username"
               id="username" placeholder="nome utente" required/>
        <br/>
        <label for="pswd">password:</label>
        <input type="password" name="password"
               id="pswd" placeholder="inserisci password" required/>
        <input type="submit" value="Log in"/>
        </form>
            </div>
      
                      
                <div id="o">

                    <c:if test="${errore == true}">
                       <p class="errore"> Login erratto, riprova!</p>
                    </c:if>
                </div>
                    <jsp:include page="footer.jsp" />
    </body>
</html>
