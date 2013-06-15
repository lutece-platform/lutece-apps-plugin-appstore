

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="appstoreApplication" scope="session" class="fr.paris.lutece.plugins.appstore.web.ApplicationJspBean" />

<%
    appstoreApplication.init( request, appstoreApplication.RIGHT_MANAGEAPPSTORE );
    response.sendRedirect( appstoreApplication.doModifyApplication( request ) );
%>

