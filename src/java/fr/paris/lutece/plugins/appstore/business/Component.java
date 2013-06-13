
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

/**
 * This is the business class for the object Component
 */ 
public class Component
{
	// Variables declarations 
	private int _nIdComponent;
	private String _strGroupId;
	private String _strTitle;
	private String _strDescription;
	private String _strArtifactId;
	private String _strVersion;
	private String _strComponentType;
	/**
	 * Returns the IdComponent
	 * @return The IdComponent
	 */
	public int getIdComponent()
	{
		return _nIdComponent;
	}

	/**
	 * Sets the IdComponent
	 * @param nIdComponent The IdComponent
	 */ 
	public void setIdComponent( int nIdComponent )
	{
		_nIdComponent = nIdComponent;
	}
	/**
	 * Returns the GroupId
	 * @return The GroupId
	 */
	public String getGroupId()
	{
		return _strGroupId;
	}

	/**
	 * Sets the GroupId
	 * @param strGroupId The GroupId
	 */ 
	public void setGroupId( String strGroupId )
	{
		_strGroupId = strGroupId;
	}
	/**
	 * Returns the Title
	 * @return The Title
	 */
	public String getTitle()
	{
		return _strTitle;
	}

	/**
	 * Sets the Title
	 * @param strTitle The Title
	 */ 
	public void setTitle( String strTitle )
	{
		_strTitle = strTitle;
	}
	/**
	 * Returns the Description
	 * @return The Description
	 */
	public String getDescription()
	{
		return _strDescription;
	}

	/**
	 * Sets the Description
	 * @param strDescription The Description
	 */ 
	public void setDescription( String strDescription )
	{
		_strDescription = strDescription;
	}
	/**
	 * Returns the ArtifactId
	 * @return The ArtifactId
	 */
	public String getArtifactId()
	{
		return _strArtifactId;
	}

	/**
	 * Sets the ArtifactId
	 * @param strArtifactId The ArtifactId
	 */ 
	public void setArtifactId( String strArtifactId )
	{
		_strArtifactId = strArtifactId;
	}
	/**
	 * Returns the Version
	 * @return The Version
	 */
	public String getVersion()
	{
		return _strVersion;
	}

	/**
	 * Sets the Version
	 * @param strVersion The Version
	 */ 
	public void setVersion( String strVersion )
	{
		_strVersion = strVersion;
	}
	/**
	 * Returns the ComponentType
	 * @return The ComponentType
	 */
	public String getComponentType()
	{
		return _strComponentType;
	}

	/**
	 * Sets the ComponentType
	 * @param strComponentType The ComponentType
	 */ 
	public void setComponentType( String strComponentType )
	{
		_strComponentType = strComponentType;
	}
}