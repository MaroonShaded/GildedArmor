package maroonshaded.gildedarmor.item;

import com.google.common.base.Suppliers;
import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements StringRepresentable, ArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT), true),
    GILDED_ENDERITE("gilded_enderite", 8, Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
    }), 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F,
            () -> Ingredient.of(GildedArmor.ENDERITE_INGOT_TAG), true);

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });
    private static final EnumMap<ArmorItem.Type, Integer> ENDERITE_HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 128);
        map.put(ArmorItem.Type.LEGGINGS, 144);
        map.put(ArmorItem.Type.CHESTPLATE, 160);
        map.put(ArmorItem.Type.HELMET, 112);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final boolean useEnderiteDurability;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, boolean useEnderiteDurability)
    {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.useEnderiteDurability = useEnderiteDurability;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType)
    {
        return (useEnderiteDurability
                ? ENDERITE_HEALTH_FUNCTION_FOR_TYPE
                : HEALTH_FUNCTION_FOR_TYPE)
                .get(pType) * durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType)
    {
        return protectionFunctionForType.get(pType);
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

    @Override
    public String getSerializedName()
    {
        return getName();
    }
}
