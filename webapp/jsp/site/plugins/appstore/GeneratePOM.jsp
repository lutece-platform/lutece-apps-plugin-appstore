<%@page errorPage="../../ErrorPagePortal.jsp" %>
<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/xml" %>

<jsp:useBean id="appstoreApp" scope="request" class="fr.paris.lutece.plugins.appstore.web.AppStoreApp" />


<%= appstoreApp.generatePOM( request )%>