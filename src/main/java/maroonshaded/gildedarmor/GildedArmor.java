package maroonshaded.gildedarmor;

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

    public static final TagKey<Item> ENDERITE_INGOT_TAG = ItemTags.create(location("enderite_ingot"));

    public GildedArmor(IEventBus modEventBus)
    {
        ModItems.ITEMS.register(modEventBus);
    }

    public static ResourceLocation location(String path)
    {
        return new ResourceLocation(MODID, path);
    }
}
