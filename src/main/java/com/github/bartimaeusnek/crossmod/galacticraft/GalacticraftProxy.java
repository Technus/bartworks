/*
 * Copyright (c) 2019 bartimaeusnek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.bartimaeusnek.crossmod.galacticraft;

import com.github.bartimaeusnek.bartworks.common.configs.ConfigHandler;
import com.github.bartimaeusnek.crossmod.galacticraft.solarsystems.CalebriSolarSystem;
import com.github.bartimaeusnek.crossmod.galacticraft.solarsystems.Ross128SolarSystem;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gregtech.api.objects.GT_UO_DimensionList;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static com.github.bartimaeusnek.bartworks.system.oregen.BW_WorldGenRoss128b.init_OresRoss128;
import static com.github.bartimaeusnek.bartworks.system.oregen.BW_WorldGenRoss128b.init_undergroundFluidsRoss128;

public class GalacticraftProxy {
    public static GT_UO_DimensionList uo_dimensionList = new GT_UO_DimensionList();
    static Configuration gtConf;
    private GalacticraftProxy() {
    }

    public static void postInit(FMLPostInitializationEvent e){
        if (FMLCommonHandler.instance().getSide().isServer() || FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            GalacticraftProxy.serverPostInit(e);
        } else {
            GalacticraftProxy.clientPostInit(e);
        }
        GalacticraftProxy.commonPostInit(e);
    }

    public static void preInit(FMLPreInitializationEvent e) {
        if (FMLCommonHandler.instance().getSide().isServer() || FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            GalacticraftProxy.serverpreInit(e);
        } else {
            GalacticraftProxy.clientpreInit(e);
        }
        GalacticraftProxy.commonpreInit(e);
    }

    private static void serverpreInit(FMLPreInitializationEvent e) {

    }

    private static void clientpreInit(FMLPreInitializationEvent e) {
    }

    private static void commonpreInit(FMLPreInitializationEvent e) {
        GalacticraftProxy.gtConf = new Configuration(new File(new File(e.getModConfigurationDirectory(), "GregTech"), "GregTech.cfg"));
        GalacticraftProxy.uo_dimensionList.getConfig(GalacticraftProxy.gtConf, "undergroundfluid");
        init_undergroundFluidsRoss128();
        if (GalacticraftProxy.gtConf.hasChanged())
            GalacticraftProxy.gtConf.save();
        init_OresRoss128();
    }

    public static void init(FMLInitializationEvent e) {
        if (FMLCommonHandler.instance().getSide().isServer() || FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            GalacticraftProxy.serverInit(e);
        } else {
            GalacticraftProxy.clientInit(e);
        }
        GalacticraftProxy.commonInit(e);
    }

    private static void serverInit(FMLInitializationEvent e) {

    }

    private static void clientInit(FMLInitializationEvent e) {

    }

    private static void commonInit(FMLInitializationEvent e) {
        if (ConfigHandler.Ross128Enabled)
            Ross128SolarSystem.init();
        new CalebriSolarSystem();
    }
    private static void serverPostInit(FMLPostInitializationEvent e) {

    }

    private static void clientPostInit(FMLPostInitializationEvent e) {

    }

    private static void commonPostInit(FMLPostInitializationEvent e) {

    }
}