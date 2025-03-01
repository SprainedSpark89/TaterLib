/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterapi.hooks.permissions;

import dev.neuralnexus.taterapi.entity.Permissible;
import dev.neuralnexus.taterapi.hooks.Hook;

/** A generic hook for permissions plugins */
@Deprecated
public interface PermissionsHook extends Hook {
    /**
     * Get if a sender has a permission
     *
     * @param permissible The entity to check
     * @param permission The permission to check
     * @return If the entity has the permission
     */
    boolean hasPermission(Permissible permissible, String permission);
}
