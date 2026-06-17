package me.frigidambiance.grindstoneblacklist;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class Config {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BLACKLIST;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("grindstoneblacklist");
        BLACKLIST = builder
          .comment(
              "Items in this list cannot be used in a grindstone.",
              "Use full item ids, for example: evilhunter:true_silver_sword"
          )
          .defineList(
              "blacklisted_items",
              List.of(
                  "evilhunter:true_silver_sword",
                  "evilhunter:ritual_sword"
              ),
              value -> value instanceof String
          );

        builder.pop();

        SPEC = builder.build();
    }

    private Config() { }
}
