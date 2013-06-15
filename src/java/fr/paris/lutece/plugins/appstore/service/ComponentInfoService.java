/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.appstore.service;

import fr.paris.lutece.plugins.appstore.business.Component;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;


/**
 *
 * @author pierre
 */
public class ComponentInfoService
{
    private static final String NEXUS_URL = "http://dev.lutece.paris.fr/nexus/content/groups/maven_repository/fr/paris/lutece/plugins/";

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
            component.setVersion( "Release not found" );
        }
    }
}
