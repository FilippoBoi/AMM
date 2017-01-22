/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $("#filtra").keyup(function()
    {  
          var q = $("#filtra").val();
       
           $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              q: q
            },
            dataType: 'json',
            success : function(data, state){
                popolaTabells(data);
            },
            error : function(data, state){
            }
        });
        
          function popolaTabells(Oggetti)
        {
            /* Cancella le righe della tabella (ma non l'intestazione) e un eventuale messaggio scritto precedentemente */
            $("tr:not(.intestazione)").remove();
            $("#none").remove();
            
            /* Se ci sono oggetti che corrispondono alla ricerca allora creo una riga della tabella per ciascuno di essi */
            if(Oggetti.length != 0)
            {
                for(var oggetto in Oggetti)
                {
                    var tr = document.createElement("tr"); 
                    
                    var td = document.createElement("td");
                    var x = document.createElement("IMG");
                    x.setAttribute("src", Oggetti[oggetto].IndirizzoImg);
                    x.setAttribute("alt", "Foto di " + Oggetti[oggetto].nomeOggetto + 'width="100" height="100"');
                    td.appendChild(x);
                    tr.appendChild(td);
                    
                    var td = document.createElement("td");
                    var txt = document.createTextNode(Oggetti[oggetto].nomeOggetto);
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                    var td = document.createElement("td");
                    var txt = document.createTextNode(Oggetti[oggetto].prezzoUnita);
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                    var td = document.createElement("td");
                    var txt = document.createTextNode(Oggetti[oggetto].descrizione);
                    td.appendChild(txt);
                    tr.appendchild(td);
                    
                    
                    var td = document.createElement("td");
                    var txt = document.createTextNode(Oggetti[oggetto].quantita);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    
                    var td = document.createElement("td");
                    var a = document.createElement("A");
                    a.setAttribute("href", "cliente.html?idOggetto="+ Oggetti[oggetto].id);
                    var x = document.createElement("IMG");
                    x.setAttribute("src", "Images/aggiungi.png");
                    x.setAttribute("alt", "Aggiungi");
                    x.setAttribute("width", 40);
                    x.setAttribute("height", 40);
                    a.appendChild(x);
                    td.appendChild(a);
                    tr.appendChild(td);
                 
                      document.getElementById("tabella").appendChild(tr);
                } 
            }else{
                    /* Nel caso in cui la lista è vuota mosto un messaggio all'utente */
                    var div = document.getElementById("noelements")
                    var p = document.createElement("p");
                    var txt = document.createTextNode("Non ci sono oggetti che corrispondono alla tua ricerca");
                    p.appendChild(txt);
                    p.setAttribute("id", "none");
                    div.appendChild(p);
            } 
            
        }
    }); 
});