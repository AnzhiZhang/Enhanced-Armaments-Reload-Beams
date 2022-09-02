package com.example.enhancedarmamentsreloadbeams;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;

@Mod("enhancedarmamentsreloadbeams")
public class EnhancedArmamentsReloadBeams {
    final String[] raritiesMap = {"0xFFFFFF", "0xFFFFFF", "0x00AA00", "0x55FFFF", "0xAA00AA", "0xFFAA00", "0xFF55FF"};

    public EnhancedArmamentsReloadBeams() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onItemTossEvent(ItemTossEvent event) {
        CompoundTag tags = event.getEntityItem().getItem().getTag();
        System.out.println(tags);
        if (tags != null) {
            int rarity = tags.getInt("RARITY");
            System.out.println(rarity);
            if (0 <= rarity && rarity <= 6) {
                tags.putString("lootbeams.color", raritiesMap[rarity]);
            }
        }
    }
}
