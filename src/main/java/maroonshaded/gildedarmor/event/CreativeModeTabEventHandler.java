package maroonshaded.gildedarmor.event;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = GildedArmor.MODID)
public class CreativeModeTabEventHandler
{
    @SubscribeEvent
    public static void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            insertAllAfter(event, new ItemStack(Items.NETHERITE_BOOTS),
                    ModItems.GILDED_NETHERITE_HELMET.get(),
                    ModItems.GILDED_NETHERITE_CHESTPLATE.get(),
                    ModItems.GILDED_NETHERITE_LEGGINGS.get(),
                    ModItems.GILDED_NETHERITE_BOOTS.get()
            );
            if (ModList.get().isLoaded(GildedArmor.ENDERITE_MOD_MODID))
            {
                insertAllAfter(event, new ItemStack(ModItems.GILDED_NETHERITE_BOOTS.get()),
                        ModItems.GILDED_ENDERITE_HELMET.get(),
                        ModItems.GILDED_ENDERITE_CHESTPLATE.get(),
                        ModItems.GILDED_ENDERITE_LEGGINGS.get(),
                        ModItems.GILDED_ENDERITE_BOOTS.get());
            }
        }
        else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.insertAfter(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                    new ItemStack(ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static void insertAllAfter(BuildCreativeModeTabContentsEvent event, ItemStack after, ItemLike... items)
    {
        for (ItemLike item : items)
        {
            ItemStack stack = new ItemStack(item);
            event.insertAfter(after, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            after = stack;
        }
    }
}
