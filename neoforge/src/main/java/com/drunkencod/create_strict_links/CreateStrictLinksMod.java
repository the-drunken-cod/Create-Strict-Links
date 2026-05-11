package com.drunkencod.create_strict_links;

import com.drunkencod.create_strict_links.config.NeoForgeConfigHelper;
import com.drunkencod.create_strict_links.datagen.NeoForgeItemModelProvider;
import com.drunkencod.create_strict_links.platform.Services;
import com.drunkencod.create_strict_links.registry.NeoForgeRegistryHelper;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(Constants.MOD_ID)
public class CreateStrictLinksMod {

    public CreateStrictLinksMod(IEventBus eventBus, ModContainer modContainer) {
        // Wire DeferredRegisters
        ((NeoForgeRegistryHelper) Services.REGISTRY).initialize(eventBus);

        // Register configs
        ((NeoForgeConfigHelper) Services.CONFIG).register(modContainer);

        eventBus.addListener(this::onGatherData);

        CreateStrictLinks.init();
    }

    private void onGatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(
                event.includeClient(),
                new NeoForgeItemModelProvider(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
    }
}
