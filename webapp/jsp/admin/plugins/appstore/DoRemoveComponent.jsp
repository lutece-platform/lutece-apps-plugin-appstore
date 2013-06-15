

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="appstoreComponent" scope="session" class="fr.paris.lutece.plugins.appstore.web.ComponentJspBean" />

<%
    appstoreComponent.init( request, appstoreComponent.RIGHT_MANAGEAPPSTORE );
    response.sendRedirect( appstoreComponent.doRemoveComponent( request ) );
%>


