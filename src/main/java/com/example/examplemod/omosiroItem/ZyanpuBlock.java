package com.example.examplemod.omosiroItem;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ZyanpuBlock extends Block {
    public ZyanpuBlock(){

        //素材の種類を決める
        super(Material.CARPET);
        //登録するタブを選択
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        //登録に必要な名前を決める
        setRegistryName("zyanpuBlock");
        //ブロックの名前を決める
        setUnlocalizedName(ExampleMod.MODID + "_zyanpu_block");
    }

    public static final AxisAlignedBB Block_COLLISION = new AxisAlignedBB(0,0,0,1,0.9,1);

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity){
        //相手をタカイタカイする
        entity.setPosition(entity.posX,entity.posY+5,entity.posZ);
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState,World worldln,BlockPos pos){
        return Block_COLLISION;
    }

}
