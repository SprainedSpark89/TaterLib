/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.modapi.metadata.annotations;

import dev.neuralnexus.modapi.metadata.enums.MinecraftVersion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** An annotation to specify a range of Minecraft versions for an annotation */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Range {
    /**
     * The minimum required Minecraft version (inclusive)
     *
     * @return The minimum required Minecraft version
     */
    MinecraftVersion min() default MinecraftVersion.UNKNOWN;

    /**
     * The maximum required Minecraft version (inclusive)
     *
     * @return The maximum required Minecraft version
     */
    MinecraftVersion max() default MinecraftVersion.UNKNOWN;
}
