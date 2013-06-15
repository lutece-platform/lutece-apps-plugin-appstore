

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="appstoreComponent" scope="session" class="fr.paris.lutece.plugins.appstore.web.ComponentJspBean" />

<% appstoreComponent.init( request, appstoreComponent.RIGHT_MANAGEAPPSTORE ); %>
<%= appstoreComponent.getCreateComponent ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>

