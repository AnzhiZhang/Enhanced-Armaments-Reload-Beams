package com.example.enhancedarmamentsreloadbeams;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import java.util.Objects;

@Mod("enhancedarmamentsreloadbeams")
public class EnhancedArmamentsReloadBeams {
    final String[] raritiesMap = {"0xFFFFFF", "0xFFFFFF", "0x00AA00", "0x55FFFF", "0xAA00AA", "0xFFAA00", "0xFF55FF"};

    public EnhancedArmamentsReloadBeams() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ItemTossEvent event) {
        int rarity = Objects.requireNonNull(event.getEntityItem().getItem().getTag()).getInt("RARITY");
        if (0 <= rarity && rarity <= 6) {
            event.getEntityItem().getItem().getTag().putString("lootbeams.color", raritiesMap[rarity]);
        }
    }
}
