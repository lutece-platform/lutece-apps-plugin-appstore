

<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="manageappstore" scope="session" class="fr.paris.lutece.plugins.appstore.web.ManageAppStoreJspBean" />

<% manageappstore.init( request, manageappstore.RIGHT_MANAGEAPPSTORE ); %>
<%= manageappstore.getManageComponents ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>


