package com.example.examplemod;

import com.example.examplemod.mc_02_myblock.MyBlock;
import com.example.examplemod.mc_031_fortuneblock.BlockFortune;
import com.example.examplemod.mc_032_magicstick.ItemMagicStick;
import com.example.examplemod.mc_033_hipotion.ItemHiPotion;
import com.example.examplemod.mc_03_mysword.ItemMySword;
import com.example.examplemod.mc_04_rainbowblock.BlockRainbow;
import com.example.examplemod.mc_06_woodcut.BlockBreakEventHandler;
import com.example.examplemod.mc_06_woodcut.DateItemH;
import com.example.examplemod.mc_06_woodcut.DateItemR;
import com.example.examplemod.resipi.myresipi;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
        public class ExampleMod {
            public static final String MODID = "examplemod";
            public static final String VERSION = "1.0";


            //クリエイティブタブ追加
            //最後の””は、タブのID名になる
            public static CreativeTabs moreToolTab = new CreativeTabs("moreToolTab") {
                @Override
                public Item getTabIconItem() {
                    //ここのItemStack()の中身はここでのItemもしくはBlockインスタンスを入れる
                    return new ItemStack(blockMyBlock).getItem();
                }
            };//セミコロン忘れずに



            /*ブロック登録の準備*/

            //MC-02 : myblock
            public static Block blockMyBlock = new MyBlock().setCreativeTab(moreToolTab);

            //MC-031 : fortuneblock
            public static Block blockFortune = new BlockFortune().setCreativeTab(moreToolTab);

            //MC-032 : magicstick
            public static Item itemMagicStick = new ItemMagicStick().setCreativeTab(moreToolTab);

            //MC-033 : hipotion
            public  static  Item itemHiPotion = new ItemHiPotion().setCreativeTab(moreToolTab);

            //mc-03 :myItem
            public static  Item itemMySword = new ItemMySword().setCreativeTab(moreToolTab);

            //mc-04:rainboow
            public static Block blockRainbow = new BlockRainbow().setCreativeTab(moreToolTab);

            //mc-06:woodcut
            public static Item itemDateItemH = new DateItemH().setCreativeTab(moreToolTab);
            public static Item itemDateItemR = new DateItemR().setCreativeTab(moreToolTab);


            @EventHandler
            public void preInit(FMLPreInitializationEvent event) {
                boolean isClient = event.getSide().isClient();

                //ブロックを登録する関数を呼び出している
                registerBlock(blockMyBlock, isClient);
                registerBlock(blockFortune, isClient);
                registerItem(itemMagicStick,isClient);
                registerItem(itemHiPotion,isClient);
                registerItem(itemMySword,isClient);
                registerBlock(blockRainbow,isClient);
                registerItem(itemDateItemH,isClient);
                registerItem(itemDateItemR,isClient);

                //レシピ追加系
                registerRecipe();


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
                //木こりMOD
                registerWoodCut();







    }

    //ブロックを叩いたときに、BlockBreakEventHandlewクワスのコードが呼ばれる
    private void registerWoodCut(){
                MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());
    }




    /*クラフトレシピ追加*/

    private void registerRecipe(){

        myresipi.kuri();

//        NBTTagCompound creeperId = new NBTTagCompound();
//        creeperId.setString("id","Creeper");
//        ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
//        creeperSpawnEgg.setTagInfo("EntityTag",creeperId);
//
//        //クリーパー
//        GameRegistry.addRecipe(creeperSpawnEgg,
//                " A ",
//                "CBC",
//                "CBC",
//
//                'A', new ItemStack(Items.SKULL,1,4),
//                'B', new ItemStack(Blocks.TNT),
//                'C', new ItemStack(Items.GUNPOWDER)
//
//                );
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
