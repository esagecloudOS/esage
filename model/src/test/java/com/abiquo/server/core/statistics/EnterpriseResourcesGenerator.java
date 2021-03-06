/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package com.abiquo.server.core.statistics;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.abiquo.server.core.common.DefaultEntityGenerator;
import com.softwarementors.commons.test.SeedGenerator;
import com.softwarementors.commons.testng.AssertEx;

public class EnterpriseResourcesGenerator extends DefaultEntityGenerator<EnterpriseResources>
{

    public EnterpriseResourcesGenerator(SeedGenerator seed)
    {
        super(seed);

    }

    @Override
    public void assertAllPropertiesEqual(EnterpriseResources obj1, EnterpriseResources obj2)
    {
        AssertEx.assertPropertiesEqualSilent(obj1, obj2,
            EnterpriseResources.REPOSITORY_RESERVED_PROPERTY,
            EnterpriseResources.MEMORY_RESERVED_PROPERTY,
            EnterpriseResources.VLAN_RESERVED_PROPERTY,
            EnterpriseResources.PUBLIC_I_PS_USED_PROPERTY,
            EnterpriseResources.PUBLIC_I_PS_RESERVED_PROPERTY,
            EnterpriseResources.LOCAL_STORAGE_RESERVED_PROPERTY,
            EnterpriseResources.EXT_STORAGE_USED_PROPERTY, EnterpriseResources.VLAN_USED_PROPERTY,
            EnterpriseResources.EXT_STORAGE_RESERVED_PROPERTY,
            EnterpriseResources.LOCAL_STORAGE_USED_PROPERTY,
            EnterpriseResources.V_CPU_USED_PROPERTY, EnterpriseResources.V_CPU_RESERVED_PROPERTY,
            EnterpriseResources.REPOSITORY_USED_PROPERTY, EnterpriseResources.MEMORY_USED_PROPERTY);
    }

    @Override
    public EnterpriseResources createUniqueInstance()
    {
        // FIXME: Write here how to create the pojo

        EnterpriseResources enterpriseResources = new EnterpriseResources();

        return enterpriseResources;
    }

    @Override
    public void addAuxiliaryEntitiesToPersist(EnterpriseResources entity,
        List<Object> entitiesToPersist)
    {
        super.addAuxiliaryEntitiesToPersist(entity, entitiesToPersist);

    }

}
