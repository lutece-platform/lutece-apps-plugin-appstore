<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:useBean id="appstoreIcon" scope="session" class="fr.paris.lutece.plugins.appstore.web.IconJspBean" />
<% 
	appstoreIcon.init( request, fr.paris.lutece.plugins.appstore.web.ManageAppStoreJspBean.RIGHT_MANAGEAPPSTORE); 
	response.sendRedirect(appstoreIcon.doCreateIcon(request) );
%>
