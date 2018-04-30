/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.item;

import pw.stamina.minecraftapi.MinecraftApi;

public final class Items {

    public static final Item
            AIR,
            IRON_SHOVEL,
            IRON_PICKAXE,
            IRON_AXE,
            FLINT_AND_STEEL,
            APPLE,
            BOW,
            ARROW,
            SPECTRAL_ARROW,
            TIPPED_ARROW,
            COAL,
            DIAMOND,
            IRON_INGOT,
            GOLD_INGOT,
            IRON_SWORD,
            WOODEN_SWORD,
            WOODEN_SHOVEL,
            WOODEN_PICKAXE,
            WOODEN_AXE,
            STONE_SWORD,
            STONE_SHOVEL,
            STONE_PICKAXE,
            STONE_AXE,
            DIAMOND_SWORD,
            DIAMOND_SHOVEL,
            DIAMOND_PICKAXE,
            DIAMOND_AXE,
            STICK,
            BOWL,
            MUSHROOM_STEW,
            GOLDEN_SWORD,
            GOLDEN_SHOVEL,
            GOLDEN_PICKAXE,
            GOLDEN_AXE,
            STRING,
            FEATHER,
            GUNPOWDER,
            WOODEN_HOE,
            STONE_HOE,
            IRON_HOE,
            DIAMOND_HOE,
            GOLDEN_HOE,
            WHEAT_SEEDS,
            WHEAT,
            BREAD,
            LEATHER_HELMET,
            LEATHER_CHESTPLATE,
            LEATHER_LEGGINGS,
            LEATHER_BOOTS,
            CHAINMAIL_HELMET,
            CHAINMAIL_CHESTPLATE,
            CHAINMAIL_LEGGINGS,
            CHAINMAIL_BOOTS,
            IRON_HELMET,
            IRON_CHESTPLATE,
            IRON_LEGGINGS,
            IRON_BOOTS,
            DIAMOND_HELMET,
            DIAMOND_CHESTPLATE,
            DIAMOND_LEGGINGS,
            DIAMOND_BOOTS,
            GOLDEN_HELMET,
            GOLDEN_CHESTPLATE,
            GOLDEN_LEGGINGS,
            GOLDEN_BOOTS,
            FLINT,
            PORKCHOP,
            COOKED_PORKCHOP,
            PAINTING,
            GOLDEN_APPLE,
            SIGN,
            OAK_DOOR,
            SPRUCE_DOOR,
            BIRCH_DOOR,
            JUNGLE_DOOR,
            ACACIA_DOOR,
            DARK_OAK_DOOR,
            BUCKET,
            WATER_BUCKET,
            LAVA_BUCKET,
            MINECART,
            SADDLE,
            IRON_DOOR,
            REDSTONE,
            SNOWBALL,
            BOAT,
            SPRUCE_BOAT,
            BIRCH_BOAT,
            JUNGLE_BOAT,
            ACACIA_BOAT,
            DARK_OAK_BOAT,
            LEATHER,
            MILK_BUCKET,
            BRICK,
            CLAY_BALL,
            REEDS,
            PAPER,
            BOOK,
            SLIME_BALL,
            CHEST_MINECART,
            FURNACE_MINECART,
            EGG,
            COMPASS,
            FISHING_ROD,
            CLOCK,
            GLOWSTONE_DUST,
            FISH,
            COOKED_FISH,
            DYE,
            BONE,
            SUGAR,
            CAKE,
            BED,
            REPEATER,
            COOKIE,
            FILLED_MAP,
            SHEARS,
            MELON,
            PUMPKIN_SEEDS,
            MELON_SEEDS,
            BEEF,
            COOKED_BEEF,
            CHICKEN,
            COOKED_CHICKEN,
            MUTTON,
            COOKED_MUTTON,
            RABBIT,
            COOKED_RABBIT,
            RABBIT_STEW,
            RABBIT_FOOT,
            RABBIT_HIDE,
            ROTTEN_FLESH,
            ENDER_PEARL,
            BLAZE_ROD,
            GHAST_TEAR,
            GOLD_NUGGET,
            NETHER_WART,
            POTIONITEM,
            SPLASH_POTION,
            LINGERING_POTION,
            GLASS_BOTTLE,
            DRAGON_BREATH,
            SPIDER_EYE,
            FERMENTED_SPIDER_EYE,
            BLAZE_POWDER,
            MAGMA_CREAM,
            BREWING_STAND,
            CAULDRON,
            ENDER_EYE,
            SPECKLED_MELON,
            SPAWN_EGG,
            EXPERIENCE_BOTTLE,
            FIRE_CHARGE,
            WRITABLE_BOOK,
            WRITTEN_BOOK,
            EMERALD,
            ITEM_FRAME,
            FLOWER_POT,
            CARROT,
            POTATO,
            BAKED_POTATO,
            POISONOUS_POTATO,
            MAP,
            GOLDEN_CARROT,
            SKULL,
            CARROT_ON_A_STICK,
            NETHER_STAR,
            PUMPKIN_PIE,
            FIREWORKS,
            FIREWORK_CHARGE,
            ENCHANTED_BOOK,
            COMPARATOR,
            NETHERBRICK,
            QUARTZ,
            TNT_MINECART,
            HOPPER_MINECART,
            ARMOR_STAND,
            IRON_HORSE_ARMOR,
            GOLDEN_HORSE_ARMOR,
            DIAMOND_HORSE_ARMOR,
            LEAD,
            NAME_TAG,
            COMMAND_BLOCK_MINECART,
            RECORD_13,
            RECORD_CAT,
            RECORD_BLOCKS,
            RECORD_CHIRP,
            RECORD_FAR,
            RECORD_MALL,
            RECORD_MELLOHI,
            RECORD_STAL,
            RECORD_STRAD,
            RECORD_WARD,
            RECORD_11,
            RECORD_WAIT,
            PRISMARINE_SHARD,
            PRISMARINE_CRYSTALS,
            BANNER,
            END_CRYSTAL,
            SHIELD,
            ELYTRA,
            CHORUS_FRUIT,
            CHORUS_FRUIT_POPPED,
            BEETROOT_SEEDS,
            BEETROOT,
            BEETROOT_SOUP,
            TOTEM_OF_UNDYING,
            SHULKER_SHELL,
            IRON_NUGGET,
            KNOWLEDGE_BOOK;

    static {
        ItemRegistry registry = MinecraftApi.getAdapter().getItemRegistry();

        AIR = registry.getRegisteredItem("air");
        IRON_SHOVEL = registry.getRegisteredItem("iron_shovel");
        IRON_PICKAXE = registry.getRegisteredItem("iron_pickaxe");
        IRON_AXE = registry.getRegisteredItem("iron_axe");
        FLINT_AND_STEEL = registry.getRegisteredItem("flint_and_steel");
        APPLE = registry.getRegisteredItem("apple");
        BOW = registry.getRegisteredItem("bow");
        ARROW = registry.getRegisteredItem("arrow");
        SPECTRAL_ARROW = registry.getRegisteredItem("spectral_arrow");
        TIPPED_ARROW = registry.getRegisteredItem("tipped_arrow");
        COAL = registry.getRegisteredItem("coal");
        DIAMOND = registry.getRegisteredItem("diamond");
        IRON_INGOT = registry.getRegisteredItem("iron_ingot");
        GOLD_INGOT = registry.getRegisteredItem("gold_ingot");
        IRON_SWORD = registry.getRegisteredItem("iron_sword");
        WOODEN_SWORD = registry.getRegisteredItem("wooden_sword");
        WOODEN_SHOVEL = registry.getRegisteredItem("wooden_shovel");
        WOODEN_PICKAXE = registry.getRegisteredItem("wooden_pickaxe");
        WOODEN_AXE = registry.getRegisteredItem("wooden_axe");
        STONE_SWORD = registry.getRegisteredItem("stone_sword");
        STONE_SHOVEL = registry.getRegisteredItem("stone_shovel");
        STONE_PICKAXE = registry.getRegisteredItem("stone_pickaxe");
        STONE_AXE = registry.getRegisteredItem("stone_axe");
        DIAMOND_SWORD = registry.getRegisteredItem("diamond_sword");
        DIAMOND_SHOVEL = registry.getRegisteredItem("diamond_shovel");
        DIAMOND_PICKAXE = registry.getRegisteredItem("diamond_pickaxe");
        DIAMOND_AXE = registry.getRegisteredItem("diamond_axe");
        STICK = registry.getRegisteredItem("stick");
        BOWL = registry.getRegisteredItem("bowl");
        MUSHROOM_STEW = registry.getRegisteredItem("mushroom_stew");
        GOLDEN_SWORD = registry.getRegisteredItem("golden_sword");
        GOLDEN_SHOVEL = registry.getRegisteredItem("golden_shovel");
        GOLDEN_PICKAXE = registry.getRegisteredItem("golden_pickaxe");
        GOLDEN_AXE = registry.getRegisteredItem("golden_axe");
        STRING = registry.getRegisteredItem("string");
        FEATHER = registry.getRegisteredItem("feather");
        GUNPOWDER = registry.getRegisteredItem("gunpowder");
        WOODEN_HOE = registry.getRegisteredItem("wooden_hoe");
        STONE_HOE = registry.getRegisteredItem("stone_hoe");
        IRON_HOE = registry.getRegisteredItem("iron_hoe");
        DIAMOND_HOE = registry.getRegisteredItem("diamond_hoe");
        GOLDEN_HOE = registry.getRegisteredItem("golden_hoe");
        WHEAT_SEEDS = registry.getRegisteredItem("wheat_seeds");
        WHEAT = registry.getRegisteredItem("wheat");
        BREAD = registry.getRegisteredItem("bread");
        LEATHER_HELMET = registry.getRegisteredItem("leather_helmet");
        LEATHER_CHESTPLATE = registry.getRegisteredItem("leather_chestplate");
        LEATHER_LEGGINGS = registry.getRegisteredItem("leather_leggings");
        LEATHER_BOOTS = registry.getRegisteredItem("leather_boots");
        CHAINMAIL_HELMET = registry.getRegisteredItem("chainmail_helmet");
        CHAINMAIL_CHESTPLATE = registry.getRegisteredItem("chainmail_chestplate");
        CHAINMAIL_LEGGINGS = registry.getRegisteredItem("chainmail_leggings");
        CHAINMAIL_BOOTS = registry.getRegisteredItem("chainmail_boots");
        IRON_HELMET = registry.getRegisteredItem("iron_helmet");
        IRON_CHESTPLATE = registry.getRegisteredItem("iron_chestplate");
        IRON_LEGGINGS = registry.getRegisteredItem("iron_leggings");
        IRON_BOOTS = registry.getRegisteredItem("iron_boots");
        DIAMOND_HELMET = registry.getRegisteredItem("diamond_helmet");
        DIAMOND_CHESTPLATE = registry.getRegisteredItem("diamond_chestplate");
        DIAMOND_LEGGINGS = registry.getRegisteredItem("diamond_leggings");
        DIAMOND_BOOTS = registry.getRegisteredItem("diamond_boots");
        GOLDEN_HELMET = registry.getRegisteredItem("golden_helmet");
        GOLDEN_CHESTPLATE = registry.getRegisteredItem("golden_chestplate");
        GOLDEN_LEGGINGS = registry.getRegisteredItem("golden_leggings");
        GOLDEN_BOOTS = registry.getRegisteredItem("golden_boots");
        FLINT = registry.getRegisteredItem("flint");
        PORKCHOP = registry.getRegisteredItem("porkchop");
        COOKED_PORKCHOP = registry.getRegisteredItem("cooked_porkchop");
        PAINTING = registry.getRegisteredItem("painting");
        GOLDEN_APPLE = registry.getRegisteredItem("golden_apple");
        SIGN = registry.getRegisteredItem("sign");
        OAK_DOOR = registry.getRegisteredItem("wooden_door");
        SPRUCE_DOOR = registry.getRegisteredItem("spruce_door");
        BIRCH_DOOR = registry.getRegisteredItem("birch_door");
        JUNGLE_DOOR = registry.getRegisteredItem("jungle_door");
        ACACIA_DOOR = registry.getRegisteredItem("acacia_door");
        DARK_OAK_DOOR = registry.getRegisteredItem("dark_oak_door");
        BUCKET = registry.getRegisteredItem("bucket");
        WATER_BUCKET = registry.getRegisteredItem("water_bucket");
        LAVA_BUCKET = registry.getRegisteredItem("lava_bucket");
        MINECART = registry.getRegisteredItem("minecart");
        SADDLE = registry.getRegisteredItem("saddle");
        IRON_DOOR = registry.getRegisteredItem("iron_door");
        REDSTONE = registry.getRegisteredItem("redstone");
        SNOWBALL = registry.getRegisteredItem("snowball");
        BOAT = registry.getRegisteredItem("boat");
        SPRUCE_BOAT = registry.getRegisteredItem("spruce_boat");
        BIRCH_BOAT = registry.getRegisteredItem("birch_boat");
        JUNGLE_BOAT = registry.getRegisteredItem("jungle_boat");
        ACACIA_BOAT = registry.getRegisteredItem("acacia_boat");
        DARK_OAK_BOAT = registry.getRegisteredItem("dark_oak_boat");
        LEATHER = registry.getRegisteredItem("leather");
        MILK_BUCKET = registry.getRegisteredItem("milk_bucket");
        BRICK = registry.getRegisteredItem("brick");
        CLAY_BALL = registry.getRegisteredItem("clay_ball");
        REEDS = registry.getRegisteredItem("reeds");
        PAPER = registry.getRegisteredItem("paper");
        BOOK = registry.getRegisteredItem("book");
        SLIME_BALL = registry.getRegisteredItem("slime_ball");
        CHEST_MINECART = registry.getRegisteredItem("chest_minecart");
        FURNACE_MINECART = registry.getRegisteredItem("furnace_minecart");
        EGG = registry.getRegisteredItem("egg");
        COMPASS = registry.getRegisteredItem("compass");
        FISHING_ROD = registry.getRegisteredItem("fishing_rod");
        CLOCK = registry.getRegisteredItem("clock");
        GLOWSTONE_DUST = registry.getRegisteredItem("glowstone_dust");
        FISH = registry.getRegisteredItem("fish");
        COOKED_FISH = registry.getRegisteredItem("cooked_fish");
        DYE = registry.getRegisteredItem("dye");
        BONE = registry.getRegisteredItem("bone");
        SUGAR = registry.getRegisteredItem("sugar");
        CAKE = registry.getRegisteredItem("cake");
        BED = registry.getRegisteredItem("bed");
        REPEATER = registry.getRegisteredItem("repeater");
        COOKIE = registry.getRegisteredItem("cookie");
        FILLED_MAP = registry.getRegisteredItem("filled_map");
        SHEARS = registry.getRegisteredItem("shears");
        MELON = registry.getRegisteredItem("melon");
        PUMPKIN_SEEDS = registry.getRegisteredItem("pumpkin_seeds");
        MELON_SEEDS = registry.getRegisteredItem("melon_seeds");
        BEEF = registry.getRegisteredItem("beef");
        COOKED_BEEF = registry.getRegisteredItem("cooked_beef");
        CHICKEN = registry.getRegisteredItem("chicken");
        COOKED_CHICKEN = registry.getRegisteredItem("cooked_chicken");
        MUTTON = registry.getRegisteredItem("mutton");
        COOKED_MUTTON = registry.getRegisteredItem("cooked_mutton");
        RABBIT = registry.getRegisteredItem("rabbit");
        COOKED_RABBIT = registry.getRegisteredItem("cooked_rabbit");
        RABBIT_STEW = registry.getRegisteredItem("rabbit_stew");
        RABBIT_FOOT = registry.getRegisteredItem("rabbit_foot");
        RABBIT_HIDE = registry.getRegisteredItem("rabbit_hide");
        ROTTEN_FLESH = registry.getRegisteredItem("rotten_flesh");
        ENDER_PEARL = registry.getRegisteredItem("ender_pearl");
        BLAZE_ROD = registry.getRegisteredItem("blaze_rod");
        GHAST_TEAR = registry.getRegisteredItem("ghast_tear");
        GOLD_NUGGET = registry.getRegisteredItem("gold_nugget");
        NETHER_WART = registry.getRegisteredItem("nether_wart");
        POTIONITEM = registry.getRegisteredItem("potion");
        SPLASH_POTION = registry.getRegisteredItem("splash_potion");
        LINGERING_POTION = registry.getRegisteredItem("lingering_potion");
        GLASS_BOTTLE = registry.getRegisteredItem("glass_bottle");
        DRAGON_BREATH = registry.getRegisteredItem("dragon_breath");
        SPIDER_EYE = registry.getRegisteredItem("spider_eye");
        FERMENTED_SPIDER_EYE = registry.getRegisteredItem("fermented_spider_eye");
        BLAZE_POWDER = registry.getRegisteredItem("blaze_powder");
        MAGMA_CREAM = registry.getRegisteredItem("magma_cream");
        BREWING_STAND = registry.getRegisteredItem("brewing_stand");
        CAULDRON = registry.getRegisteredItem("cauldron");
        ENDER_EYE = registry.getRegisteredItem("ender_eye");
        SPECKLED_MELON = registry.getRegisteredItem("speckled_melon");
        SPAWN_EGG = registry.getRegisteredItem("spawn_egg");
        EXPERIENCE_BOTTLE = registry.getRegisteredItem("experience_bottle");
        FIRE_CHARGE = registry.getRegisteredItem("fire_charge");
        WRITABLE_BOOK = registry.getRegisteredItem("writable_book");
        WRITTEN_BOOK = registry.getRegisteredItem("written_book");
        EMERALD = registry.getRegisteredItem("emerald");
        ITEM_FRAME = registry.getRegisteredItem("item_frame");
        FLOWER_POT = registry.getRegisteredItem("flower_pot");
        CARROT = registry.getRegisteredItem("carrot");
        POTATO = registry.getRegisteredItem("potato");
        BAKED_POTATO = registry.getRegisteredItem("baked_potato");
        POISONOUS_POTATO = registry.getRegisteredItem("poisonous_potato");
        MAP = registry.getRegisteredItem("map");
        GOLDEN_CARROT = registry.getRegisteredItem("golden_carrot");
        SKULL = registry.getRegisteredItem("skull");
        CARROT_ON_A_STICK = registry.getRegisteredItem("carrot_on_a_stick");
        NETHER_STAR = registry.getRegisteredItem("nether_star");
        PUMPKIN_PIE = registry.getRegisteredItem("pumpkin_pie");
        FIREWORKS = registry.getRegisteredItem("fireworks");
        FIREWORK_CHARGE = registry.getRegisteredItem("firework_charge");
        ENCHANTED_BOOK = registry.getRegisteredItem("enchanted_book");
        COMPARATOR = registry.getRegisteredItem("comparator");
        NETHERBRICK = registry.getRegisteredItem("netherbrick");
        QUARTZ = registry.getRegisteredItem("quartz");
        TNT_MINECART = registry.getRegisteredItem("tnt_minecart");
        HOPPER_MINECART = registry.getRegisteredItem("hopper_minecart");
        ARMOR_STAND = registry.getRegisteredItem("armor_stand");
        IRON_HORSE_ARMOR = registry.getRegisteredItem("iron_horse_armor");
        GOLDEN_HORSE_ARMOR = registry.getRegisteredItem("golden_horse_armor");
        DIAMOND_HORSE_ARMOR = registry.getRegisteredItem("diamond_horse_armor");
        LEAD = registry.getRegisteredItem("lead");
        NAME_TAG = registry.getRegisteredItem("name_tag");
        COMMAND_BLOCK_MINECART = registry.getRegisteredItem("command_block_minecart");
        RECORD_13 = registry.getRegisteredItem("record_13");
        RECORD_CAT = registry.getRegisteredItem("record_cat");
        RECORD_BLOCKS = registry.getRegisteredItem("record_blocks");
        RECORD_CHIRP = registry.getRegisteredItem("record_chirp");
        RECORD_FAR = registry.getRegisteredItem("record_far");
        RECORD_MALL = registry.getRegisteredItem("record_mall");
        RECORD_MELLOHI = registry.getRegisteredItem("record_mellohi");
        RECORD_STAL = registry.getRegisteredItem("record_stal");
        RECORD_STRAD = registry.getRegisteredItem("record_strad");
        RECORD_WARD = registry.getRegisteredItem("record_ward");
        RECORD_11 = registry.getRegisteredItem("record_11");
        RECORD_WAIT = registry.getRegisteredItem("record_wait");
        PRISMARINE_SHARD = registry.getRegisteredItem("prismarine_shard");
        PRISMARINE_CRYSTALS = registry.getRegisteredItem("prismarine_crystals");
        BANNER = registry.getRegisteredItem("banner");
        END_CRYSTAL = registry.getRegisteredItem("end_crystal");
        SHIELD = registry.getRegisteredItem("shield");
        ELYTRA = registry.getRegisteredItem("elytra");
        CHORUS_FRUIT = registry.getRegisteredItem("chorus_fruit");
        CHORUS_FRUIT_POPPED = registry.getRegisteredItem("chorus_fruit_popped");
        BEETROOT_SEEDS = registry.getRegisteredItem("beetroot_seeds");
        BEETROOT = registry.getRegisteredItem("beetroot");
        BEETROOT_SOUP = registry.getRegisteredItem("beetroot_soup");
        TOTEM_OF_UNDYING = registry.getRegisteredItem("totem_of_undying");
        SHULKER_SHELL = registry.getRegisteredItem("shulker_shell");
        IRON_NUGGET = registry.getRegisteredItem("iron_nugget");
        KNOWLEDGE_BOOK = registry.getRegisteredItem("knowledge_book");
    }
}
