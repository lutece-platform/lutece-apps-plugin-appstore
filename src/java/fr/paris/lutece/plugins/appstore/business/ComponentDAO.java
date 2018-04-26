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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class provides Data Access methods for Component objects
 */
public final class ComponentDAO implements IComponentDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_component ) FROM appstore_component";
    private static final String SQL_QUERY_SELECT = "SELECT id_component, group_id, title, description, artifact_id, version, component_type FROM appstore_component WHERE id_component = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO appstore_component ( id_component, group_id, title, description, artifact_id, version, component_type ) VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM appstore_component WHERE id_component = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE appstore_component SET id_component = ?, group_id = ?, title = ?, description = ?, artifact_id = ?, version = ?, component_type = ? WHERE id_component = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_component, group_id, title, description, artifact_id, version, component_type FROM appstore_component";
    private static final String SQL_QUERY_SELECT_BY_APPLICATION = "SELECT a.id_component, a.group_id, a.title, a.description, a.artifact_id, a.version, a.component_type "
            + " FROM appstore_component a , appstore_application_component b WHERE a.id_component = b.id_component AND b.id_application = ?";
    private static final String SQL_QUERY_DELETE_APPLICATION = "DELETE FROM appstore_application_component WHERE id_component = ? ";

    /**
     * Generates a new primary key
     * 
     * @param plugin
     *            The Plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK, plugin );
        daoUtil.executeQuery( );

        int nKey;

        daoUtil.next( );

        nKey = daoUtil.getInt( 1 ) + 1;
        daoUtil.free( );

        return nKey;
    }

    /**
     * Insert a new record in the table.
     * 
     * @param component
     *            instance of the Component object to insert
     * @param plugin
     *            The plugin
     */
    @Override
    public void insert( Component component, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        component.setId( newPrimaryKey( plugin ) );

        daoUtil.setInt( 1, component.getId( ) );
        daoUtil.setString( 2, component.getGroupId( ) );
        daoUtil.setString( 3, component.getTitle( ) );
        daoUtil.setString( 4, component.getDescription( ) );
        daoUtil.setString( 5, component.getArtifactId( ) );
        daoUtil.setString( 6, component.getVersion( ) );
        daoUtil.setString( 7, component.getComponentType( ) );

        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * Load the data of the component from the table
     * 
     * @param nId
     *            The identifier of the component
     * @param plugin
     *            The plugin
     * @return the instance of the Component
     */
    @Override
    public Component load( int nId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1, nId );
        daoUtil.executeQuery( );

        Component component = null;

        if ( daoUtil.next( ) )
        {
            component = new Component( );

            component.setId( daoUtil.getInt( 1 ) );
            component.setGroupId( daoUtil.getString( 2 ) );
            component.setTitle( daoUtil.getString( 3 ) );
            component.setDescription( daoUtil.getString( 4 ) );
            component.setArtifactId( daoUtil.getString( 5 ) );
            component.setVersion( daoUtil.getString( 6 ) );
            component.setComponentType( daoUtil.getString( 7 ) );
        }

        daoUtil.free( );

        return component;
    }

    /**
     * Delete a record from the table
     * 
     * @param nComponentId
     *            The identifier of the component
     * @param plugin
     *            The plugin
     */
    @Override
    public void delete( int nComponentId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE_APPLICATION, plugin );
        daoUtil.setInt( 1, nComponentId );
        daoUtil.executeUpdate( );
        daoUtil.free( );

        daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nComponentId );
        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * Update the record in the table
     * 
     * @param component
     *            The reference of the component
     * @param plugin
     *            The plugin
     */
    @Override
    public void store( Component component, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );

        daoUtil.setInt( 1, component.getId( ) );
        daoUtil.setString( 2, component.getGroupId( ) );
        daoUtil.setString( 3, component.getTitle( ) );
        daoUtil.setString( 4, component.getDescription( ) );
        daoUtil.setString( 5, component.getArtifactId( ) );
        daoUtil.setString( 6, component.getVersion( ) );
        daoUtil.setString( 7, component.getComponentType( ) );
        daoUtil.setInt( 8, component.getId( ) );

        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * Load the data of all the components and returns them as a collection
     * 
     * @param plugin
     *            The plugin
     * @return The Collection which contains the data of all the components
     */
    @Override
    public Collection<Component> selectComponentsList( Plugin plugin )
    {
        Collection<Component> componentList = new ArrayList<Component>( );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery( );

        while ( daoUtil.next( ) )
        {
            Component component = new Component( );

            component.setId( daoUtil.getInt( 1 ) );
            component.setGroupId( daoUtil.getString( 2 ) );
            component.setTitle( daoUtil.getString( 3 ) );
            component.setDescription( daoUtil.getString( 4 ) );
            component.setArtifactId( daoUtil.getString( 5 ) );
            component.setVersion( daoUtil.getString( 6 ) );
            component.setComponentType( daoUtil.getString( 7 ) );

            componentList.add( component );
        }

        daoUtil.free( );

        return componentList;
    }

    @Override
    public List<Component> selectByApplication( int nApplicationId, Plugin plugin )
    {
        List<Component> componentList = new ArrayList<Component>( );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_APPLICATION, plugin );
        daoUtil.setInt( 1, nApplicationId );
        daoUtil.executeQuery( );

        while ( daoUtil.next( ) )
        {
            Component component = new Component( );

            component.setId( daoUtil.getInt( 1 ) );
            component.setGroupId( daoUtil.getString( 2 ) );
            component.setTitle( daoUtil.getString( 3 ) );
            component.setDescription( daoUtil.getString( 4 ) );
            component.setArtifactId( daoUtil.getString( 5 ) );
            component.setVersion( daoUtil.getString( 6 ) );
            component.setComponentType( daoUtil.getString( 7 ) );

            componentList.add( component );
        }

        daoUtil.free( );

        return componentList;
    }
}
