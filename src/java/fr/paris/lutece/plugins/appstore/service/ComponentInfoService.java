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
package fr.paris.lutece.plugins.appstore.service;

import fr.paris.lutece.plugins.appstore.business.Component;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;


/**
 * Component Info Service
 */
public class ComponentInfoService
{
    private static final String PROPERTY_MAVEN_URL_PLUGINS = "appstore.maven.url.plugins";
    private static final String NEXUS_URL = AppPropertiesService.getProperty(PROPERTY_MAVEN_URL_PLUGINS);

    public static void getReleaseVersion( Component component )
    {
        try
        {
            HttpAccess httpAccess = new HttpAccess();
            String strHtml = httpAccess.doGet( NEXUS_URL + component.getArtifactId(  ));
            Document jarList =  Jsoup.parse( strHtml );
            Elements trList = jarList.select( "td a" );

            StringBuilder strJson = new StringBuilder(  );

            for ( int i = 4; i < trList.size(  ); i++ )
            {
                Element tr = trList.get( i );
                String version = tr.text(  ).replaceAll( "\\/", "" );
                strJson.append( "{\"release\":\"" ).append( version ).append( "\"}," );
                component.setVersion( version );
            }
        }
        catch ( HttpAccessException e )
        {
            AppLogService.error( "AppStore - ComponentInfoService : Error retrieving release version : " + e.getMessage() , e );
            component.setVersion( "Release not found" );
        }
    }
}
