package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials
{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, GildedArmor.MODID);

    public static final Holder<ArmorMaterial> GILDED_NETHERITE = ARMOR_MATERIALS.register("gilded_netherite", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), defense ->
    {
        defense.put(ArmorItem.Type.BOOTS, 3);
        defense.put(ArmorItem.Type.LEGGINGS, 6);
        defense.put(ArmorItem.Type.CHESTPLATE, 8);
        defense.put(ArmorItem.Type.HELMET, 3);
        defense.put(ArmorItem.Type.BODY, 11);
    }), 17, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), List.of(
            new ArmorMaterial.Layer(GildedArmor.location("gilded_netherite"))
    ), 3.0F, 0.1F));

    public static final Holder<ArmorMaterial> GILDED_ENDERITE = ARMOR_MATERIALS.register("gilded_enderite", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), defense ->
    {
        defense.put(ArmorItem.Type.BOOTS, 4);
        defense.put(ArmorItem.Type.LEGGINGS, 7);
        defense.put(ArmorItem.Type.CHESTPLATE, 9);
        defense.put(ArmorItem.Type.HELMET, 4);
        defense.put(ArmorItem.Type.BODY, 12);
    }), 17, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(GildedArmor.ENDERITE_INGOTS_TAG), List.of(
            new ArmorMaterial.Layer(GildedArmor.location("gilded_enderite"))
    ), 4.0F, 0.1F));
}
