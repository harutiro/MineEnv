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

public class BlockBreakEventHandler extends DateBlock {
    EntityPlayer player;


    @SubscribeEvent
    //ブロックを壊そうとしたときにメソッドが起動する。
    public void onBlockBreak(BlockEvent.BreakEvent event){

        //インスタンス化
        Item instanskowasu = new Kowasukun();



        /*何もしないゾーン（nullチェック）*/

        //ブロックを壊そうとしたプレイヤーが居ない時
        player = event.getPlayer();

        if(player == null){
            return;
        }

        //今持っているItem情報が何も持っていない時
        if(player.getHeldItemMainhand() == null){
            return;
        }

        //斧のどれかではない時
        Item item = player.getHeldItemMainhand().getItem();
        if( item != instanskowasu){
            System.out.println(instanskowasu);
            System.out.println(item);

            return;
        }


        /*
//        clickedBlock　クリックしたブロック
//        Blocks.LOG マイクラ内での木ブロック
//        Blocks.LOG2     〃
        */

        //もし壊そうとしたブロックが木ブロックじゃなかったら
        Block clickedBlock = event.getState().getBlock();
        if(clickedBlock != DateBlock.Block){
            System.out.println("判定のところ"+ DateBlock.Block);
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

//        DateBlock instansBlock = new DateBlock();

        //そのBlock出ないときに何もしないで返す。
        if(block != DateBlock.Block){
            System.out.println("壊すところ" + DateBlock.Block);
            return;
        }

        block.dropBlockAsItem(world , pos , blockState,0);
        world.setBlockToAir(pos);


    }

    private void breakBlock(World world, BlockPos pos){
        //インスタンス化
        DateItemH instansH = new DateItemH();
        DateItemR instansR = new DateItemR();

        Kowasukun instanskowasu = new Kowasukun();

        //テスト出力
        System.out.println(instansR.Ritems);
        System.out.println(instansH.Hitems);

        if(instansR.Ritems == 0 && instansH.Hitems == 1 || instanskowasu.kowasu){
            destroyBlock(world, pos.add(0,0,0));
            return;
        }

        if(player.posY+1 < pos.getY() ){

            //上を見たときに動くコード

            for (int y = 0; y < instansH.Hitems;y++){
                for(int x = -instansR.Ritems;x < instansR.Ritems+1;x++){
                    for(int z = -instansR.Ritems;z< instansR.Ritems+1;z++){
                        destroyBlock(world, pos.add(x,y,z));
                    }
                }
            }
            return;




        }else if(player.posY < pos.getY()){
            //X軸Y軸的に切り替わるやつ
            if(player.posX+2 < pos.getX() || pos.getX()<player.posX-2){
                //X軸側にいる時
                for (int y = 0; y < instansH.Hitems;y++){
                    for(int x = -instansR.Ritems;x < instansR.Ritems+1;x++){
                        for(int z = -instansR.Ritems;z< instansR.Ritems+1;z++){
                            int posx = y;
                            int posy = x;
                            int posz = z;



                            destroyBlock(world, pos.add(posx,posy,posz));
                        }
                    }
                }
                return;

            }else{
                //Y軸側にいる時
                for (int y = 0; y < instansH.Hitems;y++){
                    for(int x = -instansR.Ritems;x < instansR.Ritems+1;x++){
                        for(int z = -instansR.Ritems;z< instansR.Ritems+1;z++){
                            int posx = z;
                            int posy = x;
                            int posz = y;



                            destroyBlock(world, pos.add(posx,posy,posz));
                        }
                    }
                }
                return;

            }


        }else{
            //下を見ている時
            for (int y = 0; y > -instansH.Hitems;y--){
                for(int x = -instansR.Ritems;x < instansR.Ritems+1;x++){
                    for(int z = -instansR.Ritems;z< instansR.Ritems+1;z++){
                        destroyBlock(world, pos.add(x,y,z));
                    }
                }
            }
            return;
        }



    }




}
