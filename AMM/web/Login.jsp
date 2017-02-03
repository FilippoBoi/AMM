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
                <li> <a href="Descrizione.jsp"> info </a></li>
                <li> <a href="Cliente.jsp">Il mio profilo</a></li>
                <li> <a href="Venditore.jsp">Il mio negozio</a></li>
            </ul>
        </nav>
        
        <div>
            Inserisci le tue credenziali:<hr>
        <form action="Login.html" method="post">
            <label for="username">username:</label>
        <input type="text" name="username"
               id="username" placeholder="nome utente" required/>
        <br/>
        <label for="pswd">password:</label>
        <input type="password" 
               name="pswd" placeholder="inserisci password" required/>
        <input type="submit" value="Log in" name="submit"/>
        </form>
            </div>
      
                      
            

                    <c:if test="${errore == true}">
                       <p class="errore"> Login errato, riprova!</p>
                    </c:if>
                
                    <jsp:include page="footer.jsp" />
    </body>
</html>
