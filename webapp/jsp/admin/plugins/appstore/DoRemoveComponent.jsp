

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="manageappstore" scope="session" class="fr.paris.lutece.plugins.appstore.web.ManageAppStoreJspBean" />

<%
    manageappstore.init( request, manageappstore.RIGHT_MANAGEAPPSTORE );
    response.sendRedirect( manageappstore.doRemoveComponent( request ) );
%>


