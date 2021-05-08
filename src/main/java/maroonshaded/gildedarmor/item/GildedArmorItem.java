package maroonshaded.gildedarmor.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GildedArmorItem extends ArmorItem
{
    public GildedArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties properties)
    {
        super(materialIn, slot, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        for (int i = 1; i <= 3; i++)
            tooltip.add(new TranslationTextComponent("item.gildedarmor.generic.upgrading_note" + i).mergeStyle(TextFormatting.GRAY));
    }
}
