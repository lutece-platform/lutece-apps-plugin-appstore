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
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This class provides Data Access methods for Application objects
 */
public final class ApplicationDAO implements IApplicationDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_application ) FROM appstore_application";
    private static final String SQL_QUERY_SELECT = "SELECT a.id_application, a.title, a.description, a.id_category, a.id_order, a.id_icon, a.pom_url, a.webapp_url, a.sql_script_url, b.name,"
            + " a.artifact_id, a.presentation, a.installation, a.version, a.build_status, a.publish_status "
            + " FROM appstore_application a, appstore_category b WHERE a.id_category = b.id_category AND id_application = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO appstore_application ( id_application, title, description, id_category, id_order, id_icon, pom_url, webapp_url, sql_script_url, artifact_id, presentation, installation, version, build_status, publish_status ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM appstore_application WHERE id_application = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE appstore_application SET id_application = ?, title = ?, description = ?, id_category = ?, id_order = ?, id_icon = ?, pom_url = ?, webapp_url = ?, sql_script_url = ?, artifact_id = ?, presentation = ?, installation = ?, version = ?, build_status = ?, publish_status = ?  WHERE id_application = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT a.id_application, a.title, a.description, a.id_category, a.id_order, a.id_icon, a.pom_url, a.webapp_url, a.sql_script_url, b.name, "
            + " a.artifact_id, a.presentation, a.installation, a.version, a.build_status, a.publish_status " 
            + " FROM appstore_application a, appstore_category b WHERE a.id_category = b.id_category ORDER by a.id_order";

    private static final String SQL_QUERY_DELETE_COMPONENT = "DELETE FROM appstore_application_component WHERE id_application = ? ";
    private static final String SQL_QUERY_INSERT_COMPONENT = "INSERT INTO appstore_application_component ( id_application, id_component ) VALUES ( ?, ? ) ";
    
    /**
     * Generates a new primary key
     * @param plugin The Plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK, plugin );
        daoUtil.executeQuery(  );

        int nKey;

        daoUtil.next(  );
        nKey = daoUtil.getInt( 1 ) + 1;
        daoUtil.free(  );

        return nKey;
    }

    /**
     * Insert a new record in the table.
     * @param application instance of the Application object to insert
     * @param plugin The plugin
     */
    @Override
    public void insert( Application application, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        application.setId( newPrimaryKey( plugin ) );

        daoUtil.setInt( 1, application.getId(  ) );
        daoUtil.setString( 2, application.getTitle(  ) );
        daoUtil.setString( 3, application.getDescription(  ) );
        daoUtil.setInt( 4, application.getIdCategory(  ) );
        daoUtil.setInt( 5, application.getOrder(  ) );
        daoUtil.setInt( 6, application.getIdIcon(  ) );
        daoUtil.setString( 7, application.getPomUrl(  ) );
        daoUtil.setString( 8, application.getWebappUrl(  ) );
        daoUtil.setString( 9, application.getSqlScriptUrl(  ) );
        daoUtil.setString( 10, application.getArtifactId() );
        daoUtil.setString( 11, application.getPresentation() );
        daoUtil.setString( 12, application.getInstallation() );
        daoUtil.setString( 13, application.getVersion() );
        daoUtil.setInt( 14, application.getBuildStatus() );
        daoUtil.setInt( 15, application.getPublishStatus() );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of the application from the table
     * @param nId The identifier of the application
     * @param plugin The plugin
     * @return the instance of the Application
     */
    @Override
    public Application load( int nId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1, nId );
        daoUtil.executeQuery(  );

        Application application = null;

        if ( daoUtil.next(  ) )
        {
            application = new Application(  );

            application.setId( daoUtil.getInt( 1 ) );
            application.setTitle( daoUtil.getString( 2 ) );
            application.setDescription( daoUtil.getString( 3 ) );
            application.setIdCategory( daoUtil.getInt( 4 ) );
            application.setOrder( daoUtil.getInt( 5 ) );
            application.setIdIcon( daoUtil.getInt( 6 ) );
            application.setPomUrl( daoUtil.getString( 7 ) );
            application.setWebappUrl( daoUtil.getString( 8 ) );
            application.setSqlScriptUrl( daoUtil.getString( 9 ) );
            application.setCategory( daoUtil.getString( 10 ) );
            application.setArtifactId( daoUtil.getString( 11 ));
            application.setPresentation( daoUtil.getString( 12 ));
            application.setInstallation( daoUtil.getString( 13 ));
            application.setVersion( daoUtil.getString( 14 ));
            application.setBuildStatus(daoUtil.getInt( 15 ));
            application.setPublishStatus(daoUtil.getInt( 16 ));
        }

        daoUtil.free(  );

        return application;
    }

    /**
     * Delete a record from the table
     * @param nApplicationId The identifier of the application
     * @param plugin The plugin
     */
    @Override
    public void delete( int nApplicationId, Plugin plugin )
    {
        clearComponentsList( nApplicationId, plugin);
        
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nApplicationId );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
        
    }

    /**
     * Update the record in the table
     * @param application The reference of the application
     * @param plugin The plugin
     */
    @Override
    public void store( Application application, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );

        daoUtil.setInt( 1, application.getId(  ) );
        daoUtil.setString( 2, application.getTitle(  ) );
        daoUtil.setString( 3, application.getDescription(  ) );
        daoUtil.setInt( 4, application.getIdCategory(  ) );
        daoUtil.setInt( 5, application.getOrder(  ) );
        daoUtil.setInt( 6, application.getIdIcon(  ) );
        daoUtil.setString( 7, application.getPomUrl(  ) );
        daoUtil.setString( 8, application.getWebappUrl(  ) );
        daoUtil.setString( 9, application.getSqlScriptUrl(  ) );
        daoUtil.setString( 10, application.getArtifactId() );
        daoUtil.setString( 11, application.getPresentation() );
        daoUtil.setString( 12, application.getInstallation() );
        daoUtil.setString( 13, application.getVersion() );
        daoUtil.setInt( 14, application.getBuildStatus() );
        daoUtil.setInt( 15, application.getPublishStatus() );
        daoUtil.setInt( 16, application.getId(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of all the applications and returns them as a collection
     * @param plugin The plugin
     * @return The Collection which contains the data of all the applications
     */
    @Override
    public Collection<Application> selectApplicationsList( Plugin plugin )
    {
        Collection<Application> applicationList = new ArrayList<Application>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Application application = new Application(  );

            application.setId( daoUtil.getInt( 1 ) );
            application.setTitle( daoUtil.getString( 2 ) );
            application.setDescription( daoUtil.getString( 3 ) );
            application.setIdCategory( daoUtil.getInt( 4 ) );
            application.setOrder( daoUtil.getInt( 5 ) );
            application.setIdIcon( daoUtil.getInt( 6 ) );
            application.setPomUrl( daoUtil.getString( 7 ) );
            application.setWebappUrl( daoUtil.getString( 8 ) );
            application.setSqlScriptUrl( daoUtil.getString( 9 ) );
            application.setCategory( daoUtil.getString( 10 ) );
            application.setArtifactId( daoUtil.getString( 11 ));
            application.setPresentation( daoUtil.getString( 12 ));
            application.setInstallation( daoUtil.getString( 13 ));
            application.setVersion( daoUtil.getString( 14 ));
            application.setBuildStatus(daoUtil.getInt( 15 ));
            application.setPublishStatus(daoUtil.getInt( 16 ));

            applicationList.add( application );
        }

        daoUtil.free(  );

        return applicationList;
    }

    @Override
    public void clearComponentsList(int nApplicationId, Plugin plugin)
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE_COMPONENT, plugin );
        daoUtil.setInt( 1, nApplicationId );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
   }

    @Override
    public void addComponent(int nApplicationId, int nComponentId, Plugin plugin)
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT_COMPONENT, plugin );

        daoUtil.setInt( 1, nApplicationId );
        daoUtil.setInt( 2, nComponentId );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }
}
