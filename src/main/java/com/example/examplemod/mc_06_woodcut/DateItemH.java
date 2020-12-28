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

public class DateItemH extends Item {

    int Hitems = 30;

    public DateItemH(){
        super();
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("dateItemH");
        setUnlocalizedName(ExampleMod.MODID + "_date_itemH");
    }

    /*DateItemHの個数による範囲指定*/
    @Override
    //右クリックをした時
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        //Itemの個数を代入
        Hitems = stack.stackSize;


        player.addChatComponentMessage(new TextComponentString("高さ:" + Hitems));

        return super.onItemRightClick(stack,world,player,hand);

    }




}
