package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.GildedArmorItem;
import maroonshaded.gildedarmor.item.GildedEnderiteHelmetItem;
import maroonshaded.gildedarmor.item.ModArmorMaterials;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildedArmor.MODID);

    public static final DeferredItem<ModSmithingTemplateItem> GILDING_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("gilding_upgrade_smithing_template", ModSmithingTemplateItem::createGildingUpgradeTemplate);

    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet", () -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate", () -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings", () -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots", () -> new GildedArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // For the Enderite mod
    public static final DeferredItem<GildedEnderiteHelmetItem> GILDED_ENDERITE_HELMET = ITEMS.register("gilded_enderite_helmet", () -> new GildedEnderiteHelmetItem(new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_CHESTPLATE = ITEMS.register("gilded_enderite_chestplate", () -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_LEGGINGS = ITEMS.register("gilded_enderite_leggings", () -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<GildedArmorItem> GILDED_ENDERITE_BOOTS = ITEMS.register("gilded_enderite_boots", () -> new GildedArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
}
