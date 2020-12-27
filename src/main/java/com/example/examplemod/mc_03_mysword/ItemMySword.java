package com.example.examplemod.mc_03_mysword;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.EnumHelper;

public class ItemMySword extends ItemSword {

    public ItemMySword(){
        super(EnumHelper.addToolMaterial("my_sword",4,200,16.0f,1.0f,22));
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName("my_sword");
        setUnlocalizedName(ExampleMod.MODID + "_my_sword");

    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){
        if(stack == null){
            return true;
        }
        if(!(attacker instanceof EntityPlayer)){
            return true;
        }
//        //相手に、そのポーションの効果を与える
//        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,1200,0));

//        //相手をタカイタカイする
//        target.setPosition(target.posX,target.posY+20,target.posZ);

//        //敵を燃やす
//        target.setFire(600);


        //場所指定
        BlockPos pos = new BlockPos(target.posX+1,target.posY+1,target.posZ);
        //指定場所にブロックを置く
        target.worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());

        pos = new BlockPos(target.posX-1,target.posY+1,target.posZ);
        target.worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());

        pos = new BlockPos(target.posX,target.posY+1,target.posZ+1);
        target.worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());

        pos = new BlockPos(target.posX,target.posY+1,target.posZ-1);
        target.worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());


        return true;
    }

}
