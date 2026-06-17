package me.frigidambiance.grindstoneblacklist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.GrindstoneEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(
    modid = GrindstoneBlacklist.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class GrindstoneEvents {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onGrindstoneInputChanged(GrindstoneEvent.OnPlaceItem event) {
        if (isBlacklisted(event.getTopItem()) || isBlacklisted(event.getBottomItem())) {
            event.setCanceled(true);
            event.setXp(0);
            event.setOutput(ItemStack.EMPTY);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onGrindstoneOutputTaken(GrindstoneEvent.OnTakeItem event) {
        if (isBlacklisted(event.getTopItem()) || isBlacklisted(event.getBottomItem())) {
            event.setCanceled(true);
            event.setXp(0);
        }
    }

    private static boolean isBlacklisted(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());

        if (itemId == null) {
            return false;
        }

        return Config.BLACKLIST.get()
                .stream()
                .anyMatch(configuredId -> configuredId.equals(itemId.toString()));
    }
}
