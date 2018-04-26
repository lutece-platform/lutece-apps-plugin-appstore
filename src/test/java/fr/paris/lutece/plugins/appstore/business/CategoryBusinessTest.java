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

import fr.paris.lutece.plugins.appstore.business.Category;
import fr.paris.lutece.plugins.appstore.business.CategoryHome;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.test.LuteceTestCase;

public class CategoryBusinessTest extends LuteceTestCase
{
    private final static int IDCATEGORY = 1;
    private final static String NAME1 = "Name1";
    private final static String NAME2 = "Name2";
    private final static int CATEGORYORDER1 = 1;
    private final static int CATEGORYORDER2 = 2;

    public void testBusiness( )
    {
        // Initialize an object
        Category category = new Category( );
        category.setId( IDCATEGORY );
        category.setName( NAME1 );
        category.setOrder( CATEGORYORDER1 );

        // Create test
        CategoryHome.create( category );

        Category categoryStored = CategoryHome.findByPrimaryKey( category.getId( ) );
        assertEquals( categoryStored.getId( ), category.getId( ) );
        assertEquals( categoryStored.getName( ), category.getName( ) );
        assertEquals( categoryStored.getOrder( ), category.getOrder( ) );

        // Update test
        category.setName( NAME2 );
        category.setOrder( CATEGORYORDER2 );
        CategoryHome.update( category );
        categoryStored = CategoryHome.findByPrimaryKey( category.getId( ) );
        assertEquals( categoryStored.getName( ), category.getName( ) );
        assertEquals( categoryStored.getOrder( ), category.getOrder( ) );

        // List test
        CategoryHome.getCategorysList( );

        // Delete test
        CategoryHome.remove( category.getId( ) );
        categoryStored = CategoryHome.findByPrimaryKey( category.getId( ) );
        assertNull( categoryStored );
    }
}
