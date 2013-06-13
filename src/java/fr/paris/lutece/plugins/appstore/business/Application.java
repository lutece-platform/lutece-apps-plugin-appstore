
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
 * This is the business class for the object Application
 */ 
public class Application
{
	// Variables declarations 
	private int _nIdApplication;
	private String _strTitle;
	private String _strDescription;
	private int _nIdCategory;
	private int _nApplicationOrder;
	private int _nIdIcon;
	private String _strPomUrl;
	private String _strWebappUrl;
	private String _strSqlScriptUrl;
	/**
	 * Returns the IdApplication
	 * @return The IdApplication
	 */
	public int getIdApplication()
	{
		return _nIdApplication;
	}

	/**
	 * Sets the IdApplication
	 * @param nIdApplication The IdApplication
	 */ 
	public void setIdApplication( int nIdApplication )
	{
		_nIdApplication = nIdApplication;
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
	 * Returns the IdCategory
	 * @return The IdCategory
	 */
	public int getIdCategory()
	{
		return _nIdCategory;
	}

	/**
	 * Sets the IdCategory
	 * @param nIdCategory The IdCategory
	 */ 
	public void setIdCategory( int nIdCategory )
	{
		_nIdCategory = nIdCategory;
	}
	/**
	 * Returns the ApplicationOrder
	 * @return The ApplicationOrder
	 */
	public int getApplicationOrder()
	{
		return _nApplicationOrder;
	}

	/**
	 * Sets the ApplicationOrder
	 * @param nApplicationOrder The ApplicationOrder
	 */ 
	public void setApplicationOrder( int nApplicationOrder )
	{
		_nApplicationOrder = nApplicationOrder;
	}
	/**
	 * Returns the IdIcon
	 * @return The IdIcon
	 */
	public int getIdIcon()
	{
		return _nIdIcon;
	}

	/**
	 * Sets the IdIcon
	 * @param nIdIcon The IdIcon
	 */ 
	public void setIdIcon( int nIdIcon )
	{
		_nIdIcon = nIdIcon;
	}
	/**
	 * Returns the PomUrl
	 * @return The PomUrl
	 */
	public String getPomUrl()
	{
		return _strPomUrl;
	}

	/**
	 * Sets the PomUrl
	 * @param strPomUrl The PomUrl
	 */ 
	public void setPomUrl( String strPomUrl )
	{
		_strPomUrl = strPomUrl;
	}
	/**
	 * Returns the WebappUrl
	 * @return The WebappUrl
	 */
	public String getWebappUrl()
	{
		return _strWebappUrl;
	}

	/**
	 * Sets the WebappUrl
	 * @param strWebappUrl The WebappUrl
	 */ 
	public void setWebappUrl( String strWebappUrl )
	{
		_strWebappUrl = strWebappUrl;
	}
	/**
	 * Returns the SqlScriptUrl
	 * @return The SqlScriptUrl
	 */
	public String getSqlScriptUrl()
	{
		return _strSqlScriptUrl;
	}

	/**
	 * Sets the SqlScriptUrl
	 * @param strSqlScriptUrl The SqlScriptUrl
	 */ 
	public void setSqlScriptUrl( String strSqlScriptUrl )
	{
		_strSqlScriptUrl = strSqlScriptUrl;
	}
}