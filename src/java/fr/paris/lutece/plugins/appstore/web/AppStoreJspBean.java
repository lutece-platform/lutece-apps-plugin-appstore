/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.appstore.web;

import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;


/**
 * AppStore JSP Bean abstract class for JSP Bean
 */
public abstract class AppStoreJspBean extends PluginAdminPageJspBean
{
    // Right
    public static final String RIGHT_MANAGEAPPSTORE = "APPSTORE_MANAGEMENT";
    protected static final String PARAMETER_PAGE_INDEX = "page_index";
    protected static final String MARK_PAGINATOR = "paginator";
    protected static final String MARK_NB_ITEMS_PER_PAGE = "nb_items_per_page";

    //Variables
    protected int _nDefaultItemsPerPage;
    protected String _strCurrentPageIndex;
    protected int _nItemsPerPage;
}
