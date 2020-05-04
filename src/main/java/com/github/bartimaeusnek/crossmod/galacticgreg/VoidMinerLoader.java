package com.github.bartimaeusnek.crossmod.galacticgreg;

import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.ISubTagContainer;

import java.util.Arrays;

public class VoidMinerLoader {

    private VoidMinerLoader() {
    }

    private static final int DEEPDARK_ID = 100;

    private static boolean hasOres(Materials materials){
        return (materials.mTypes & 8) != 0;
    }

    private static boolean hasOres(Werkstoff materials){
        return materials.hasItemType(OrePrefixes.ore);
    }

    private static void addVoidDimerDrops(ISubTagContainer materials){
        GT_TileEntity_VoidMiner_Base.addMatierialToDimensionList(DEEPDARK_ID, materials, 1f);
    }

    public static void initDeepDark() {
        Arrays.stream(Materials.values()).filter(VoidMinerLoader::hasOres).forEach(VoidMinerLoader::addVoidDimerDrops);
        Werkstoff.werkstoffHashSet.stream().filter(VoidMinerLoader::hasOres).forEach(VoidMinerLoader::addVoidDimerDrops);
    }
}
