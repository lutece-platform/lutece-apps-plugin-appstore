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
import javax.servlet.http.HttpServletRequest;
import fr.paris.lutece.portal.service.message.SiteMessageException;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.web.xpages.XPageApplication;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.html.HtmlTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a simple implementation of an XPage
 */
public class AppStoreApp implements XPageApplication
{

    private static final String PARAMETER_ID_APPLICATION = "id_application";
    private static final String PROPERTY_PAGE_PATH = "appstore.pagePathLabel";
    private static final String PROPERTY_PAGE_TITLE = "appstore.pageTitle";
    private static final String MARK_APPLICATIONS_LIST = "applications_list";
    private static final String MARK_APPLICATION = "application";
    private static final String TEMPLATE_HOMEPAGE = "/skin/plugins/appstore/appstore.html";
    private static final String TEMPLATE_APPLICATION = "/skin/plugins/appstore/application.html";

    /**
     * Returns the content of the page appstore.
     *
     * @param request The http request
     * @param nMode The current mode
     * @param plugin The plugin object
     * @throws fr.paris.lutece.portal.service.message.SiteMessageException
     * Message displayed if an exception occurs
     */
    @Override
    public XPage getPage(HttpServletRequest request, int nMode, Plugin plugin)
            throws SiteMessageException
    {
        XPage page = new XPage();

        page.setTitle(AppPropertiesService.getProperty(PROPERTY_PAGE_TITLE));
        page.setPathLabel(AppPropertiesService.getProperty(PROPERTY_PAGE_PATH));

        String strApplicationId = request.getParameter(PARAMETER_ID_APPLICATION);
        if ( strApplicationId != null)
        {
            int nApplicationId = Integer.parseInt(strApplicationId);
            getApplicationContent(request, page, nApplicationId );
        }
        else
        {
            getHomePageContent(request, page);
        }



        return page;
    }

    private void getHomePageContent(HttpServletRequest request, XPage page)
    {
        Map<String, Object> model = new HashMap<String, Object>();

        model.put(MARK_APPLICATIONS_LIST, ApplicationHome.getApplicationsList());

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_HOMEPAGE, request.getLocale(),  model );
        
        page.setContent(template.getHtml());
    }
    
    
    private void getApplicationContent(HttpServletRequest request, XPage page, int nApplicationId )
    {
        Application application = ApplicationHome.findByPrimaryKey(nApplicationId);
        Map<String, Object> model = new HashMap<String, Object>();

        model.put(MARK_APPLICATION, application );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_APPLICATION, request.getLocale(),  model );
        
        page.setContent(template.getHtml());
    }

}