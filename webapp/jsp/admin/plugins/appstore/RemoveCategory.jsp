

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="appstoreCategory" scope="session" class="fr.paris.lutece.plugins.appstore.web.CategoryJspBean" />

<% appstoreCategory.init( request, appstoreCategory.RIGHT_MANAGEAPPSTORE ); 
response.sendRedirect( appstoreCategory.getConfirmRemoveCategory ( request ) ); %>


