

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="appstoreCategory" scope="session" class="fr.paris.lutece.plugins.appstore.web.CategoryJspBean" />

<% appstoreCategory.init( request, appstoreCategory.RIGHT_MANAGEAPPSTORE ); %>
<%= appstoreCategory.getManageCategories ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>


