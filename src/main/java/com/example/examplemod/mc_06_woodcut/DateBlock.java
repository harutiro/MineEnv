package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class DateBlock extends Block{

//    public static Block Block = Blocks.LOG;

    //Block保存配列
    public static Block kowasuBlock[] = new Block[11];

    public DateBlock (){

        //素材の種類を決める
        super(Material.ROCK);
        //登録するタブを選択
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        //登録に必要な名前を決める
        setRegistryName("DateBlock");
        //ブロックの名前を決める
        setUnlocalizedName(ExampleMod.MODID + "_DateBlock");
        //Blockの硬さ
        setHardness(300);
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player){
        super.onBlockClicked(world, pos, player);

        //インスタンス
        DateItemHiretu instansHairetu = new DateItemHiretu();

        //Blockの座標を受け取る
        BlockPos posNado = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
        //受け取ったPOSの座標のBlockステータスを受け取る
        IBlockState blockState = world.getBlockState(posNado);
        //Blockの種類を受け取る
        kowasuBlock[instansHairetu.hairetu] = blockState.getBlock();

        //出力
        player.addChatComponentMessage(new TextComponentString(  instansHairetu.hairetu+"番で"+ kowasuBlock[instansHairetu.hairetu] + "を保存しました"));


    }
}
