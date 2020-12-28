package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class DateItemR extends Item {
    int Ritems = 3;

    public DateItemR(){
        super();
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("dateItemR");
        setUnlocalizedName(ExampleMod.MODID + "_date_itemR");
    }

    /*DateItemRの個数による範囲指定*/
    @Override
    //右クリックをした時
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        //Itemの量を代入
        Ritems = stack.stackSize;
        //Item量を出力
        player.addChatComponentMessage(new TextComponentString("半径:" + Ritems));

        return super.onItemRightClick(stack,world,player,hand);

    }

}
