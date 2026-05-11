package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.CreateStrictLinks;
import com.drunkencod.create_strict_links.config.FabricConfigHelper;
import com.drunkencod.create_strict_links.platform.Services;

import net.fabricmc.api.ModInitializer;

public class CreateStrictLinksMod implements ModInitializer {

    @Override
    public void onInitialize() {
        // Register Cloth Config configs
        ((FabricConfigHelper) Services.CONFIG).register();

        CreateStrictLinks.init();
    }
}
