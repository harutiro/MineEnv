package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class DateBlock2 extends Block{

    public static Item Item = null;


    public DateBlock2(){

        //素材の種類を決める
        super(Material.ROCK);
        //登録するタブを選択
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        //登録に必要な名前を決める
        setRegistryName("DateBlock2");
        //ブロックの名前を決める
        setUnlocalizedName(ExampleMod.MODID + "_DateBlock2");
        //Blockの硬さ
        setHardness(300);
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player){
        super.onBlockClicked(world, pos, player);


        //Blockの座標を受け取る
        Item = player.getHeldItemMainhand().getItem();





        //出力
        player.addChatComponentMessage(new TextComponentString( Item + "を保存しました"));


    }

    public static final AxisAlignedBB Block_COLLISION = new AxisAlignedBB(0,0,0,1,0.9,1);

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity){
        DateBlock instansDateBlock = new DateBlock();
        DateItemH instansDateItemH = new DateItemH();
        DateItemR instansDateItemR = new DateItemR();
        DateItemHiretu instansDateItemHiretu = new DateItemHiretu();
        Kowasukun instansKowasukun = new Kowasukun();

        entity.addChatMessage(new TextComponentString( "========================================================="));
        entity.addChatMessage(new TextComponentString( "ツール："+Item));
        entity.addChatMessage(new TextComponentString( "選択："+instansDateItemHiretu.hairetu));
        entity.addChatMessage(new TextComponentString( "ブロック："+instansDateBlock.kowasuBlock[instansDateItemHiretu.hairetu]));
        entity.addChatMessage(new TextComponentString( "高さ："+instansDateItemH.Hitems));
        entity.addChatMessage(new TextComponentString( "半径："+instansDateItemR.Ritems));
        entity.addChatMessage(new TextComponentString( "壊すかどうか："+ Kowasukun.kowasu));
        entity.addChatMessage(new TextComponentString( "========================================================="));
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState,World worldln,BlockPos pos){
        return Block_COLLISION;
    }

}
