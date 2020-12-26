package com.example.examplemod.mc_031_fortuneblock;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFortune extends Block {

    public BlockFortune(){
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("fortuneblock");
        setUnlocalizedName(ExampleMod.MODID + "_block_fortune");
        setHardness(30);

    }

    @Override
    //この関数はブロックを左クリックしたときに呼び出される
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn){
        super.onBlockClicked(worldIn,pos,playerIn);

        //変数の宣言
        String message = "";
        //ランダムクラスのインスタンス化
        Random random = new Random();
        //乱数の取得
        int randomNumber = random.nextInt(5);

        switch (randomNumber){
            case 0 :
                message = "大当たり";
                break;
            case 1:
                message = "あたり";
                break;
            case 2:
                message = "~~~~~";
                break;
            case 3:
                message = "ハズレ";
                break;
            case 4:
                message = "悲しい";
                break;
        }

        //強制大当たり出力
        //プレイヤーが持っているアイテム情報を取得する
        ItemStack heldItem = playerIn.getHeldItemMainhand();
        //アイテムを持っていたら
        if (heldItem != null){
            //アイテムが金りんごだったら
            if(heldItem.getItem() == Items.GOLDEN_APPLE){
                message = "強制大当たり";
            }
        }

        if(!worldIn.isRemote){
            //チャット欄にメッセージを出すための処理　緑文字は出力する内容
            playerIn.addChatComponentMessage(new TextComponentString(message));
        }
    }
}
