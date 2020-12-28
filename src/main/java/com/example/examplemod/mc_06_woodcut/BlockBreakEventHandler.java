package com.example.examplemod.mc_06_woodcut;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakEventHandler {

    //インスタンス化
    DateItemR instansR = new DateItemR();
    DateItemH instansH = new DateItemH();


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


        breakBlock(event.getWorld(),event.getPos());

        //現在やろうとしている処理（メソッド）をキャンセルするという処理
        //今回はブロックを壊さないようにする処理
        //ブロックを破壊する（ブロックを消す＆ドロップを生成することをやめる）
        event.setCanceled(true);




    }

    /*ブロックを消してItemドロップ化*/

    private void destroyBlock(World world,BlockPos pos){
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();

        if(block != Blocks.LOG && block != Blocks.LOG2 && block != Blocks.LEAVES2 && block != Blocks.LEAVES){
            return;
        }

        block.dropBlockAsItem(world , pos , blockState,0);
        world.setBlockToAir(pos);

        //テスト出力
        System.out.println(instansR.Ritems);
        System.out.println(instansH.Hitems);
    }

    private void breakBlock(World world, BlockPos pos){
        for (int y = 0; y < instansH.Hitems;y++){
            for(int x = -instansR.Ritems;x < instansR.Ritems+1;x++){
                for(int z = -instansR.Ritems;z< instansR.Ritems+1;z++){
                    destroyBlock(world, pos.add(x,y,z));
                }
            }
        }
    }




}
