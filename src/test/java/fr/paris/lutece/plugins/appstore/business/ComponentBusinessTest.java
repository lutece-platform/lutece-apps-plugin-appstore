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

package fr.paris.lutece.plugins.appstore.business;

import fr.paris.lutece.test.LuteceTestCase;
import fr.paris.lutece.plugins.appstore.business.Component;
import fr.paris.lutece.plugins.appstore.business.ComponentHome;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.plugin.Plugin;

public class ComponentBusinessTest extends LuteceTestCase
{
    private final static int IDCOMPONENT = 1;
    private final static String GROUPID1 = "GroupId1";
    private final static String GROUPID2 = "GroupId2";
    private final static String TITLE1 = "Title1";
    private final static String TITLE2 = "Title2";
    private final static String DESCRIPTION1 = "Description1";
    private final static String DESCRIPTION2 = "Description2";
    private final static String ARTIFACTID1 = "ArtifactId1";
    private final static String ARTIFACTID2 = "ArtifactId2";
    private final static String VERSION1 = "Version1";
    private final static String VERSION2 = "Version2";
    private final static String COMPONENTTYPE1 = "ComponentType1";
    private final static String COMPONENTTYPE2 = "ComponentType2";

    public void testBusiness(  )
    {
        // Initialize an object
        Component component = new Component();
        component.setId( IDCOMPONENT );
        component.setGroupId( GROUPID1 );
        component.setTitle( TITLE1 );
        component.setDescription( DESCRIPTION1 );
        component.setArtifactId( ARTIFACTID1 );
        component.setVersion( VERSION1 );
        component.setComponentType( COMPONENTTYPE1 );

        // Create test
        ComponentHome.create( component );
        Component componentStored = ComponentHome.findByPrimaryKey( component.getId() );
        assertEquals( componentStored.getId() , component.getId() );
        assertEquals( componentStored.getGroupId() , component.getGroupId() );
        assertEquals( componentStored.getTitle() , component.getTitle() );
        assertEquals( componentStored.getDescription() , component.getDescription() );
        assertEquals( componentStored.getArtifactId() , component.getArtifactId() );
        assertEquals( componentStored.getVersion() , component.getVersion() );
        assertEquals( componentStored.getComponentType() , component.getComponentType() );

        // Update test
        component.setGroupId( GROUPID2 );
        component.setTitle( TITLE2 );
        component.setDescription( DESCRIPTION2 );
        component.setArtifactId( ARTIFACTID2 );
        component.setVersion( VERSION2 );
        component.setComponentType( COMPONENTTYPE2 );
        ComponentHome.update( component );
        componentStored = ComponentHome.findByPrimaryKey( component.getId() );
        assertEquals( componentStored.getGroupId() , component.getGroupId() );
        assertEquals( componentStored.getTitle() , component.getTitle() );
        assertEquals( componentStored.getDescription() , component.getDescription() );
        assertEquals( componentStored.getArtifactId() , component.getArtifactId() );
        assertEquals( componentStored.getVersion() , component.getVersion() );
        assertEquals( componentStored.getComponentType() , component.getComponentType() );

        // List test
        ComponentHome.getComponentsList();

        // Delete test
        ComponentHome.remove( component.getId() );
        componentStored = ComponentHome.findByPrimaryKey( component.getId() );
        assertNull( componentStored );
        
    }

}