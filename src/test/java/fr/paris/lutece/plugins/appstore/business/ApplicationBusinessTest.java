/*
 * Copyright (c) 2002-2018, Mairie de Paris
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
package fr.paris.lutece.plugins.appstore.business;

import fr.paris.lutece.plugins.appstore.business.Application;
import fr.paris.lutece.plugins.appstore.business.ApplicationHome;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.test.LuteceTestCase;

public class ApplicationBusinessTest extends LuteceTestCase
{
    private final static int IDAPPLICATION1 = 1;
    private final static int IDAPPLICATION2 = 2;
    private final static String TITLE1 = "Title1";
    private final static String TITLE2 = "Title2";
    private final static String DESCRIPTION1 = "Description1";
    private final static String DESCRIPTION2 = "Description2";
    private final static int IDCATEGORY1 = 1;
    private final static int IDCATEGORY2 = 2;
    private final static int APPLICATIONORDER1 = 1;
    private final static int APPLICATIONORDER2 = 2;
    private final static int IDICON1 = 1;
    private final static int IDICON2 = 2;
    private final static String POMURL1 = "PomUrl1";
    private final static String POMURL2 = "PomUrl2";
    private final static String WEBAPPURL1 = "WebappUrl1";
    private final static String WEBAPPURL2 = "WebappUrl2";
    private final static String SQLSCRIPTURL1 = "SqlScriptUrl1";
    private final static String SQLSCRIPTURL2 = "SqlScriptUrl2";

    public void testBusiness( )
    {
        // Initialize an object
        Application application = new Application( );
        application.setId( IDAPPLICATION1 );
        application.setTitle( TITLE1 );
        application.setDescription( DESCRIPTION1 );
        application.setIdCategory( IDCATEGORY1 );
        application.setOrder( APPLICATIONORDER1 );
        application.setIdIcon( IDICON1 );
        application.setPomUrl( POMURL1 );
        application.setWebappUrl( WEBAPPURL1 );
        application.setSqlScriptUrl( SQLSCRIPTURL1 );

        // Create test
        ApplicationHome.create( application );

        Application applicationStored = ApplicationHome.findByPrimaryKey( application.getId( ) );
        assertEquals( applicationStored.getId( ), application.getId( ) );
        assertEquals( applicationStored.getTitle( ), application.getTitle( ) );
        assertEquals( applicationStored.getDescription( ), application.getDescription( ) );
        assertEquals( applicationStored.getIdCategory( ), application.getIdCategory( ) );
        assertEquals( applicationStored.getOrder( ), application.getOrder( ) );
        assertEquals( applicationStored.getIdIcon( ), application.getIdIcon( ) );
        assertEquals( applicationStored.getPomUrl( ), application.getPomUrl( ) );
        assertEquals( applicationStored.getWebappUrl( ), application.getWebappUrl( ) );
        assertEquals( applicationStored.getSqlScriptUrl( ), application.getSqlScriptUrl( ) );

        // Update test
        application.setId( IDAPPLICATION2 );
        application.setTitle( TITLE2 );
        application.setDescription( DESCRIPTION2 );
        application.setIdCategory( IDCATEGORY2 );
        application.setOrder( APPLICATIONORDER2 );
        application.setIdIcon( IDICON2 );
        application.setPomUrl( POMURL2 );
        application.setWebappUrl( WEBAPPURL2 );
        application.setSqlScriptUrl( SQLSCRIPTURL2 );
        ApplicationHome.update( application );
        applicationStored = ApplicationHome.findByPrimaryKey( application.getId( ) );
        assertEquals( applicationStored.getId( ), application.getId( ) );
        assertEquals( applicationStored.getTitle( ), application.getTitle( ) );
        assertEquals( applicationStored.getDescription( ), application.getDescription( ) );
        assertEquals( applicationStored.getIdCategory( ), application.getIdCategory( ) );
        assertEquals( applicationStored.getOrder( ), application.getOrder( ) );
        assertEquals( applicationStored.getIdIcon( ), application.getIdIcon( ) );
        assertEquals( applicationStored.getPomUrl( ), application.getPomUrl( ) );
        assertEquals( applicationStored.getWebappUrl( ), application.getWebappUrl( ) );
        assertEquals( applicationStored.getSqlScriptUrl( ), application.getSqlScriptUrl( ) );

        // List test
        ApplicationHome.getApplicationsList( );

        // Delete test
        ApplicationHome.remove( application.getId( ) );
        applicationStored = ApplicationHome.findByPrimaryKey( application.getId( ) );
        assertNull( applicationStored );
    }
}
