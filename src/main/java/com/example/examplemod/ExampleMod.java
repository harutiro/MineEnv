package com.example.examplemod;

import com.example.examplemod.mc_02_myblock.MyBlock;
import com.example.examplemod.mc_031_fortuneblock.BlockFortune;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
        public class ExampleMod {
            public static final String MODID = "examplemod";
            public static final String VERSION = "1.0";

            //MC-02 : myblock
            //= new クラス名
            public static Block blockMyBlock = new MyBlock();

            //MC-031 : fortuneblock
            public static Block blockFortune = new BlockFortune();

            @EventHandler
            public void preInit(FMLPreInitializationEvent event) {
                boolean isClient = event.getSide().isClient();

                //ここから書いていく
                registerBlock(blockMyBlock, isClient);
                registerBlock(blockFortune, isClient);


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {



    }

    // ======================================================================================================
    // ここから下はいじらないよ！

    private void registerBlock(Block block, boolean isClient) {
        ItemBlock itemBlockInput = new ItemBlock(block);

        GameRegistry.register(block);
        GameRegistry.register(itemBlockInput, block.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }
    }

    private void registerItem(Item item, boolean isClient) {
        GameRegistry.register(item);
        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelName);
        }
    }
}
