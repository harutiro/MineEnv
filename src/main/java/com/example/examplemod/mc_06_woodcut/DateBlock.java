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

    static Block Block = Blocks.LOG;
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

        BlockPos posNado = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());

        IBlockState blockState = world.getBlockState(posNado);
        Block = blockState.getBlock();

        //出力
        player.addChatComponentMessage(new TextComponentString( Block + "を保存しました"));


    }
}
