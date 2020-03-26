/*
 * Copyright (c) 2018-2020 bartimaeusnek
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

package com.github.bartimaeusnek.bartworks.API;

import com.github.bartimaeusnek.bartworks.util.BWRecipes;
import gregtech.api.enums.Materials;
import net.minecraftforge.fluids.FluidStack;

public final class AcidGenFuelAdder {

    public static void addLiquidFuel(Materials M, int burn) {
        ((BWRecipes.BW_Recipe_Map_LiquidFuel) BWRecipes.instance.getMappingsFor((byte) 2)).addLiquidFuel(M, burn);
    }

    public static void addLiquidFuel(FluidStack fluidStack, int burn) {
        ((BWRecipes.BW_Recipe_Map_LiquidFuel) BWRecipes.instance.getMappingsFor((byte) 2)).addLiquidFuel(fluidStack, burn);
    }

    public static void addMoltenFuel(Materials M, int burn) {
        ((BWRecipes.BW_Recipe_Map_LiquidFuel) BWRecipes.instance.getMappingsFor((byte) 2)).addMoltenFuel(M, burn);
    }
}
