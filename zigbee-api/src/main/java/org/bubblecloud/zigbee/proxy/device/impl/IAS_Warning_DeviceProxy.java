/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.proxy.device.impl;

import org.bubblecloud.zigbee.ZigbeeConstants;
import org.bubblecloud.zigbee.network.ZigBeeDevice;
import org.bubblecloud.zigbee.proxy.*;
import org.bubblecloud.zigbee.proxy.cluster.general.Groups;
import org.bubblecloud.zigbee.proxy.cluster.general.Scenes;
import org.bubblecloud.zigbee.proxy.cluster.security_safety.IASWD;
import org.bubblecloud.zigbee.proxy.cluster.security_safety.IASZone;
import org.bubblecloud.zigbee.proxy.device.security_safety.IAS_Warning;
import org.bubblecloud.zigbee.proxy.DeviceProxyBase;
import org.bubblecloud.zigbee.ZigbeeProxyContext;

/**
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 */
public class IAS_Warning_DeviceProxy extends DeviceProxyBase implements IAS_Warning {

    private IASZone iasZoneCluster;
    private IASWD iasWD;
    private Scenes scenes;
    private Groups groups;

    public IAS_Warning_DeviceProxy(ZigbeeProxyContext ctx, ZigBeeDevice zbDevice) throws ZigBeeHAException {

        super(ctx, zbDevice);

        iasZoneCluster = (IASZone) getCluster(ZigbeeConstants.CLUSTER_ID_IAS_ZONE);
        iasWD = (IASWD) getCluster(ZigbeeConstants.CLUSTER_ID_IAS_WD);

        scenes = (Scenes) getCluster(ZigbeeConstants.CLUSTER_ID_SCENES);
        groups = (Groups) getCluster(ZigbeeConstants.CLUSTER_ID_GROUPS);
    }

    public IASZone getIASZone() {

        return iasZoneCluster;
    }

    public IASWD getIASWD() {

        return iasWD;
    }

    public Scenes getScenes() {

        return scenes;
    }

    public Groups getGroups() {

        return groups;
    }

    @Override
    public String getName() {

        return IAS_Warning_DeviceProxy.NAME;
    }

    @Override
    public DeviceDescription getDescription() {

        return DEVICE_DESCRIPTOR;
    }

    final static DeviceDescription DEVICE_DESCRIPTOR = new AbstractDeviceDescription() {

        public int[] getCustomClusters() {
            return IAS_Warning.CUSTOM;
        }

        public int[] getMandatoryCluster() {
            return IAS_Warning.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return IAS_Warning.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return IAS_Warning.STANDARD;
        }
    };
}