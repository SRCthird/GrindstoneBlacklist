package me.frigidambiance.grindstoneblacklist;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GrindstoneBlacklist.MOD_ID)
public class GrindstoneBlacklist {
    public static final String MOD_ID = "grindstoneblacklist";

    public GrindstoneBlacklist(FMLJavaModLoadingContext context) {
        context.registerConfig(
              ModConfig.Type.SERVER,
              Config.SPEC
        );
    }
}
