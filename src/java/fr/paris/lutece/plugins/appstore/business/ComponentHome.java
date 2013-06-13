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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import java.util.Collection;

/**
 * This class provides instances management methods (create, find, ...) for Component objects
 */

public final class ComponentHome
{

    // Static variable pointed at the DAO instance

    private static IComponentDAO _dao = ( IComponentDAO ) SpringContextService.getBean( "appstore.componentDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "appstore" );

    /**
     * Private constructor - this class need not be instantiated
     */

    private ComponentHome(  )
    {
    }

    /**
     * Create an instance of the component class
     * @param component The instance of the Component which contains the informations to store
     * @return The  instance of component which has been created with its primary key.
     */

    public static Component create( Component component )
    {
        _dao.insert( component, _plugin );

        return component;
    }


    /**
     * Update of the component which is specified in parameter
     * @param component The instance of the Component which contains the data to store
     * @return The instance of the  component which has been updated
     */

    public static Component update( Component component )
    {
        _dao.store( component, _plugin );

        return component;
    }


    /**
     * Remove the component whose identifier is specified in parameter
     * @param nComponentId The component Id
     */


    public static void remove( int nComponentId )
    {
        _dao.delete( nComponentId, _plugin );
    }


    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a component whose identifier is specified in parameter
     * @param nKey The component primary key
     * @return an instance of Component
     */

    public static Component findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin);
    }


    /**
     * Load the data of all the component objects and returns them in form of a collection
     * @return the collection which contains the data of all the component objects
     */

    public static Collection<Component> getComponentsList( )
    {
        return _dao.selectComponentsList( _plugin );
    }

}

