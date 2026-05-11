package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.config.NeoForgeConfigHelper;
import com.drunkencod.create_strict_links.platform.Services;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CreateStrictLinksMod {

    public CreateStrictLinksMod(IEventBus eventBus, ModContainer modContainer) {
        // Register configs
        ((NeoForgeConfigHelper) Services.CONFIG).register(modContainer);

        CreateStrictLinks.init();
    }
}
