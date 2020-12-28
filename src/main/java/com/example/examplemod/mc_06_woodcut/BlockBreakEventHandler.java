package com.example.examplemod.mc_06_woodcut;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakEventHandler {
    private static final int MAX_RADIUS = 3;
    private static final int MAX_HEIGHT = 30;

    @SubscribeEvent
    //ブロックを壊そうとしたときにメソッドが起動する。
    public void onBlockBreak(BlockEvent.BreakEvent event){

        /*何もしないゾーン（nullチェック）*/

        //ブロックを壊そうとしたプレイヤーが居ない時
        EntityPlayer player = event.getPlayer();
        if(player == null){
            return;
        }

        //今持っているItem情報が何も持っていない時
        if(player.getHeldItemMainhand() == null){
            return;
        }

        //斧のどれかではない時
        Item item = player.getHeldItemMainhand().getItem();
        if( item != Items.WOODEN_AXE &&
            item != Items.STONE_AXE &&
            item != Items.IRON_AXE &&
            item != Items.GOLDEN_AXE &&
            item != Items.DIAMOND_AXE){

            return;
        }


        /*
//        clickedBlock　クリックしたブロック
//        Blocks.LOG マイクラ内での木ブロック
//        Blocks.LOG2     〃
        */

        //もし壊そうとしたブロックが木ブロックじゃなかったら
        Block clickedBlock = event.getState().getBlock();
        if(clickedBlock != Blocks.LOG && clickedBlock != Blocks.LOG2){
            return;
        }


//        breakBlock(event.getWorld(),event.getPos());

        //現在やろうとしている処理（メソッド）をキャンセルするという処理
        //今回はブロックを壊さないようにする処理
        //ブロックを破壊する（ブロックを消す＆ドロップを生成することをやめる）
        event.setCanceled(true);


        /*ブロックを消してItemドロップ化*/



    }




}
