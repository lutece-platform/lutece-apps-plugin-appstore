/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.appstore.service;

import fr.paris.lutece.plugins.appstore.business.Component;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

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
            Document jarList = Jsoup.connect( NEXUS_URL + component.getArtifactId(  ) ).get(  );
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
        catch ( Exception e )
        {
            AppLogService.error( "AppStore - ComponentInfoService : Error retrieving release version : " + e.getMessage() , e );
            component.setVersion( "Release not found" );
        }
    }
}
