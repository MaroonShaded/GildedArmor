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

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpgradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditionalSlotEmptyIcons)
    {
        super(pAppliesTo, pIngredients, pUpgradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons);
    }

    public static SmithingTemplateItem createGildingUpgradeTemplate()
    {
        return new SmithingTemplateItem(GILDING_UPGRADE_APPLIES_TO, GILDING_UPGRADE_INGREDIENTS, GILDING_UPGRADE, GILDING_UPGRADE_BASE_SLOT_DESCRIPTION, GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createTrimmableArmorIconList(), createNetheriteUpgradeMaterialList());
    }
}
