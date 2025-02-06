package io.github.thedogofchaos.CropsNCogsLib;

import com.google.common.base.CaseFormat;
import com.mojang.logging.LogUtils;
import io.github.thedogofchaos.CropsNCogsLib.client.ClientProxy;
import io.github.thedogofchaos.CropsNCogsLib.unified.UnifiedProxy;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

/*
 * "Life is a hideous thing, and from the background behind what we know of it
 * peer daemoniacal hints of truthwhich make it sometimes a thousandfold more hideous.
 * Science, already oppressive with its shocking revelations,
 * will perhaps be the ultimate exterminator of our human species —if separate species we be—
 * for its reserve of unguessed horrors could never be borne by mortal brains if loosed upon the world."
 *
 * - H.P. Lovecraft
 */

/**
 * The primary library of all mods in this suite.
 * ALL other mods will rely HEAVILY on this library.
 */
@Mod(CNCLib.MOD_ID)
public class CNCLib {
    /// The main ID of this mod. If you don't know what this is, PLEASE go and read forge's documentation.
    public static final String MOD_ID = "cropsncogslib";
    public static final String MOD_NAME = "Crops 'N Cogs Lib";
    public static final String MOD_NAME_SHORT = "CNCLib";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CNCLib() {
        CNCLib.init();
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> UnifiedProxy::new); // Use whenever possible for stable builds.
        // DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> UnifiedProxy::new); // Only use on unstable builds, or while developing.
    }

    private static void init() {
        LOGGER.info("We're loading {} on the {}", MOD_NAME, FMLEnvironment.dist);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(CNCLib.MOD_ID, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, path));
    }
}
