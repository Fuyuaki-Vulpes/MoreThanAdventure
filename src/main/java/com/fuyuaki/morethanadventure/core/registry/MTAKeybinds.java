package com.fuyuaki.morethanadventure.core.registry;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class MTAKeybinds {

    public static final Lazy<KeyMapping> SKILL_USE = Lazy.of(new KeyMapping("key.mta.skill_use",
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G,
            "key.categories.morethanadventure"));
    public static final Lazy<KeyMapping> SKILL_CYCLE = Lazy.of(new KeyMapping("key.mta.skill_cycle",
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N,
            "key.categories.morethanadventure"));
}
