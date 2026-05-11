package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.config.NeoForgeConfigHelper;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class CreateStrictLinksServer {
    @SubscribeEvent
    private static void onServerStartup(ServerStartingEvent event) {
        Constants.LOG.info("Create Strict Links is " + (NeoForgeConfigHelper.SERVER.isModEnabled.get()
                ? "active. Redstone Link frequencies will verify NBT data components."
                : "inactive! Redstone Link frequencies will only check for item ID and the color component. Use config/create_strict_links-server.toml to re-enable it."));
    }
}
