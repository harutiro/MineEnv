package com.example.examplemod.mc_06_woodcut;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class DateItemHiretu extends Item {
    //高さ指定
    static int hairetu = 1;
    //何回呼び出されたか
    static int select = 0;

    public DateItemHiretu(){
        super();
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("dateItemHiretu");
        setUnlocalizedName(ExampleMod.MODID + "_date_itemHiretu");
    }

    /*DateItemHの個数による範囲指定*/
    @Override
    //右クリックをした時
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
//        //Itemの個数を代入
//        Hitems = stack.stackSize;

        DateBlock instansDateBlock = new DateBlock();





        select += 1;
        //呼び出された回数が二回目なら
        if(select == 2) {
            //高さを一つ大きくする
            hairetu++;
            //出力
            player.addChatComponentMessage(new TextComponentString("番号指定:" + hairetu + "["+ instansDateBlock.kowasuBlock[hairetu]+"]"));
            //テスト出力
            System.out.println(hairetu);

            //十以上なら初期化
            if (hairetu >= 10) {
                hairetu = 0;
            }
            select = 0;
        }






        return super.onItemRightClick(stack,world,player,hand);

    }








//
//    private int num = 0;
//
//    public void SetNum(int _num){num = _num;}
//
//    public int GetNum() {return num;}
//
//    SetNum(1);
//    GetNum()
}
