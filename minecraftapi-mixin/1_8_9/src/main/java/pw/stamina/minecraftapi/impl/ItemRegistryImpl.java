package pw.stamina.minecraftapi.impl;

import net.minecraft.util.ResourceLocation;
import pw.stamina.minecraftapi.item.Item;
import pw.stamina.minecraftapi.item.ItemRegistry;

public enum ItemRegistryImpl implements ItemRegistry {
    INSTANCE;

    @Override
    public Item getRegisteredItem(String name) {
        return (Item) net.minecraft.item.Item.itemRegistry.getObject(new ResourceLocation(name));
    }
}
