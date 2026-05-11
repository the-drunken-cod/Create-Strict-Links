package com.drunkencod.create_strict_links.config;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class NeoForgeConfigHelper implements IConfigHelper {

    // -------------------------------------------------------------------------
    // Server config
    // -------------------------------------------------------------------------

    public static final ServerConfig SERVER;
    private static final ModConfigSpec SERVER_SPEC;

    static {
        Pair<ServerConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder()
                .configure(ServerConfig::new);
        SERVER = specPair.getLeft();
        SERVER_SPEC = specPair.getRight();
    }

    // -------------------------------------------------------------------------
    // Registration — called from CreateStrictLinksMod constructor
    // -------------------------------------------------------------------------

    /**
     * Must be called in the NeoForge mod constructor with the injected
     * {@link ModContainer}
     * so that configs are registered before the world loads.
     */
    public void register(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
    }

    // -------------------------------------------------------------------------
    // IConfigHelper implementation
    // -------------------------------------------------------------------------

    @Override
    public boolean isModEnabled() {
        return SERVER.isModEnabled.get();
    }

    // -------------------------------------------------------------------------
    // Inner config classes
    // -------------------------------------------------------------------------

    public static class ServerConfig {
        public final ModConfigSpec.BooleanValue isModEnabled;

        ServerConfig(ModConfigSpec.Builder builder) {
            isModEnabled = builder
                    .comment(
                            "When set to true, Create's Redstone Link frequencies will take all data components (NBT) of the two given items into account.")
                    .comment(
                            "When set to false, they behave as they do in unmodified Create, only checking for item ID and the color component.")
                    .define("isModEnabled", true);
        }
    }
}
