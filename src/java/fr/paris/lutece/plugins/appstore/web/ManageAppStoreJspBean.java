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


import fr.paris.lutece.plugins.appstore.business.Category;
import fr.paris.lutece.plugins.appstore.business.CategoryHome;
import fr.paris.lutece.plugins.appstore.business.Application;
import fr.paris.lutece.plugins.appstore.business.ApplicationHome;
import fr.paris.lutece.plugins.appstore.business.Component;
import fr.paris.lutece.plugins.appstore.business.ComponentHome;

import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.web.constants.Messages;
import fr.paris.lutece.portal.web.util.LocalizedPaginator;
import fr.paris.lutece.util.html.Paginator;
import fr.paris.lutece.util.url.UrlItem;

import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;
import fr.paris.lutece.util.html.HtmlTemplate;

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
public class ManageAppStoreJspBean extends PluginAdminPageJspBean
{

    ////////////////////////////////////////////////////////////////////////////
    // Constants

    // Right
    public static final String RIGHT_MANAGEAPPSTORE = "APPSTORE_MANAGEMENT";
    
    // Parameters
    private static final String PARAMETER_CATEGORY_ID_CATEGORY="category_id_category";
    private static final String PARAMETER_CATEGORY_NAME="category_name";
    private static final String PARAMETER_CATEGORY_CATEGORY_ORDER="category_category_order";
    private static final String PARAMETER_APPLICATION_ID_APPLICATION="application_id_application";
    private static final String PARAMETER_APPLICATION_TITLE="application_title";
    private static final String PARAMETER_APPLICATION_DESCRIPTION="application_description";
    private static final String PARAMETER_APPLICATION_ID_CATEGORY="application_id_category";
    private static final String PARAMETER_APPLICATION_APPLICATION_ORDER="application_application_order";
    private static final String PARAMETER_APPLICATION_ID_ICON="application_id_icon";
    private static final String PARAMETER_APPLICATION_POM_URL="application_pom_url";
    private static final String PARAMETER_APPLICATION_WEBAPP_URL="application_webapp_url";
    private static final String PARAMETER_APPLICATION_SQL_SCRIPT_URL="application_sql_script_url";
    private static final String PARAMETER_COMPONENT_ID_COMPONENT="component_id_component";
    private static final String PARAMETER_COMPONENT_GROUP_ID="component_group_id";
    private static final String PARAMETER_COMPONENT_TITLE="component_title";
    private static final String PARAMETER_COMPONENT_DESCRIPTION="component_description";
    private static final String PARAMETER_COMPONENT_ARTIFACT_ID="component_artifact_id";
    private static final String PARAMETER_COMPONENT_VERSION="component_version";
    private static final String PARAMETER_COMPONENT_COMPONENT_TYPE="component_component_type";
    private static final String PARAMETER_PAGE_INDEX = "page_index";   

    // templates
    private static final String TEMPLATE_MANAGE_CATEGORYS="/admin/plugins/appstore/manage_category.html";
    private static final String TEMPLATE_CREATE_CATEGORY="/admin/plugins/appstore/create_category.html";
    private static final String TEMPLATE_MODIFY_CATEGORY="/admin/plugins/appstore/modify_category.html";
    private static final String TEMPLATE_MANAGE_APPLICATIONS="/admin/plugins/appstore/manage_application.html";
    private static final String TEMPLATE_CREATE_APPLICATION="/admin/plugins/appstore/create_application.html";
    private static final String TEMPLATE_MODIFY_APPLICATION="/admin/plugins/appstore/modify_application.html";
    private static final String TEMPLATE_MANAGE_COMPONENTS="/admin/plugins/appstore/manage_component.html";
    private static final String TEMPLATE_CREATE_COMPONENT="/admin/plugins/appstore/create_component.html";
    private static final String TEMPLATE_MODIFY_COMPONENT="/admin/plugins/appstore/modify_component.html";


// Properties for page titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE_CATEGORYS = "appstore.manage_categorys.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_CATEGORY = "appstore.modify_category.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_CATEGORY = "appstore.create_category.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MANAGE_APPLICATIONS = "appstore.manage_applications.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_APPLICATION = "appstore.modify_application.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_APPLICATION = "appstore.create_application.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MANAGE_COMPONENTS = "appstore.manage_components.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_COMPONENT = "appstore.modify_component.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_COMPONENT = "appstore.create_component.pageTitle";

    // Markers
    private static final String MARK_CATEGORY_LIST = "category_list";
    private static final String MARK_CATEGORY = "category";
    private static final String MARK_APPLICATION_LIST = "application_list";
    private static final String MARK_APPLICATION = "application";
    private static final String MARK_COMPONENT_LIST = "component_list";
    private static final String MARK_COMPONENT = "component";
    private static final String MARK_CATEGORIES_LIST = "categories_list";
    private static final String MARK_PAGINATOR = "paginator";
    private static final String MARK_NB_ITEMS_PER_PAGE = "nb_items_per_page";    
    
    // Jsp Definition
    private static final String JSP_DO_REMOVE_CATEGORY = "jsp/admin/plugins/appstore/DoRemoveCategory.jsp";
    private static final String JSP_MANAGE_CATEGORYS = "jsp/admin/plugins/appstore/ManageCategories.jsp";
    private static final String JSP_REDIRECT_TO_MANAGE_CATEGORYS = "ManageCategories.jsp";
    private static final String JSP_DO_REMOVE_APPLICATION = "jsp/admin/plugins/appstore/DoRemoveApplication.jsp";
    private static final String JSP_MANAGE_APPLICATIONS = "jsp/admin/plugins/appstore/ManageApplications.jsp";
    private static final String JSP_REDIRECT_TO_MANAGE_APPLICATIONS = "ManageApplications.jsp";
    private static final String JSP_DO_REMOVE_COMPONENT = "jsp/admin/plugins/appstore/DoRemoveComponent.jsp";
    private static final String JSP_MANAGE_COMPONENTS = "jsp/admin/plugins/appstore/ManageComponents.jsp";
    private static final String JSP_REDIRECT_TO_MANAGE_COMPONENTS = "ManageComponents.jsp";

    // Properties
    private static final String PROPERTY_DEFAULT_LIST_CATEGORY_PER_PAGE = "appstore.listCategorys.itemsPerPage";
    private static final String PROPERTY_DEFAULT_LIST_APPLICATION_PER_PAGE = "appstore.listApplications.itemsPerPage";
    private static final String PROPERTY_DEFAULT_LIST_COMPONENT_PER_PAGE = "appstore.listComponents.itemsPerPage";

    // Messages
    private static final String MESSAGE_CONFIRM_REMOVE_CATEGORY = "appstore.message.confirmRemoveCategory";
    private static final String MESSAGE_CONFIRM_REMOVE_APPLICATION = "appstore.message.confirmRemoveApplication";
    private static final String MESSAGE_CONFIRM_REMOVE_COMPONENT = "appstore.message.confirmRemoveComponent";
 
    //Variables
    private int _nDefaultItemsPerPage;
    private String _strCurrentPageIndex;
    private int _nItemsPerPage;    


    /**
     * Returns the list of category
     *
     * @param request The Http request
     * @return the categorys list
     */
    public String getManageCategories( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE_CATEGORYS );

        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX , _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_CATEGORY_PER_PAGE, 50 );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage,
                _nDefaultItemsPerPage );
        UrlItem url = new UrlItem(  JSP_MANAGE_CATEGORYS);
        String strUrl = url.getUrl(  );
        List<Category> listCategorys = (List<Category>) CategoryHome.getCategorysList( );

        // PAGINATOR
        LocalizedPaginator paginator = new LocalizedPaginator( listCategorys, _nItemsPerPage, strUrl , PARAMETER_PAGE_INDEX, _strCurrentPageIndex , getLocale() );

        Map<String, Object> model = new HashMap<String, Object>(  );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );

        model.put( MARK_CATEGORY_LIST, paginator.getPageItems(  ));
        
        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_CATEGORYS, getLocale(  ), model );

        return getAdminPage( templateList.getHtml(  ) );
    }

    /**
     * Returns the list of application
     *
     * @param request The Http request
     * @return the applications list
     */
    public String getManageApplications( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE_APPLICATIONS );

        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX , _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_APPLICATION_PER_PAGE, 50 );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage,
                _nDefaultItemsPerPage );
        UrlItem url = new UrlItem(  JSP_MANAGE_APPLICATIONS);
        String strUrl = url.getUrl(  );
        List<Application> listApplications = (List<Application>) ApplicationHome.getApplicationsList( );

        // PAGINATOR
        LocalizedPaginator paginator = new LocalizedPaginator( listApplications, _nItemsPerPage, strUrl , PARAMETER_PAGE_INDEX, _strCurrentPageIndex , getLocale() );

        Map<String, Object> model = new HashMap<String, Object>(  );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );

        model.put( MARK_APPLICATION_LIST, paginator.getPageItems(  ));
        
        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_APPLICATIONS, getLocale(  ), model );

        return getAdminPage( templateList.getHtml(  ) );
    }

    /**
     * Returns the list of component
     *
     * @param request The Http request
     * @return the components list
     */
    public String getManageComponents( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE_COMPONENTS );

        _strCurrentPageIndex = Paginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX , _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_COMPONENT_PER_PAGE, 50 );
        _nItemsPerPage = Paginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage,
                _nDefaultItemsPerPage );
        UrlItem url = new UrlItem(  JSP_MANAGE_COMPONENTS);
        String strUrl = url.getUrl(  );
        List<Component> listComponents = (List<Component>) ComponentHome.getComponentsList( );

        // PAGINATOR
        LocalizedPaginator paginator = new LocalizedPaginator( listComponents, _nItemsPerPage, strUrl , PARAMETER_PAGE_INDEX, _strCurrentPageIndex , getLocale() );

        Map<String, Object> model = new HashMap<String, Object>(  );

        model.put( MARK_NB_ITEMS_PER_PAGE, "" + _nItemsPerPage );
        model.put( MARK_PAGINATOR, paginator );

        model.put( MARK_COMPONENT_LIST, paginator.getPageItems(  ));
        
        HtmlTemplate templateList = AppTemplateService.getTemplate( TEMPLATE_MANAGE_COMPONENTS, getLocale(  ), model );

        return getAdminPage( templateList.getHtml(  ) );
    }

    /**
     * Returns the form to create a category
     *
     * @param request The Http request
     * @return the html code of the category form
     */
    public String getCreateCategory( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_CREATE_CATEGORY  );

        Map<String, Object> model = new HashMap<String, Object>(  );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_CATEGORY, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Returns the form to create a application
     *
     * @param request The Http request
     * @return the html code of the application form
     */
    public String getCreateApplication( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_CREATE_APPLICATION  );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_CATEGORIES_LIST, CategoryHome.getCategories() );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_APPLICATION, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Returns the form to create a component
     *
     * @param request The Http request
     * @return the html code of the component form
     */
    public String getCreateComponent( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_CREATE_COMPONENT  );

        Map<String, Object> model = new HashMap<String, Object>(  );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_COMPONENT, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

      //Business class size 3

    /**
     * Process the data capture form of a new category
     *
     * @param request The Http Request
     * @return The Jsp URL of the process result
     */
    public String doCreateCategory( HttpServletRequest request )
    {
        Category category = new Category(  );
             
                   	 
        
        if ( request.getParameter( PARAMETER_CATEGORY_NAME ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			category.setName( request.getParameter( PARAMETER_CATEGORY_NAME ) );
			
        
        if ( request.getParameter( PARAMETER_CATEGORY_CATEGORY_ORDER ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			      int nCategoryOrder = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_CATEGORY_ORDER ) );
      category.setCategoryOrder( nCategoryOrder );
			
      CategoryHome.create( category );
      return JSP_REDIRECT_TO_MANAGE_CATEGORYS;
    }
    
    /**
     * Manages the removal form of a category whose identifier is in the http request
     *
     * @param request The Http request
     * @return the html code to confirm
     */
    public String getConfirmRemoveCategory( HttpServletRequest request )
    {
        	int nId = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ) );
          UrlItem url = new UrlItem( JSP_DO_REMOVE_CATEGORY );
          url.addParameter( PARAMETER_CATEGORY_ID_CATEGORY, nId );
          return AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_CATEGORY, url.getUrl(  ),AdminMessage.TYPE_CONFIRMATION );
    }
    /**
     * Handles the removal form of a category
     *
     * @param request The Http request
     * @return the jsp URL to display the form to manage categorys
     */
    public String doRemoveCategory( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ) );
        CategoryHome.remove( nId );
        
        return JSP_REDIRECT_TO_MANAGE_CATEGORYS;
    }
    
    /**
     * Returns the form to update info about a category
     *
     * @param request The Http request
     * @return The HTML form to update info
     */
    public String getModifyCategory( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MODIFY_CATEGORY );
        int nId = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ) );
        Category category =CategoryHome.findByPrimaryKey( nId );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_CATEGORY, category );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_MODIFY_CATEGORY, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Process the change form of a category
     *
     * @param request The Http request
     * @return The Jsp URL of the process result
     */
    public String doModifyCategory( HttpServletRequest request )
    {
      int nId = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ) ); 
      Category category =CategoryHome.findByPrimaryKey( nId );
        if ( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
      int nIdCategory = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_ID_CATEGORY ) );
			category.setId( nIdCategory );
        if ( request.getParameter( PARAMETER_CATEGORY_NAME ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 category.setName( request.getParameter( PARAMETER_CATEGORY_NAME ) );
        if ( request.getParameter( PARAMETER_CATEGORY_CATEGORY_ORDER ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
      int nCategoryOrder = Integer.parseInt( request.getParameter( PARAMETER_CATEGORY_CATEGORY_ORDER ) );
			category.setCategoryOrder( nCategoryOrder );
        CategoryHome.update( category );
        return JSP_REDIRECT_TO_MANAGE_CATEGORYS;
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
        	int nId = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ) );
          UrlItem url = new UrlItem( JSP_DO_REMOVE_APPLICATION );
          url.addParameter( PARAMETER_APPLICATION_ID_APPLICATION, nId );
          return AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_APPLICATION, url.getUrl(  ),AdminMessage.TYPE_CONFIRMATION );
    }
    /**
     * Handles the removal form of a application
     *
     * @param request The Http request
     * @return the jsp URL to display the form to manage applications
     */
    public String doRemoveApplication( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ) );
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
        int nId = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ) );
        Application application =ApplicationHome.findByPrimaryKey( nId );

        Map<String, Object> model = new HashMap<String, Object>(  );
        model.put( MARK_CATEGORIES_LIST, CategoryHome.getCategories() );
        model.put( MARK_APPLICATION, application );

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
      int nId = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ) ); 
      Application application =ApplicationHome.findByPrimaryKey( nId );
        if ( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
      int nIdApplication = Integer.parseInt( request.getParameter( PARAMETER_APPLICATION_ID_APPLICATION ) );
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
        ApplicationHome.update( application );
        return JSP_REDIRECT_TO_MANAGE_APPLICATIONS;
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
             
                   	 
        
        if ( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setGroupId( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ) );
			
        
        if ( request.getParameter( PARAMETER_COMPONENT_TITLE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setTitle( request.getParameter( PARAMETER_COMPONENT_TITLE ) );
			
        
        if ( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setDescription( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ) );
			
        
        if ( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setArtifactId( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ) );
			
        
        if ( request.getParameter( PARAMETER_COMPONENT_VERSION ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setVersion( request.getParameter( PARAMETER_COMPONENT_VERSION ) );
			
        
        if ( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ).equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
			component.setComponentType( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ) );
			
      ComponentHome.create( component );
      return JSP_REDIRECT_TO_MANAGE_COMPONENTS;
    }
    
    /**
     * Manages the removal form of a component whose identifier is in the http request
     *
     * @param request The Http request
     * @return the html code to confirm
     */
    public String getConfirmRemoveComponent( HttpServletRequest request )
    {
        	int nId = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
          UrlItem url = new UrlItem( JSP_DO_REMOVE_COMPONENT );
          url.addParameter( PARAMETER_COMPONENT_ID_COMPONENT, nId );
          return AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_COMPONENT, url.getUrl(  ),AdminMessage.TYPE_CONFIRMATION );
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
        Component component =ComponentHome.findByPrimaryKey( nId );

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
      Component component =ComponentHome.findByPrimaryKey( nId );
        if ( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
      int nIdComponent = Integer.parseInt( request.getParameter( PARAMETER_COMPONENT_ID_COMPONENT ) );
			component.setId( nIdComponent );
        if ( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setGroupId( request.getParameter( PARAMETER_COMPONENT_GROUP_ID ) );
        if ( request.getParameter( PARAMETER_COMPONENT_TITLE ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setTitle( request.getParameter( PARAMETER_COMPONENT_TITLE ) );
        if ( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setDescription( request.getParameter( PARAMETER_COMPONENT_DESCRIPTION ) );
        if ( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setArtifactId( request.getParameter( PARAMETER_COMPONENT_ARTIFACT_ID ) );
        if ( request.getParameter( PARAMETER_COMPONENT_VERSION ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setVersion( request.getParameter( PARAMETER_COMPONENT_VERSION ) );
        if ( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ).equals( "" ) )
        {
          return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }
  			 component.setComponentType( request.getParameter( PARAMETER_COMPONENT_COMPONENT_TYPE ) );
        ComponentHome.update( component );
        return JSP_REDIRECT_TO_MANAGE_COMPONENTS;
    }
}