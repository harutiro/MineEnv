package com.example.examplemod.mc_04_rainbowblock;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRainbow extends Block {

    private static final PropertyInteger COLOR = PropertyInteger.create("color",0,6);

    public BlockRainbow(){
        super (Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        //ItemID
        setRegistryName("rainbow");
        //ブロック表示名
        setUnlocalizedName(ExampleMod.MODID + "_block_rainbow");
        //ブロックの硬さ
        setHardness(300);

        setDefaultState(blockState.getBaseState().withProperty(COLOR,0));

    }

    //七種類のブロックの色を保存じておくコード
    @Override
    public IBlockState getStateFromMeta(int meta){
        return getDefaultState().withProperty(COLOR,meta);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(COLOR);
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this,COLOR);
    }

    @Override
    //ブロックを左クリックしたときに
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn){
//        //コンソールに出力される
//        System.out.println("Hello");

        //ブロックを叩くたびに色が変わる
        IBlockState blockState = worldIn.getBlockState(pos);
        int color = blockState.getValue(COLOR);
        color++;
        if(color >= 7){
            color = 0;
        }
        worldIn.setBlockState(pos,blockState.withProperty(COLOR,color));


    }
}
