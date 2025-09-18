package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem
{
    private static final Component GILDING_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", GildedArmor.location("gilding_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component GILDING_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GILDING_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GILDING_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.base_slot_description")));
    private static final Component GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.additions_slot_description")));
    
    private static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET_TEXTURE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_INGOT_TEXTURE = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpgradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditionalSlotEmptyIcons)
    {
        super(pAppliesTo, pIngredients, pUpgradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons);
    }

    public static ModSmithingTemplateItem createGildingUpgradeTemplate()
    {
        return new ModSmithingTemplateItem(GILDING_UPGRADE_APPLIES_TO, GILDING_UPGRADE_INGREDIENTS, GILDING_UPGRADE, GILDING_UPGRADE_BASE_SLOT_DESCRIPTION, GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createGildingUpgradeIconList(), createGildingUpgradeMaterialList());
    }

    public static List<ResourceLocation> createGildingUpgradeIconList()
    {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
    }

    public static List<ResourceLocation> createGildingUpgradeMaterialList()
    {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }
}
