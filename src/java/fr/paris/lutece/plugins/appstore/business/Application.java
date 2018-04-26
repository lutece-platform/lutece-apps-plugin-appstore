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

import fr.paris.lutece.portal.service.resource.IExtendableResource;

/**
 * This is the business class for the object Application
 */
public class Application implements IExtendableResource
{
    public static final String RESOURCE_TYPE = "APP";
    public static final String RESOURCE_TYPE_DESCRIPTION = "Appstore Application";

    // Variables declarations
    public static final int NOT_PUBLISHED = 0;
    public static final int PUBLISHED = 1;
    public static final int PUBLISHED_NEW = 2;
    private int _nIdApplication;
    private String _strTitle;
    private String _strDescription;
    private int _nIdCategory;
    private String _strCategory;
    private int _nOrder;
    private int _nIdIcon;
    private String _strPomUrl;
    private String _strWebappUrl;
    private String _strSqlScriptUrl;
    private String _strArtifactId;
    private String _strPresentation;
    private String _strInstallation;
    private String _strVersion;
    private int _nBuildStatus;
    private int _nPublishStatus;

    /**
     * Returns the IdApplication
     *
     * @return The IdApplication
     */
    public int getId( )
    {
        return _nIdApplication;
    }

    /**
     * Sets the IdApplication
     *
     * @param nIdApplication
     *            The IdApplication
     */
    public void setId( int nIdApplication )
    {
        _nIdApplication = nIdApplication;
    }

    /**
     * Returns the Title
     *
     * @return The Title
     */
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * Sets the Title
     *
     * @param strTitle
     *            The Title
     */
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }

    /**
     * Returns the Description
     *
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     *
     * @param strDescription
     *            The Description
     */
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }

    /**
     * Returns the IdCategory
     *
     * @return The IdCategory
     */
    public int getIdCategory( )
    {
        return _nIdCategory;
    }

    /**
     * Sets the IdCategory
     *
     * @param nIdCategory
     *            The IdCategory
     */
    public void setIdCategory( int nIdCategory )
    {
        _nIdCategory = nIdCategory;
    }

    /**
     * Returns the Category
     *
     * @return The Category
     */
    public String getCategory( )
    {
        return _strCategory;
    }

    /**
     * Sets the Category
     *
     * @param strCategory
     *            The Category
     */
    public void setCategory( String strCategory )
    {
        _strCategory = strCategory;
    }

    /**
     * Returns the ApplicationOrder
     *
     * @return The ApplicationOrder
     */
    public int getOrder( )
    {
        return _nOrder;
    }

    /**
     * Sets the ApplicationOrder
     *
     * @param nApplicationOrder
     *            The ApplicationOrder
     */
    public void setOrder( int nApplicationOrder )
    {
        _nOrder = nApplicationOrder;
    }

    /**
     * Returns the IdIcon
     *
     * @return The IdIcon
     */
    public int getIdIcon( )
    {
        return _nIdIcon;
    }

    /**
     * Sets the IdIcon
     *
     * @param nIdIcon
     *            The IdIcon
     */
    public void setIdIcon( int nIdIcon )
    {
        _nIdIcon = nIdIcon;
    }

    /**
     * Returns the PomUrl
     *
     * @return The PomUrl
     */
    public String getPomUrl( )
    {
        return _strPomUrl;
    }

    /**
     * Sets the PomUrl
     *
     * @param strPomUrl
     *            The PomUrl
     */
    public void setPomUrl( String strPomUrl )
    {
        _strPomUrl = strPomUrl;
    }

    /**
     * Returns the WebappUrl
     *
     * @return The WebappUrl
     */
    public String getWebappUrl( )
    {
        return _strWebappUrl;
    }

    /**
     * Sets the WebappUrl
     *
     * @param strWebappUrl
     *            The WebappUrl
     */
    public void setWebappUrl( String strWebappUrl )
    {
        _strWebappUrl = strWebappUrl;
    }

    /**
     * Returns the SqlScriptUrl
     *
     * @return The SqlScriptUrl
     */
    public String getSqlScriptUrl( )
    {
        return _strSqlScriptUrl;
    }

    /**
     * Sets the SqlScriptUrl
     *
     * @param strSqlScriptUrl
     *            The SqlScriptUrl
     */
    public void setSqlScriptUrl( String strSqlScriptUrl )
    {
        _strSqlScriptUrl = strSqlScriptUrl;
    }

    /**
     * Returns the ArtifactId
     *
     * @return The ArtifactId
     */
    public String getArtifactId( )
    {
        return _strArtifactId;
    }

    /**
     * Sets the ArtifactId
     *
     * @param strArtifactId
     *            The ArtifactId
     */
    public void setArtifactId( String strArtifactId )
    {
        _strArtifactId = strArtifactId;
    }

    /**
     * Returns the Presentation
     *
     * @return The Presentation
     */
    public String getPresentation( )
    {
        return _strPresentation;
    }

    /**
     * Sets the Presentation
     *
     * @param strPresentation
     *            The Presentation
     */
    public void setPresentation( String strPresentation )
    {
        _strPresentation = strPresentation;
    }

    /**
     * Returns the Installation
     *
     * @return The Installation
     */
    public String getInstallation( )
    {
        return _strInstallation;
    }

    /**
     * Sets the Installation
     *
     * @param strInstallation
     *            The Installation
     */
    public void setInstallation( String strInstallation )
    {
        _strInstallation = strInstallation;
    }

    /**
     * Returns the Version
     *
     * @return The Version
     */
    public String getVersion( )
    {
        return _strVersion;
    }

    /**
     * Sets the Version
     *
     * @param strVersion
     *            The Version
     */
    public void setVersion( String strVersion )
    {
        _strVersion = strVersion;
    }

    /**
     * Returns the BuildStatus
     *
     * @return The BuildStatus
     */
    public int getBuildStatus( )
    {
        return _nBuildStatus;
    }

    /**
     * Sets the BuildStatus
     *
     * @param nBuildStatus
     *            The BuildStatus
     */
    public void setBuildStatus( int nBuildStatus )
    {
        _nBuildStatus = nBuildStatus;
    }

    /**
     * Returns the PublishStatus
     *
     * @return The PublishStatus
     */
    public int getPublishStatus( )
    {
        return _nPublishStatus;
    }

    /**
     * Sets the PublishStatus
     *
     * @param nPublishStatus
     *            The PublishStatus
     */
    public void setPublishStatus( int nPublishStatus )
    {
        _nPublishStatus = nPublishStatus;
    }

    @Override
    public String getIdExtendableResource( )
    {
        return Integer.toString( _nIdApplication );
    }

    @Override
    public String getExtendableResourceType( )
    {
        return RESOURCE_TYPE;
    }

    @Override
    public String getExtendableResourceName( )
    {
        return _strTitle;
    }

    @Override
    public String getExtendableResourceDescription( )
    {
        return _strDescription;
    }

    @Override
    public String getExtendableResourceImageUrl( )
    {
        return "image?resource_type=appstore_icon_img&id=" + _nIdIcon;
    }
}
