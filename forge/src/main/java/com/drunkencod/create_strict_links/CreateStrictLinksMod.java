package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.platform.ForgePlatformHelper;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CreateStrictLinksMod {

    public CreateStrictLinksMod(IEventBus eventBus, ModContainer modContainer) {
        Constants.LOG.info("Starting Create Strict Links Forge initialization...");

        CreateStrictLinks.init();
        Constants.LOG.debug("Common mod initialized.");

        Constants.LOG.info(
                "Create Strict Links Forge initialization complete. Use config/create_strict_links-server.toml to enable or disable the mod.");
    }
}
