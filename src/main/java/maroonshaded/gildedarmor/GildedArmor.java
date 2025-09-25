package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.data.ModItemModelProvider;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(GildedArmor.MODID)
public class GildedArmor
{
    public static final String MODID = "gildedarmor";
    public static final String ENDERITE_MOD_MODID = "enderitemod";

    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = ItemTags.create(ResourceLocation.fromNamespaceAndPath(ENDERITE_MOD_MODID, "repairs_enderite_armor"));

    public GildedArmor(IEventBus modEventBus)
    {
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::onGatherData);
    }

    public static ResourceLocation location(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void onGatherData(GatherDataEvent.Client event)
    {
        event.createProvider(ModItemModelProvider::new);
    }
}
