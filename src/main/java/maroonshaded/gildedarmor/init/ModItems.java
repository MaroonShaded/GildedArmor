package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import maroonshaded.gildedarmor.item.equipment.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildedArmor.MODID);

    public static final DeferredItem<ModSmithingTemplateItem> GILDING_UPGRADE_SMITHING_TEMPLATE = ITEMS.registerItem("gilding_upgrade_smithing_template", ModSmithingTemplateItem::createGildingUpgradeTemplate, new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final DeferredItem<ArmorItem> GILDED_NETHERITE_HELMET = ITEMS.registerItem("gilded_netherite_helmet", properties -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorType.HELMET, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_NETHERITE_CHESTPLATE = ITEMS.registerItem("gilded_netherite_chestplate", properties -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorType.CHESTPLATE, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_NETHERITE_LEGGINGS = ITEMS.registerItem("gilded_netherite_leggings", properties -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorType.LEGGINGS, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_NETHERITE_BOOTS = ITEMS.registerItem("gilded_netherite_boots", properties -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorType.BOOTS, properties), new Item.Properties().fireResistant());

    // For the Enderite mod
    public static final DeferredItem<ArmorItem> GILDED_ENDERITE_HELMET = ITEMS.registerItem("gilded_enderite_helmet", properties -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorType.HELMET, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_ENDERITE_CHESTPLATE = ITEMS.registerItem("gilded_enderite_chestplate", properties -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorType.CHESTPLATE, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_ENDERITE_LEGGINGS = ITEMS.registerItem("gilded_enderite_leggings", properties -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorType.LEGGINGS, properties), new Item.Properties().fireResistant());
    public static final DeferredItem<ArmorItem> GILDED_ENDERITE_BOOTS = ITEMS.registerItem("gilded_enderite_boots", properties -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorType.BOOTS, properties), new Item.Properties().fireResistant());
}
