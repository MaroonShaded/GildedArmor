package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public enum ModArmorMaterial implements IArmorMaterial
{
    GILDED_NETHERITE(ArmorMaterial.NETHERITE);

    private final IArmorMaterial reference;

    ModArmorMaterial(IArmorMaterial reference)
    {
        this.reference = reference;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return reference.getDurability(slotIn);
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return reference.getDamageReductionAmount(slotIn);
    }

    @Override
    public int getEnchantability()
    {
        return reference.getEnchantability();
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return reference.getSoundEvent();
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return reference.getRepairMaterial();
    }

    @Override
    public String getName()
    {
        return GildedArmor.MODID + ":gilded_" + reference.getName();
    }

    @Override
    public float getToughness()
    {
        return reference.getToughness();
    }

    @Override
    public float getKnockbackResistance()
    {
        return reference.getKnockbackResistance();
    }
}
