package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public enum ModArmorMaterial implements IArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", ArmorMaterial.NETHERITE),
    GILDED_ENDERITE("gilded_enderite", 8, new int[] { 4, 7, 9, 4 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () ->
    {
        ResourceLocation id = new ResourceLocation("enderitemod", "enderite_ingot");
        return ForgeRegistries.ITEMS.containsKey(id) ? Ingredient.fromItems(ForgeRegistries.ITEMS.getValue(id)) : Ingredient.fromItems();
    }, true);

    private static final int[] MAX_DAMAGE_ARRAY = {13, 15, 16, 11};
    private static final int[] ENDERITE_MAX_DAMAGE_ARRAY = {128, 144, 160, 112};
    private final String name;
    private final ToIntFunction<EquipmentSlotType> maxDamageFactor;
    private final ToIntFunction<EquipmentSlotType> damageReductionAmount;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial, boolean useEnderiteDurability)
    {
        this.name = name;
        this.maxDamageFactor = (slot) -> (useEnderiteDurability ? getEnderiteMaxDamageArray() : getMaxDamageArray())[slot.getIndex()] * maxDamageFactor;
        damageReductionAmount = (slot) -> damageReductionAmountArray[slot.getIndex()];
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    ModArmorMaterial(String name, IArmorMaterial reference)
    {
        this.name = name;
        maxDamageFactor = reference::getDurability;
        damageReductionAmount = reference::getDamageReductionAmount;
        enchantability = reference.getEnchantability();
        soundEvent = reference.getSoundEvent();
        toughness = reference.getToughness();
        knockbackResistance = reference.getKnockbackResistance();
        repairMaterial = new LazyValue<>(reference::getRepairMaterial);
    }

    public static int[] getMaxDamageArray()
    {
        return MAX_DAMAGE_ARRAY;
    }

    public static int[] getEnderiteMaxDamageArray()
    {
        return ENDERITE_MAX_DAMAGE_ARRAY;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return maxDamageFactor.applyAsInt(slotIn);
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return damageReductionAmount.applyAsInt(slotIn);
    }

    @Override
    public int getEnchantability()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return repairMaterial.getValue();
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
