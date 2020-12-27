package com.example.examplemod.mc_032_magicstick;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemMagicStick extends ItemSword {

    public ItemMagicStick(){
        super (EnumHelper.addToolMaterial(
                "magic_stick",
                4,
                200,
                16.0f,
                1.0f,
                22

        ));

        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName("magic_stick");
        setUnlocalizedName(ExampleMod.MODID + "_magic_stick");
    }

    @Override
    //攻撃するときに動くメソッド
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){

//        //燃やしたい秒数を代入
//        int time = 2;
//        //燃やすエフェクトをかける
//        attacker.setFire(time);

        //インスタンスを入れる？？
        World world = target.worldObj;
        //攻撃された人の座標を取得する
        BlockPos spawnPos = target.getPosition();

        //変数名エンティティを作る
        Entity entity;
        //もし攻撃した相手が村人だったら、
        if(target.getClass() == EntityVillager.class){
            //エンティティにゾンビクラスをインスタンス化する
            entity = new EntityZombie(world);
            //攻撃した場所を指定する
            entity.setPosition(spawnPos.getX(), spawnPos.getY(),spawnPos.getZ());
        }else {
            entity = new EntityPig(world);
            entity.setPosition(spawnPos.getX(), spawnPos.getY(),spawnPos.getZ());
        }
        //セットしたやつを呼び出す
        world.spawnEntityInWorld(entity);

        //相手を倒すコード
        target.setDead();

        return super.hitEntity(stack,target,attacker);

    }


}
