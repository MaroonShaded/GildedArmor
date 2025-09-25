package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem
{
    private static final Component GILDING_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GILDING_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GILDING_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.base_slot_description")));
    private static final Component GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", GildedArmor.location("smithing_template.gilding_upgrade.additions_slot_description")));
    
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("container/slot/helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("container/slot/chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("container/slot/leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("container/slot/boots");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("container/slot/ingot");

    public ModSmithingTemplateItem(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, Properties properties)
    {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties);
    }

    public static ModSmithingTemplateItem createGildingUpgradeTemplate(Properties properties)
    {
        return new ModSmithingTemplateItem(GILDING_UPGRADE_APPLIES_TO, GILDING_UPGRADE_INGREDIENTS, GILDING_UPGRADE_BASE_SLOT_DESCRIPTION, GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createGildingUpgradeIconList(), createGildingUpgradeMaterialList(), properties);
    }

    private static List<ResourceLocation> createGildingUpgradeIconList()
    {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createGildingUpgradeMaterialList()
    {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
