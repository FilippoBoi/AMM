<%-- 
    Document   : login
    Created on : 14-mag-2016, 17.41.08
    Author     : Macinino
--%>

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
        <link rel="stylesheet" href="M2/style.css" type="text/css">
    </head>
    <body>
        <header>
        <nav id="navigator">
            <ul>
                <li> <a href="descrizione.html"> info </a></li>
                <li> <a href="cliente.html">Il mio profilo</a></li>
                <li> <a href="venditore.html">Il mio negozio</a></li>
            </ul>
        </nav>
        </header>
        
        <div>
        <%= request.getAttribute("message") %>
        </div>
        
        <form action="login.html" method="post">
            <label for="username">username:</label><br/>
        <input type="text" name="username"
               id="username" placeholder="nome utente" required/>
        <br/>
        <label for="pswd">password:</label><br/>
        <input type="password" name="password"
               id="pswd" placeholder="inserisci password" required/><br/>
        <input type="submit" id="submit" value="Log in"/>
        </form> <br/>
        <footer></footer>
    </body>
</html>
