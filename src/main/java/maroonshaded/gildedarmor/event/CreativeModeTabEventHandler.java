package maroonshaded.gildedarmor.event;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GildedArmor.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeModeTabEventHandler
{
    @SubscribeEvent
    public static void buildCreativeTabContents(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            putAfter(event.getEntries(), new ItemStack(Items.NETHERITE_BOOTS),
                    ModItems.GILDED_NETHERITE_HELMET.get(),
                    ModItems.GILDED_NETHERITE_CHESTPLATE.get(),
                    ModItems.GILDED_NETHERITE_LEGGINGS.get(),
                    ModItems.GILDED_NETHERITE_BOOTS.get(),

                    ModItems.GILDED_ENDERITE_HELMET.get(),
                    ModItems.GILDED_ENDERITE_CHESTPLATE.get(),
                    ModItems.GILDED_ENDERITE_LEGGINGS.get(),
                    ModItems.GILDED_ENDERITE_BOOTS.get()
            );
        }
    }

    public static void putAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries,
                                ItemStack after, ItemLike... items)
    {
        for (ItemLike item : items)
        {
            ItemStack stack = new ItemStack(item);
            entries.putAfter(after, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            after = stack;
        }
    }
}
