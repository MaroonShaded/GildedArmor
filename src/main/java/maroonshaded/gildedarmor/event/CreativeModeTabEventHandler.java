package maroonshaded.gildedarmor.event;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = GildedArmor.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeModeTabEventHandler
{
    @SubscribeEvent
    public static void buildCreativeTabContents(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.GILDED_NETHERITE_HELMET);
            event.accept(ModItems.GILDED_NETHERITE_CHESTPLATE);
            event.accept(ModItems.GILDED_NETHERITE_LEGGINGS);
            event.accept(ModItems.GILDED_NETHERITE_BOOTS);

            event.accept(ModItems.GILDED_ENDERITE_HELMET);
            event.accept(ModItems.GILDED_ENDERITE_CHESTPLATE);
            event.accept(ModItems.GILDED_ENDERITE_LEGGINGS);
            event.accept(ModItems.GILDED_ENDERITE_BOOTS);
        }
    }
}
