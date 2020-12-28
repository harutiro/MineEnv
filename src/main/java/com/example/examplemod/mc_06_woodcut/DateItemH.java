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

public class DateItemH extends Item {
    //高さ指定
    static int Hitems = 1;
    //何回呼び出されたか
    static int select = 0;

    public DateItemH(){
        super();
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("dateItemH");
        setUnlocalizedName(ExampleMod.MODID + "_date_itemH");
    }

    /*DateItemHの個数による範囲指定*/
    @Override
    //右クリックをした時
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
//        //Itemの個数を代入
//        Hitems = stack.stackSize;



        select += 1;
        //呼び出された回数が二回目なら
        if(select == 2) {
            //高さを一つ大きくする
            Hitems++;
            //出力
            player.addChatComponentMessage(new TextComponentString("高さ:" + Hitems));
            //テスト出力
            System.out.println(Hitems);

            //十以上なら初期化
            if (Hitems >= 10) {
                Hitems = 0;
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
