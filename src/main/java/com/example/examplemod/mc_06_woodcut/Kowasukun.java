package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class Kowasukun extends ItemPickaxe {


    static boolean kowasu = true;
    static int select = 0;


    public Kowasukun(){
        super(EnumHelper.addToolMaterial("Kowasukun", 4,200,300.0f,1.0f,22));
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName("kowasukun");
        setUnlocalizedName(ExampleMod.MODID + "_kowasukun");
    }

    @Override
    //右クリックをした時
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        //Item量を出力
        select += 1;
        //呼び出された回数が二回目なら
        if(select == 2) {

            if(kowasu){
                kowasu = false;
            }else{
                kowasu = true;
            }
            //出力
            player.addChatComponentMessage(new TextComponentString("動作:" + kowasu));
            select = 0;
        }


        return super.onItemRightClick(stack,world,player,hand);

    }








}
