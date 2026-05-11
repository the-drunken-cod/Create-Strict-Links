package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.config.NeoForgeConfigHelper;
import com.drunkencod.create_strict_links.platform.Services;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CreateStrictLinksMod {

    public CreateStrictLinksMod(IEventBus eventBus, ModContainer modContainer) {
        Constants.LOG.info("Starting Create Strict Links NeoForge initialization...");

        // Register configs
        ((NeoForgeConfigHelper) Services.CONFIG).register(modContainer);
        Constants.LOG.debug("Mod config initialized.");

        CreateStrictLinks.init();
        Constants.LOG.debug("Common mod initialized.");

        Constants.LOG.info(
                "Create Strict Links NeoForge initialization complete. Use config/create_strict_links-server.toml to enable or disable the mod.");
    }
}
