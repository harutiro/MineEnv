package com.example.examplemod.resipi;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class myresipi {

    public static void kuri(){
        //クリーパーの卵を複製して新しいものを作る
        NBTTagCompound creeperId = new NBTTagCompound();
        //
        creeperId.setString("id","Creeper");
        //新しく作るItemを指定する
        ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
        //クリーパータグをクラフトを
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
