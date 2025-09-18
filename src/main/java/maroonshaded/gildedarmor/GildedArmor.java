package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.init.ModArmorMaterials;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(GildedArmor.MODID)
public class GildedArmor
{
    public static final String MODID = "gildedarmor";
    public static final String ENDERITE_MOD_MODID = "enderitemod";

    public static final TagKey<Item> ENDERITE_INGOTS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/enderite"));

    public GildedArmor(IEventBus modEventBus)
    {
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
    }

    public static ResourceLocation location(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
