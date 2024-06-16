package dev.neuralnexus.conditionalmixins.mixin.utils;

import jdk.internal.org.objectweb.asm.tree.FieldNode;
import org.spongepowered.asm.service.MixinService;

import java.io.IOException;

/** Helper/wrapper class to prevent ClassNotFound errors when Mixin is not present. */
public class MixinServiceUtils {
    /**
     * Returns the Minecraft version.
     *
     * @return The Minecraft version.
     */
    public static String mcVersion() throws ClassNotFoundException, IOException {
        // Fine to do since obfuscated situations are covered by Forge
        // Reflect to get SharedConstants.VERSION_STRING
        return (String)
                MixinService.getService()
                        .getBytecodeProvider()
                        .getClassNode("net.minecraft.SharedConstants")
                        .fields
                        .stream()
                        .filter(field -> field.name.equals("VERSION_STRING"))
                        .findFirst()
                        .get()
                        .value;
    }
}
