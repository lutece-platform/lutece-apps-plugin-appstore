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

import fr.paris.lutece.plugins.appstore.business.Component;
import fr.paris.lutece.plugins.appstore.business.ComponentHome;
import fr.paris.lutece.plugins.appstore.service.ComponentInfoService;
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
 * Component JSP Bean
 */
public class ComponentJspBean extends AppStoreJspBean
{
    private static final String TEMPLATE_MANAGE_COMPONENTS = "/admin/plugins/appstore/manage_component.html";
    private static final String TEMPLATE_CREATE_COMPONENT = "/admin/plugins/appstore/create_component.html";
    private static final String TEMPLATE_MODIFY_COMPONENT = "/admin/plugins/appstore/modify_component.html";
    private static final String PARAMETER_COMPONENT_ID_COMPONENT = "component_id_component";
    private static final String PARAMETER_COMPONENT_GROUP_ID = "component_group_id";
    private static final String PARAMETER_COMPONENT_TITLE = "component_title";
    private static final String PARAMETER_COMPONENT_DESCRIPTION = "component_description";
    private static final String PARAMETER_COMPONENT_ARTIFACT_ID = "component_artifact_id";
    private static final String PARAMETER_COMPONENT_VERSION = "component_version";
    private static final String PARAMETER_COMPONENT_COMPONENT_TYPE = "component_component_type";
    private static final String PROPERTY_PAGE_TITLE_MANAGE_COMPONENTS = "appstore.manage_components.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_COMPONENT = "appstore.modify_component.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_COMPONENT = "appstore.create_component.pageTitle";
    private static final String MARK_COMPONENT_LIST = "component_list";
    private static final String MARK_COMPONENT = "component";
    private static final String JSP_DO_REMOVE_COMPONENT = "jsp/admin/plugins/appstore/DoRemoveComponent.jsp";
    private static final String JSP_MANAGE_COMPONENTS = "jsp/admin/plugins/appstore/ManageComponents.jsp";
    private static final String JSP_REDIRECT_TO_MANAGE_COMPONENTS = "ManageComponents.jsp";
    private static final String PROPERTY_DEFAULT_LIST_COMPONENT_PER_PAGE = "appstore.listComponents.itemsPerPage";
    private static final String MESSAGE_CONFIRM_REMOVE_COMPONENT = "appstore.message.confirmRemoveComponent";

    /**
     * Returns the list of component
     *
     * @param request The Http request
     * @return the components list
     */
    public String getManageComponents( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE_COMPONENTS );

        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX, _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_COMPONENT_PER_PAGE, 50 );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage,
                _nDefaultItemsPerPage );

        UrlItem url = new UrlItem( JSP_MANAGE_COMPONENTS );
        String strUrl = url.getUrl(  );
        List<Component> listComponents = (List<Component>) ComponentHome.getComponentsList(  );

        // PAGINATOR
        LocalizedPaginator paginator = new LocalizedPaginator( listComponents, _nItemsPerPage, strUrl,
                PARAMETER_PAGE_INDEX, _strCurrentPageIndex, getLocale(  ) );

        Map<String, Object> model = new HashMap<String, Object>(  );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );

        model.put( MARK_COMPONENT_LIST, paginator.getPageItems(  ) );

        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_COMPONENTS, getLocale(  ), model );

        return getAdminPage( templateList.getHtml(  ) );
    }

    /**
     * Returns the form to create a component
     *
     * @param request The Http request
     * @return the html code of the component form
     */
    public String getCreateComponent( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_CREATE_COMPONENT );

        Map<String, Object> model = new HashMap<String, Object>(  );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_COMPONENT, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Process the data capture form of a new component
     *
     * @param request The Http Request
     * @return The Jsp URL of the process result
     */
    public String doCreateComponent( HttpServletRequest request )
    {
        Component component = new Component(  );

        if ( request.getParameter( PARAMETER_COMPONENT_TITLE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        if ( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        if ( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        component.setTitle( request.getParameter( PARAMETER_COMPONENT_TITLE ) );
        component.setDescription( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ) );
        component.setArtifactId( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ) );
        component.setGroupId( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ) );
        component.setComponentType( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ) );
        ComponentInfoService.setReleaseVersion( component );

        ComponentHome.create( component );

        return JSP_REDIRECT_TO_MANAGE_COMPONENTS;
    }

    /**
     * Manages the removal form of a component whose identifier is in the http
     * request
     *
     * @param request The Http request
     * @return the html code to confirm
     */
    public String getConfirmRemoveComponent( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
        UrlItem url = new UrlItem( JSP_DO_REMOVE_COMPONENT );
        url.addParameter( PARAMETER_COMPONENT_ID_COMPONENT, nId );

        return AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_COMPONENT, url.getUrl(  ),
            AdminMessage.TYPE_CONFIRMATION );
    }

    /**
     * Handles the removal form of a component
     *
     * @param request The Http request
     * @return the jsp URL to display the form to manage components
     */
    public String doRemoveComponent( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
        ComponentHome.remove( nId );

        return JSP_REDIRECT_TO_MANAGE_COMPONENTS;
    }

    /**
     * Returns the form to update info about a component
     *
     * @param request The Http request
     * @return The HTML form to update info
     */
    public String getModifyComponent( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MODIFY_COMPONENT );

        int nId = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
        Component component = ComponentHome.findByPrimaryKey( nId );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_COMPONENT, component );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_MODIFY_COMPONENT, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Process the change form of a component
     *
     * @param request The Http request
     * @return The Jsp URL of the process result
     */
    public String doModifyComponent( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
        Component component = ComponentHome.findByPrimaryKey( nId );

        if ( request.getParameter( PARAMETER_COMPONENT_TITLE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        if ( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        if ( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        component.setTitle( request.getParameter( PARAMETER_COMPONENT_TITLE ) );
        component.setDescription( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ) );
        component.setArtifactId( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ) );
        component.setGroupId( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ) );
        component.setComponentType( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ) );
        ComponentInfoService.setReleaseVersion( component );
        ComponentHome.update( component );

        return JSP_REDIRECT_TO_MANAGE_COMPONENTS;
    }
}
