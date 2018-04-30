package pw.stamina.minecraftapi.impl;

import net.minecraft.util.ResourceLocation;
import pw.stamina.minecraftapi.item.Item;
import pw.stamina.minecraftapi.item.ItemRegistry;

public enum ItemRegistryImpl implements ItemRegistry {
    INSTANCE;

    @Override
    public Item getRegisteredItem(String name) {
        net.minecraft.item.Item item = net.minecraft.item.Item.REGISTRY.getObject(new ResourceLocation(name));

        if (item == null) {
            throw new IllegalStateException("Invalid Item requested: " + name);
        } else {
            return (Item) item;
        }
    }
}
