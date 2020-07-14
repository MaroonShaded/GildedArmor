package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.GildedArmorItem;
import maroonshaded.gildedarmor.item.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GildedArmor.MODID);
    private static final Item.Properties DEFAULT = new Item.Properties().group(ItemGroup.COMBAT);

    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet", () -> new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlotType.HEAD, DEFAULT.func_234689_a_()));
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate", () -> new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlotType.CHEST, DEFAULT.func_234689_a_()));
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings", () -> new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlotType.LEGS, DEFAULT.func_234689_a_()));
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots", () -> new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlotType.FEET, DEFAULT.func_234689_a_()));
}
