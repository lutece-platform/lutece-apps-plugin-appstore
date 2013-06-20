<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />
<jsp:useBean id="appstoreIcon" scope="session" class="fr.paris.lutece.plugins.appstore.web.IconJspBean" />
<% appstoreIcon.init( request, fr.paris.lutece.plugins.appstore.web.AppStoreJspBean.RIGHT_MANAGEAPPSTORE); %>
<%= appstoreIcon.getModifyIcon( request ) %>
<%@ include file="../../AdminFooter.jsp" %>