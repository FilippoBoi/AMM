<%-- 
    Document   : cliente
    Created on : 18-mag-2016, 13.47.05
    Author     : Macinino
--%>
<%
   //condizioni di reindirizzamento se non loggato
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Nerd-Help - Cliente</title>
        <meta charset="UTF-8">
        <meta name="description" content="pagina del cliente, carrello provvisorio">
        <meta name="author" content="Filippo Boi">
        <meta name="keywords" content="Carrello, articoli">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--inserisco il foglio di stile CSS -->
        <link rel="stylesheet" href="style.css" type="text/css">
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
        
     <div>
        <h1><%= request.getAttribute("message") %></h1>
    </div>      
    
        <table>
            <tr> 
            <th id="immagine">Immagine</th>
            <th>Nome Articolo</th>
            <th>Numero Pezzi</th>
            <th id="descrizione">Descrizione</th>
            <th>Prezzo</th>
            <th>Aggiungi al carrello</th>
            </tr>
            <tr>
            <td id="immagine">
                <img title="icona articolo cofanetto HP" alt="Foto di cofanetto Harry Potter" 
                     src="http://www.macrolibrarsi.it/data/cop/zoom/h/harry-potter-la-serie-completa-cofanetto-libro-87951-2.jpg" width="100" height="100">
            </td>
            <td id="nomearticolo">Cofanetto Harry Potter</td>
            <td id="qta">100</td>           
            <td id="descrizione">Il cofanetto contiene tutti i libri di Harry Potter, il Best seller che ha incantato generazioni di ragazzi di tutte le età.</td>
            <td id="price">90€</td>
            <td id="acquisto-car"><a href="cliente.html"> Acquista</a></td>
            </tr>
            <tr id="pari">
            <td id="immagine"><img title="serie completa BrBa" alt="Foto di Breaking bad serie completa" 
                     src="http://ecx.images-amazon.com/images/I/61lJSyoL9-L._SY679_.jpg" width="100" height="100">
            </td>
            <td id="nomearticolo">Breaking Bad Serie completa </td>
            <td id="qta">20</td>   
            <td id="descrizione">L’incredibile serie tv che racconta la storia di Walter White, insegnante liceale di chimica diventato un super narcotrafficante.
            <td id="price">75,99€</td>
            <td id="acquisto-car"><a href="cliente.html">Acquista</a></td>
            </tr>
            <tr>
                <td id="immagine">
                    <img title="monitor LG 31'' 4K" alt="Foto di Monitor alta definizione 31 pollici" 
                        src="http://i.nextmedia.com.au/Utils/ImageResizer.ashx?n=http%3A%2F%2Fi.nextmedia.com.au%2FNews%2FLG+31.jpg&h=338&w=450&c=1"
                        width="100" height="100">
                </td>
            <td id="nomearticolo">Monitor LG 4k 31"</td>
            <td id="qta">10</td>
            <td id="descrizione">Monitor professionale 31" 4K
            potrete vedere ogni dettaglio in questo schermo 31" 4K LG con risoluzione 3840 x 2160, in grado di mostrare 157 pixel per pollice e colore a 10-bit</td>
            <td id="price">1999,99€</td>
            <td id="acquisto-car"><a href="cliente.html">Acquista</a></td>
            </tr>
            <tr id="pari">
            <td id="immagine"><img title="tazza tardis" alt="Immagine della tazza a forma di TARDIS, Doctor Who"
                     src="http://ecx.images-amazon.com/images/I/51iV3HxZR3L.jpg" width="100" height="100"></td>
            <td id="nomearticolo">Tazza Tardis, Doctor Who</td>
            <td id="qta">50</td>
            <td id="descrizione">Tazza a forma di T.A.R.D.I.S., regalo ideale per i fan del Dottore, L'ultimo dei signori del tempo</td>
            <td id="price">27,69€</td>
            <td id="acquisto-car"><a href="cliente.html">Acquista</a></td>
            </tr>
            <tr>
                <td id="immagine"><img title="far cry primal" alt="immagine copertina Far Cry Primal" 
                         src="http://image.jeuxvideo.com/medias/145700/1456998513-6266-jaquette-avant.jpg" width="100" height="100"></td>
            <td id="nomearticolo">Far Cry Primal, PC</td>
            <td id="qta">9</td>
            <td id="descrizione">Benvenuto nell'età della pietra, un'epoca estremamente pericolosa.
              Mammut e smilodonti dominavano il mondo e l'uomo era in fondo alla catena alimentare. 
              Nei panni dell'ultimo superstite del tuo gruppo di caccia, imparerai a costruire un arsenale letale, a respingere i feroci predatori e a battere in astuzia le tribù avversarie per conquistare la terra di Oros e diventare il predatore.</td>
            <td id="price">59,99€</td>
            <td id="acquisto-car"><a href="cliente.html">Acquista</a></td>
            </tr>
        </table>
        <footer></footer>
    </body>
</html>
