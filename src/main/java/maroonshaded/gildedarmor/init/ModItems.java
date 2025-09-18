package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.GildedArmorItem;
import maroonshaded.gildedarmor.item.GildedEnderiteHelmetItem;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildedArmor.MODID);

    public static final DeferredItem<ModSmithingTemplateItem> GILDING_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("gilding_upgrade_smithing_template", ModSmithingTemplateItem::createGildingUpgradeTemplate);

    private static final int GILDED_NETHERITE_DURABILITY_MULTIPLIER = 37;
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_HELMET = ITEMS.registerItem("gilded_netherite_helmet", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.HELMET, properties), new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(GILDED_NETHERITE_DURABILITY_MULTIPLIER)));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_CHESTPLATE = ITEMS.registerItem("gilded_netherite_chestplate", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_LEGGINGS = ITEMS.registerItem("gilded_netherite_leggings", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_BOOTS = ITEMS.registerItem("gilded_netherite_boots", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));

    // For the Enderite mod
    private static final int GILDED_ENDERITE_DURABILITY_MULTIPLIER = 72;
    public static final DeferredItem<GildedEnderiteHelmetItem> GILDED_ENDERITE_HELMET = ITEMS.registerItem("gilded_enderite_helmet", GildedEnderiteHelmetItem::new, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(GILDED_ENDERITE_DURABILITY_MULTIPLIER)));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_CHESTPLATE = ITEMS.registerItem("gilded_enderite_chestplate", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.CHESTPLATE, properties), new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(GILDED_ENDERITE_DURABILITY_MULTIPLIER)));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_LEGGINGS = ITEMS.registerItem("gilded_enderite_leggings", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.LEGGINGS, properties), new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(GILDED_ENDERITE_DURABILITY_MULTIPLIER)));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_BOOTS = ITEMS.registerItem("gilded_enderite_boots", properties -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.BOOTS, properties), new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(GILDED_ENDERITE_DURABILITY_MULTIPLIER)));
}
