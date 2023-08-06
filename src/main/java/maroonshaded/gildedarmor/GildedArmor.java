package maroonshaded.gildedarmor;

import com.redlimerl.detailab.DetailArmorBar;
import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import maroonshaded.gildedarmor.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GildedArmor.MODID)
public class GildedArmor
{
    public static final String MODID = "gildedarmor";
    public static final String DETAILAB_MODID = "detailab";

    public GildedArmor()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation location(String path)
    {
        return new ResourceLocation(MODID, path);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        private static final ResourceLocation ARMOR_BAR_TEXTURE = GildedArmor.location("textures/gui/armor_bar.png");

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            if (ModList.get().isLoaded(DETAILAB_MODID))
            {
                registerArmorBars();
            }
        }

        private static void registerArmorBars()
        {
            TextureOffset outline = new TextureOffset(9, 0);
            TextureOffset outlineHalf = new TextureOffset(0, 0);

            ArmorBarRenderManager renderManager = new ArmorBarRenderManager(ARMOR_BAR_TEXTURE, 32, 32,
                    new TextureOffset(9, 9),
                    new TextureOffset(0, 9),
                    outline, outlineHalf);
            ArmorBarRenderManager vanillaRenderManager = new ArmorBarRenderManager(ARMOR_BAR_TEXTURE, 32, 32,
                    new TextureOffset(9, 18),
                    new TextureOffset(0, 18),
                    outline, outlineHalf);

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(
                            (ArmorItem) ModItems.GILDED_NETHERITE_HELMET.get(),
                            (ArmorItem) ModItems.GILDED_NETHERITE_CHESTPLATE.get(),
                            (ArmorItem) ModItems.GILDED_NETHERITE_LEGGINGS.get(),
                            (ArmorItem) ModItems.GILDED_NETHERITE_BOOTS.get()
                    )
                    .render(stack -> DetailArmorBar.getConfig().getOptions().toggleVanillaTexture
                            ? renderManager
                            : vanillaRenderManager)
                    .register();
        }
    }
}
