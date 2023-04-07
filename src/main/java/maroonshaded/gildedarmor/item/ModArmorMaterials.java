package maroonshaded.gildedarmor.item;

import com.google.common.base.Suppliers;
import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public enum ModArmorMaterials implements ArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", ArmorMaterials.NETHERITE),
    GILDED_ENDERITE("gilded_enderite", 8, new int[]{4, 7, 9, 4}, 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F,
            () -> Ingredient.of(ItemTags.create(new ResourceLocation(GildedArmor.MODID, "enderite_ingot"))),
            true);

    private static final int[] HEALTH_PER_SLOT = {13, 15, 16, 11};
    private static final int[] ENDERITE_HEALTH_PER_SLOT = {128, 144, 160, 112};
    private final String name;
    private final ToIntFunction<EquipmentSlot> durability;
    private final ToIntFunction<EquipmentSlot> protection;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] damageReductionAmountArray, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, boolean useEnderiteDurability)
    {
        this.name = name;
        durability = slot -> (useEnderiteDurability ? getEnderiteHealthPerSlot() : getHealthPerSlot())[slot.getIndex()] * durabilityMultiplier;
        protection = slot -> damageReductionAmountArray[slot.getIndex()];
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    ModArmorMaterials(String name, ArmorMaterial reference)
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
    public int getDurabilityForSlot(EquipmentSlot pSlot)
    {
        return durability.applyAsInt(pSlot);
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pSlot)
    {
        return protection.applyAsInt(pSlot);
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
