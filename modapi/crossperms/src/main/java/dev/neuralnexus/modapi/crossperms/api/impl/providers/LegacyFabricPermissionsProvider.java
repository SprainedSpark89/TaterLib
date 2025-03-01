/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.modapi.crossperms.api.impl.providers;

import dev.neuralnexus.modapi.crossperms.CrossPerms;
import dev.neuralnexus.modapi.crossperms.api.PermissionsProvider;
import dev.neuralnexus.modapi.crossperms.api.mc.WServerPlayer;

import net.legacyfabric.fabric.api.permission.v1.PermissibleCommandSource;
import net.legacyfabric.fabric.api.permission.v1.PermissionsApiHolder;
import net.legacyfabric.fabric.api.permission.v1.PlayerPermissionsApi;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Objects;

/** Legacy Fabric permissions provider */
@SuppressWarnings({"deprecation", "UnstableApiUsage"})
public class LegacyFabricPermissionsProvider implements PermissionsProvider {
    @Override
    public String id() {
        return "fabricpermissions";
    }

    @Override
    public boolean hasPermission(@NotNull Object subject, int permissionLevel) {
        Objects.requireNonNull(subject, "Subject cannot be null");
        return this.hasPermission(subject, permissionLevel, null);
    }

    @Override
    public boolean hasPermission(@NotNull Object subject, @NotNull String permission) {
        Objects.requireNonNull(subject, "Subject cannot be null");
        Objects.requireNonNull(permission, "Permission cannot be null");
        boolean result = false;
        if (WServerPlayer.instanceOf(subject)) {
            result = this.playerHasPermission(subject, permission);
        } else if (subject instanceof PermissibleCommandSource commandSource) {
            result = commandSource.hasPermission(permission);
        }
        return result | this.hasPermission(subject, 4);
    }

    private static final Method HAS_PERMISSION;

    static {
        Method method = null;
        try {
            method =
                    PlayerPermissionsApi.class.getDeclaredMethod(
                            "hasPermission", WServerPlayer.getClazz(), String.class);
        } catch (NoSuchMethodException e) {
            CrossPerms.instance().logger().error("Failed to get method", e);
        }
        HAS_PERMISSION = method;
    }

    /**
     * Get if a player has a permission
     *
     * @param subject The player to check
     * @param permission The permission to check
     * @return If the player has the permission
     */
    private boolean playerHasPermission(Object subject, String permission) {
        if (WServerPlayer.instanceOf(subject)) {
            try {
                return (boolean)
                        HAS_PERMISSION.invoke(
                                PermissionsApiHolder.getPlayerPermissionsApi(),
                                subject,
                                permission);
            } catch (Exception e) {
                CrossPerms.instance().logger().error("Failed to invoke method", e);
            }
        }
        return false;
    }
}
