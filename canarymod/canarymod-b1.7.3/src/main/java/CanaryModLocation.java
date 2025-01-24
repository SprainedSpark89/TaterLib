/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.world.BlockPos;
import dev.neuralnexus.taterapi.world.Location;

/** CanaryMod implementation of {@link Location}. */
public class CanaryModLocation implements Location {
    private final Location location;

    /** Creates a new location. */
    public CanaryModLocation(Location location) {
        this.location = location;
    }

    public CanaryModLocation(double x, double y, double z, float pitch, float rotation) {
		this.location = null;
		// TODO Auto-generated constructor stub
    	setX(x);
    	setY(y);
    	setZ(z);
    	setPitch(pitch);
    	setYaw(rotation);
	}

	@Override
    public void setX(double x) {
        location.setX(x);
    }

    @Override
    public void setY(double y) {
        location.setY(y);
    }

    @Override
    public void setZ(double z) {
        location.setZ(z);
    }

    @Override
    public float yaw() {
        return location.yaw();
    }

    @Override
    public void setYaw(float yaw) {
        location.setYaw(yaw);
    }

    @Override
    public float pitch() {
        return location.pitch();
    }

    @Override
    public void setPitch(float pitch) {
        location.setPitch(pitch);
    }

    @Override
    public BlockPos blockPosition() {
        return new BlockPos(location.x(), location.y(), location.z());
    }

    @Override
    public dev.neuralnexus.taterapi.world.World world() {
        return new CanaryModWorld((World)location.world());
    }

    @Override
    public void setWorld(dev.neuralnexus.taterapi.world.World world) {
        location.setWorld((dev.neuralnexus.taterapi.world.World)((CanaryModWorld) world).world());
    }
}
