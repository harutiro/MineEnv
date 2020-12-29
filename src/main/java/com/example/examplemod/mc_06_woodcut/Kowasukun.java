package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
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

        select += 1;
        //呼び出された回数が二回目なら
        if(select == 2) {

            if(kowasu){
                kowasu = false;

                DateBlock instansDateBlock = new DateBlock();
                DateItemH instansDateItemH = new DateItemH();
                DateItemR instansDateItemR = new DateItemR();
                DateItemHiretu instansDateItemHiretu = new DateItemHiretu();
                Kowasukun instansKowasukun = new Kowasukun();
                DateBlock2 instansDetaBlock2 = new DateBlock2();

                player.addChatMessage(new TextComponentString( "========================================================="));
                player.addChatMessage(new TextComponentString( "ツール："+instansDetaBlock2.Item));
                player.addChatMessage(new TextComponentString( "選択："+instansDateItemHiretu.hairetu));
                player.addChatMessage(new TextComponentString( "ブロック："+instansDateBlock.kowasuBlock[instansDateItemHiretu.hairetu]));
                player.addChatMessage(new TextComponentString( "高さ："+instansDateItemH.Hitems));
                player.addChatMessage(new TextComponentString( "半径："+instansDateItemR.Ritems));
                player.addChatMessage(new TextComponentString( "壊すかどうか："+ Kowasukun.kowasu));
                player.addChatMessage(new TextComponentString( "========================================================="));


            }else{
                kowasu = true;
            }
            //出力
            player.addChatComponentMessage(new TextComponentString("ロック:" + kowasu));
            select = 0;
        }


        return super.onItemRightClick(stack,world,player,hand);

    }








}
