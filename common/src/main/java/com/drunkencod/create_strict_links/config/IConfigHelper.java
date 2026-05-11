package com.drunkencod.create_strict_links.config;

/**
 * Cross-loader config service interface.
 * <p>
 * Add config entries here as interface methods, then implement them in
 * {@code NeoForgeConfigHelper} (using {@code ModConfigSpec}) and
 * {@code FabricConfigHelper} (using Cloth Config / AutoConfig).
 *
 * <p>
 * Config is loaded via
 * {@link com.drunkencod.create_strict_links.platform.Services#CONFIG}.
 */
public interface IConfigHelper {

    /**
     * Whether the mod should be enabled
     */
    boolean isModEnabled();
}
