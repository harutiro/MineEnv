package com.example.examplemod.resipi;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class myresipi {

    public static void kuri(){
        NBTTagCompound creeperId = new NBTTagCompound();
        creeperId.setString("id","Creeper");
        ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
        creeperSpawnEgg.setTagInfo("EntityTag",creeperId);

        //クリーパー
        GameRegistry.addRecipe(creeperSpawnEgg,
                " A ",
                "CBC",
                "CBC",

                'A', new ItemStack(Items.SKULL,1,4),
                'B', new ItemStack(Blocks.TNT),
                'C', new ItemStack(Items.GUNPOWDER)

        );
    }
}
