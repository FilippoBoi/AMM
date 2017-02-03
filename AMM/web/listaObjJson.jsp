<%-- 
    Document   : OGgetti
    Created on : 20-gen-2016, 17.27.23
    Author     : Filippo Boi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="oggetti" items="${listaOggetti}">
        <json:object>
            <json:property name="nomeOggetto" value="${oggetto.nomeOggetto}"/>
            <json:property name="IndirizzoImg" value="${oggetto.IndirizzoImg}"/>
            <json:property name="descrizione" value="${oggetto.descrizione}"/>
            <json:property name="prezzoUnita" value="${oggetto.prezzoUnita}"/>
            <json:property name="quantita" value="${oggetto.quantita}"/>
            <json:property name="id" value="${oggetto.ID}"/>
        </json:object>
    </c:forEach>
</json:array>