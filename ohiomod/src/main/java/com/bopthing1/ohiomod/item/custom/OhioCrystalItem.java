package com.bopthing1.ohiomod.item.custom;

import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.extensions.IForgeItem;

public class OhioCrystalItem extends Item {
    public OhioCrystalItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos posClicked = new BlockPos(0, 0, 0);
        Player player = pContext.getPlayer();
        Float prevSpeed = player.getSpeed();
        System.out.println(prevSpeed);

        if (pContext.getLevel().isClientSide()) {
            posClicked = pContext.getClickedPos();
        }

        if (!pContext.getLevel().isClientSide()) {
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (plr) -> plr.broadcastBreakEvent(plr.getUsedItemHand()));
            player.giveExperiencePoints(2);

            player.animationSpeed = 1000.0F;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            player.setSpeed(prevSpeed);
        }

        return super.useOn(pContext);
    }


}


