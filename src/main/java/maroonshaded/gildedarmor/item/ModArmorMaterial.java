package maroonshaded.gildedarmor.item;

import com.google.common.base.Suppliers;
import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public enum ModArmorMaterial implements IArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", ArmorMaterial.NETHERITE),
    GILDED_ENDERITE("gilded_enderite", 8, new int[]{4, 7, 9, 4}, 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F,
            () -> Ingredient.of(ItemTags.createOptional(new ResourceLocation(GildedArmor.MODID, "enderite_ingot"))),
            true);

    private static final int[] HEALTH_PER_SLOT = {13, 15, 16, 11};
    private static final int[] ENDERITE_HEALTH_PER_SLOT = {128, 144, 160, 112};
    private final String name;
    private final ToIntFunction<EquipmentSlotType> durability;
    private final ToIntFunction<EquipmentSlotType> protection;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] damageReductionAmountArray, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, boolean useEnderiteDurability)
    {
        this.name = name;
        durability = (slot) -> (useEnderiteDurability ? getEnderiteHealthPerSlot() : getHealthPerSlot())[slot.getIndex()] * durabilityMultiplier;
        protection = (slot) -> damageReductionAmountArray[slot.getIndex()];
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    ModArmorMaterial(String name, IArmorMaterial reference)
    {
        this.name = name;
        durability = reference::getDurabilityForSlot;
        protection = reference::getDefenseForSlot;
        enchantmentValue = reference.getEnchantmentValue();
        sound = reference.getEquipSound();
        toughness = reference.getToughness();
        knockbackResistance = reference.getKnockbackResistance();
        repairIngredient = reference::getRepairIngredient;
    }

    public static int[] getHealthPerSlot()
    {
        return HEALTH_PER_SLOT;
    }

    public static int[] getEnderiteHealthPerSlot()
    {
        return ENDERITE_HEALTH_PER_SLOT;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slotIn)
    {
        return durability.applyAsInt(slotIn);
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slotIn)
    {
        return protection.applyAsInt(slotIn);
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return repairIngredient.get();
    }

    @Override
    public String getName()
    {
        return GildedArmor.MODID + ':' + name;
    }

    @Override
    public float getToughness()
    {
        return toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return knockbackResistance;
    }
}
