/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.appstore.web;

import fr.paris.lutece.plugins.appstore.business.Application;
import fr.paris.lutece.plugins.appstore.business.ApplicationHome;
import fr.paris.lutece.plugins.appstore.business.CategoryHome;
import fr.paris.lutece.plugins.appstore.business.ComponentHome;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.web.constants.Messages;
import fr.paris.lutece.portal.web.util.LocalizedPaginator;
import fr.paris.lutece.util.html.HtmlTemplate;
import fr.paris.lutece.util.html.Paginator;
import fr.paris.lutece.util.url.UrlItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * This class provides the user interface to manage  Category,
 Application,
 Component
 features ( manage, create, modify, remove )
 */
public class ApplicationJspBean extends AppStoreJspBean
{
    ////////////////////////////////////////////////////////////////////////////
    // Constants

    // Parameters
    private static final String PARAMETER_ID_APPLICATION = "application_id_application";
    private static final String PARAMETER_APPLICATION_TITLE = "application_title";
    private static final String PARAMETER_APPLICATION_DESCRIPTION = "application_description";
    private static final String PARAMETER_APPLICATION_ID_CATEGORY = "application_id_category";
    private static final String PARAMETER_APPLICATION_APPLICATION_ORDER = "application_application_order";
    private static final String PARAMETER_APPLICATION_ID_ICON = "application_id_icon";
    private static final String PARAMETER_APPLICATION_POM_URL = "application_pom_url";
    private static final String PARAMETER_APPLICATION_WEBAPP_URL = "application_webapp_url";
    private static final String PARAMETER_APPLICATION_SQL_SCRIPT_URL = "application_sql_script_url";
    private static final String PARAMETER_APPLICATION_PRESENTATION = "application_presentation";
    private static final String PARAMETER_APPLICATION_INSTALLATION = "application_installation";
    private static final String PARAMETER_APPLICATION_ARTIFACT_ID = "application_artifact_id";
    private static final String PARAMETER_APPLICATION_VERSION = "application_version";
    private static final String PARAMETER_APPLICATION_PUBLISH_STATUS = "application_publish_status";
    private static final String PARAMETER_ID_COMPONENT = "id_component";

    // templates
    private static final String TEMPLATE_MANAGE_APPLICATIONS = "/admin/plugins/appstore/manage_application.html";
    private static final String TEMPLATE_CREATE_APPLICATION = "/admin/plugins/appstore/create_application.html";
    private static final String TEMPLATE_MODIFY_APPLICATION = "/admin/plugins/appstore/modify_application.html";

    // Properties for page titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE_APPLICATIONS = "appstore.manage_applications.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_APPLICATION = "appstore.modify_application.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_APPLICATION = "appstore.create_application.pageTitle";

    // Markers
    private static final String MARK_APPLICATION_LIST = "application_list";
    private static final String MARK_APPLICATION = "application";
    private static final String MARK_CATEGORIES_LIST = "categories_list";
    private static final String MARK_COMPONENTS_LIST = "components_list";
    private static final String MARK_APP_COMPONENTS_LIST = "app_components_list";

    // Jsp Definition
    private static final String JSP_DO_REMOVE_APPLICATION = "jsp/admin/plugins/appstore/DoRemoveApplication.jsp";
    private static final String JSP_MANAGE_APPLICATIONS = "jsp/admin/plugins/appstore/ManageApplications.jsp";
    private static final String JSP_REDIRECT_TO_MANAGE_APPLICATIONS = "ManageApplications.jsp";

    // Properties
    private static final String PROPERTY_DEFAULT_LIST_APPLICATION_PER_PAGE = "appstore.listApplications.itemsPerPage";

    // Messages
    private static final String MESSAGE_CONFIRM_REMOVE_APPLICATION = "appstore.message.confirmRemoveApplication";

    /**
     * Returns the list of application
     *
     * @param request The Http request
     * @return the applications list
     */
    public String getManageApplications( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE_APPLICATIONS );

        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX, _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_APPLICATION_PER_PAGE, 50 );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage,
                _nDefaultItemsPerPage );

        UrlItem url = new UrlItem( JSP_MANAGE_APPLICATIONS );
        String strUrl = url.getUrl(  );
        List<Application> listApplications = (List<Application>) ApplicationHome.getApplicationsList(  );

        // PAGINATOR
        LocalizedPaginator paginator = new LocalizedPaginator( listApplications, _nItemsPerPage, strUrl,
                PARAMETER_PAGE_INDEX, _strCurrentPageIndex, getLocale(  ) );

        Map<String, Object> model = new HashMap<String, Object>(  );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );

        model.put( MARK_APPLICATION_LIST, paginator.getPageItems(  ) );

        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_APPLICATIONS, getLocale(  ), model );

        return getAdminPage( templateList.getHtml(  ) );
    }

    /**
     * Returns the form to create a application
     *
     * @param request The Http request
     * @return the html code of the application form
     */
    public String getCreateApplication( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_CREATE_APPLICATION );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_CATEGORIES_LIST, CategoryHome.getCategories(  ) );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_APPLICATION, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Process the data capture form of a new application
     *
     * @param request The Http Request
     * @return The Jsp URL of the process result
     */
    public String doCreateApplication( HttpServletRequest request )
    {
        Application application = new Application(  );

        if ( request.getParameter( PARAMETER_APPLICATION_TITLE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

 
        if ( request.getParameter( PARAMETER_APPLICATION_DESCRIPTION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }


        if ( request.getParameter( PARAMETER_APPLICATION_ID_CATEGORY ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }


        if ( request.getParameter( PARAMETER_APPLICATION_APPLICATION_ORDER ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }


        if ( request.getParameter( PARAMETER_APPLICATION_ID_ICON ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }


        if ( request.getParameter( PARAMETER_APPLICATION_WEBAPP_URL ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }


        if ( request.getParameter( PARAMETER_APPLICATION_SQL_SCRIPT_URL ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setTitle( request.getParameter( PARAMETER_APPLICATION_TITLE ) );
        application.setDescription( request.getParameter( PARAMETER_APPLICATION_DESCRIPTION ) );
        int nIdCategory = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_CATEGORY ) );
        application.setIdCategory( nIdCategory );
        int nApplicationOrder = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_APPLICATION_ORDER ) );
        application.setOrder( nApplicationOrder );
        int nIdIcon = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_ICON ) );
        application.setIdIcon( nIdIcon );
        int nPublishStatus = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_PUBLISH_STATUS ));

        application.setPomUrl( request.getParameter( PARAMETER_APPLICATION_POM_URL ) );
        application.setWebappUrl( request.getParameter( PARAMETER_APPLICATION_WEBAPP_URL ) );
        application.setSqlScriptUrl( request.getParameter( PARAMETER_APPLICATION_SQL_SCRIPT_URL ) );
        application.setPresentation( request.getParameter(PARAMETER_APPLICATION_PRESENTATION ));
        application.setInstallation( request.getParameter(PARAMETER_APPLICATION_INSTALLATION ));
        application.setArtifactId( request.getParameter(PARAMETER_APPLICATION_ARTIFACT_ID ));
        application.setVersion( request.getParameter(PARAMETER_APPLICATION_VERSION ));
        application.setPublishStatus( nPublishStatus );

        ApplicationHome.create( application );

        return JSP_REDIRECT_TO_MANAGE_APPLICATIONS;
    }

    /**
     * Manages the removal form of a application whose identifier is in the http request
     *
     * @param request The Http request
     * @return the html code to confirm
     */
    public String getConfirmRemoveApplication( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_APPLICATION ) );
        UrlItem url = new UrlItem( JSP_DO_REMOVE_APPLICATION );
        url.addParameter( PARAMETER_ID_APPLICATION, nId );

        return AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_APPLICATION, url.getUrl(  ),
            AdminMessage.TYPE_CONFIRMATION );
    }

    /**
     * Handles the removal form of a application
     *
     * @param request The Http request
     * @return the jsp URL to display the form to manage applications
     */
    public String doRemoveApplication( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_APPLICATION ) );
        ApplicationHome.remove( nId );

        return JSP_REDIRECT_TO_MANAGE_APPLICATIONS;
    }

    /**
     * Returns the form to update info about a application
     *
     * @param request The Http request
     * @return The HTML form to update info
     */
    public String getModifyApplication( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MODIFY_APPLICATION );

        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_APPLICATION ) );
        Application application = ApplicationHome.findByPrimaryKey( nId );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_CATEGORIES_LIST, CategoryHome.getCategories(  ) );
        model.put( MARK_APPLICATION, application );
        model.put( MARK_COMPONENTS_LIST, ComponentHome.getComponentsList() );
        model.put( MARK_APP_COMPONENTS_LIST, ComponentHome.findByApplication(nId) );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_MODIFY_APPLICATION, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Process the change form of a application
     *
     * @param request The Http request
     * @return The Jsp URL of the process result
     */
    public String doModifyApplication( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_APPLICATION ) );
        Application application = ApplicationHome.findByPrimaryKey( nId );

        if ( request.getParameter( PARAMETER_ID_APPLICATION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        int nIdApplication = Integer.parseInt( request.getParameter( PARAMETER_ID_APPLICATION ) );
        application.setId( nIdApplication );

        if ( request.getParameter( PARAMETER_APPLICATION_TITLE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setTitle( request.getParameter( PARAMETER_APPLICATION_TITLE ) );

        if ( request.getParameter( PARAMETER_APPLICATION_DESCRIPTION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setDescription( request.getParameter( PARAMETER_APPLICATION_DESCRIPTION ) );

        if ( request.getParameter( PARAMETER_APPLICATION_ID_CATEGORY ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        int nIdCategory = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_CATEGORY ) );
        application.setIdCategory( nIdCategory );

        if ( request.getParameter( PARAMETER_APPLICATION_APPLICATION_ORDER ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        int nApplicationOrder = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_APPLICATION_ORDER ) );
        application.setOrder( nApplicationOrder );

        if ( request.getParameter( PARAMETER_APPLICATION_ID_ICON ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        int nIdIcon = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_ICON ) );
        application.setIdIcon( nIdIcon );

        if ( request.getParameter( PARAMETER_APPLICATION_POM_URL ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setPomUrl( request.getParameter( PARAMETER_APPLICATION_POM_URL ) );

        if ( request.getParameter( PARAMETER_APPLICATION_WEBAPP_URL ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setWebappUrl( request.getParameter( PARAMETER_APPLICATION_WEBAPP_URL ) );

        if ( request.getParameter( PARAMETER_APPLICATION_SQL_SCRIPT_URL ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        application.setSqlScriptUrl( request.getParameter( PARAMETER_APPLICATION_SQL_SCRIPT_URL ) );
        application.setPresentation( request.getParameter(PARAMETER_APPLICATION_PRESENTATION ));
        application.setInstallation( request.getParameter(PARAMETER_APPLICATION_INSTALLATION ));
        application.setArtifactId( request.getParameter(PARAMETER_APPLICATION_ARTIFACT_ID ));
        application.setVersion( request.getParameter(PARAMETER_APPLICATION_VERSION ));
        int nPublishStatus = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_PUBLISH_STATUS ));
        application.setPublishStatus( nPublishStatus );
        ApplicationHome.update( application );

        return JSP_REDIRECT_TO_MANAGE_APPLICATIONS;
    }
    
    public String doModifyComponentsList( HttpServletRequest request )
    {
        String[] ids = request.getParameterValues(PARAMETER_ID_COMPONENT);
        String strApplicationId = request.getParameter(PARAMETER_ID_APPLICATION);
        int nApplicationId = Integer.parseInt( strApplicationId );
        
        ApplicationHome.clearComponentsList( nApplicationId );
        
        for( int i = 0 ; i < ids.length ; i++ )
        {
            int nIdComponent = Integer.parseInt( ids[i] );
            ApplicationHome.addComponent( nApplicationId , nIdComponent );
        }
        
        return JSP_REDIRECT_TO_MANAGE_APPLICATIONS;
    }
}
