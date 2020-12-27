package com.example.examplemod.mc_033_hipotion;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHiPotion extends ItemFood {

    public ItemHiPotion(){

        //super(回復量,空腹になるまでの時間,狼が食べれるか？)
        super(1,0.5f,false);
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("hi_potion");
        setUnlocalizedName(ExampleMod.MODID + "_hi_potion");
    }

    @Override
    //食べ終わったときに呼ばれるメソッド
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
        super.onFoodEaten(stack, world, player);

        /*具体的なポーション効果*/

        //効果種類
        Potion potion = MobEffects.SPEED;
        //持続時間
        int duration = 200;
        //ポーションのレベル
        int level = 0;



        /*アイテム量取得*/

        //Itemの数で初期化される。
        int size = stack.stackSize;
        if(size >= 20){
            potion = MobEffects.POISON;
            duration = 600;
            level = 2;
        }else if(size >= 15){
            potion = MobEffects.REGENERATION;
            duration = 1200;
            level = 1;
        }else if(size >= 10){
            duration = 600;
            level = 1;
        }


        //ポーションのインスタンス化
        PotionEffect effect = new PotionEffect(potion,duration,level);
        //プレイヤーに効果を与える
        player.addPotionEffect(effect);
    }
}
