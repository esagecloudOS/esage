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

package com.abiquo.server.core.infrastructure.storage;

import java.util.ArrayList;
import java.util.List;

import com.abiquo.server.core.common.DefaultEntityGenerator;
import com.abiquo.server.core.infrastructure.Datacenter;
import com.abiquo.server.core.infrastructure.DatacenterGenerator;
import com.softwarementors.commons.test.SeedGenerator;
import com.softwarementors.commons.testng.AssertEx;

public class TierGenerator extends DefaultEntityGenerator<Tier>
{
    private DatacenterGenerator datacenterGenerator;

    public TierGenerator(final SeedGenerator seed)
    {
        super(seed);
        datacenterGenerator = new DatacenterGenerator(seed);
    }

    @Override
    public void assertAllPropertiesEqual(final Tier obj1, final Tier obj2)
    {
        AssertEx.assertPropertiesEqualSilent(obj1, obj2, Tier.NAME_PROPERTY, Tier.ENABLED_PROPERTY,
            Tier.DESCRIPTION_PROPERTY);

        datacenterGenerator.assertAllPropertiesEqual(obj1.getDatacenter(), obj2.getDatacenter());
    }

    @Override
    public Tier createUniqueInstance()
    {
        Datacenter datacenter = datacenterGenerator.createUniqueInstance();
        return createInstance(datacenter);
    }

    public Tier createInstance(final Datacenter datacenter)
    {
        String name = newString(nextSeed(), Tier.NAME_LENGTH_MIN, Tier.NAME_LENGTH_MAX);
        return createInstance(datacenter, name);
    }

    public Tier createInstance(final Datacenter datacenter, final String name)
    {
        Tier tier = new Tier();

        tier.setDatacenter(datacenter);
        tier.setName(name);
        tier.setDescription(newString(nextSeed(), Tier.DESCRIPTION_LENGTH_MIN,
            Tier.DESCRIPTION_LENGTH_MAX));
        tier.setEnabled(Boolean.TRUE);

        return tier;
    }

    public List<Tier> createTiersForDatacenter(final Datacenter datacenter)
    {
        List<Tier> listOfTiers = new ArrayList<Tier>();

        for (Integer i = 1; i <= 4; i++)
        {
            Tier currentTier = createInstance(datacenter, "Tier " + i.toString());
            listOfTiers.add(currentTier);
        }

        return listOfTiers;
    }

    @Override
    public void addAuxiliaryEntitiesToPersist(final Tier entity,
        final List<Object> entitiesToPersist)
    {
        super.addAuxiliaryEntitiesToPersist(entity, entitiesToPersist);

        Datacenter datacenter = entity.getDatacenter();
        datacenterGenerator.addAuxiliaryEntitiesToPersist(datacenter, entitiesToPersist);
        entitiesToPersist.add(datacenter);
    }

}
