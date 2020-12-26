package com.example.examplemod.mc_02_myblock;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

//パッケージを指定する。
//候補が出たときは、net.minecraft.OOを選ぶ
public class MyBlock extends Block {
    public MyBlock(){

        //素材の種類を決める
        super(Material.ROCK);
        //登録するタブを選択
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        //登録に必要な名前を決める
        setRegistryName("myblock");
        //ブロックの名前を決める
        setUnlocalizedName(ExampleMod.MODID + "_myblock");

    }
}
