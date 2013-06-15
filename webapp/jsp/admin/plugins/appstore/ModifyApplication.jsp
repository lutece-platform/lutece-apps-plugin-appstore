

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="appstoreApplication" scope="session" class="fr.paris.lutece.plugins.appstore.web.ApplicationJspBean" />

<% appstoreApplication.init( request, appstoreApplication.RIGHT_MANAGEAPPSTORE ); %>
<%= appstoreApplication.getModifyApplication ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>

