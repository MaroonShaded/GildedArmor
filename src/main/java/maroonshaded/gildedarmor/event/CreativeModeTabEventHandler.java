package maroonshaded.gildedarmor.event;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = GildedArmor.MODID)
public class CreativeModeTabEventHandler
{
    private static final ResourceKey<CreativeModeTab> ENDERITE_TAB = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(GildedArmor.ENDERITE_MOD_MODID, "enderite_group"));

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
        }
        else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.insertAfter(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                    new ItemStack(ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        else if (event.getTabKey().equals(ENDERITE_TAB))
        {
            insertAllAfter(event, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(GildedArmor.ENDERITE_MOD_MODID, "enderite_boots"))),
                    ModItems.GILDED_ENDERITE_HELMET.get(),
                    ModItems.GILDED_ENDERITE_CHESTPLATE.get(),
                    ModItems.GILDED_ENDERITE_LEGGINGS.get(),
                    ModItems.GILDED_ENDERITE_BOOTS.get());
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
