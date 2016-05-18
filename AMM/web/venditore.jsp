<%-- 
    Document   : venditore
    Created on : 18-mag-2016, 13.47.46
    Author     : Macinino
--%>
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
        <!--inserisco il foglio di stile CSS -->
        <link rel="stylesheet" href="style.css" type="text/css" >
       </head>
    <body>
    <header>
      <nav id="navigator">
            <ul>
                <li> <a href="descrizione.html"> info </a></li>
                <li> <a href="login.html">Login</a></li>
            </ul>
        </nav>
    </header>   
        <form action="venditore.html" method="post">
            <label for="NomeArticolo">Nome articolo:</label><br/>
            <input type="text" name="NomeArticolo" 
                   id="NomeArticolo" placeholder="Nome Articolo" required/>
            <br/>
            <label for="linkImg">Immagine:</label><br/>
            <input type="url" name="linkImg" id="linkImg" placeholder="http://" required/>
            <br/>
            <br/>
           <label for="descrizione">Descrizione Oggetto:</label><br/>
           <textarea rows="4" cols="30" name="descrizione" id="descrizioneitm"></textarea>
           <br/>
           <label for="prezzo">prezzo dell'articolo:</label><br/>
           <input type="number" name="prezzo" id="prezzo" placeholder="00,00€" min="0.00" required/>
           <br/>
           <label for="numeroArt"> numero articoli:</label><br/>
           <input type="number" name="numeroArt" id="numeroArt" placeholder="1" min="1.00" required/>
           <input type="submit" id="submit" value="Carica Prodotto"/>
        </form>
        <footer></footer>
    </body>
</html>