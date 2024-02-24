package dev.neuralnexus.taterlib.vanilla.world;

import dev.neuralnexus.taterlib.world.BlockPos;
import dev.neuralnexus.taterlib.world.Location;
import dev.neuralnexus.taterlib.world.World;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/** Vanilla implementation of {@link Location}. */
public class VanillaLocation implements Location {
    private Vec3 position;
    private float yaw;
    private float pitch;
    private Level world;

    /** Creates a new location from an Entity. */
    public VanillaLocation(Entity entity) {
        this(entity.position(), entity.getXRot(), entity.getYRot(), entity.level());
    }

    /** Creates a new location. */
    public VanillaLocation(Vec3 position, float yaw, float pitch, Level world) {
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
        this.world = world;
    }

    /**
     * Creates a new location builder.
     *
     * @return The builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /** {@inheritDoc} */
    @Override
    public double x() {
        return position.x;
    }

    /** {@inheritDoc} */
    @Override
    public void setX(double x) {
        position = new Vec3(x, y(), z());
    }

    /** {@inheritDoc} */
    @Override
    public double blockX() {
        return Math.floor(x());
    }

    /** {@inheritDoc} */
    @Override
    public double y() {
        return position.y;
    }

    /** {@inheritDoc} */
    @Override
    public void setY(double y) {
        position = new Vec3(x(), y, z());
    }

    /** {@inheritDoc} */
    @Override
    public double blockY() {
        return Math.floor(y());
    }

    /** {@inheritDoc} */
    @Override
    public double z() {
        return position.z;
    }

    /** {@inheritDoc} */
    @Override
    public void setZ(double z) {
        position = new Vec3(x(), y(), z);
    }

    /** {@inheritDoc} */
    @Override
    public double blockZ() {
        return Math.floor(z());
    }

    /** {@inheritDoc} */
    @Override
    public float yaw() {
        return yaw;
    }

    /** {@inheritDoc} */
    @Override
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /** {@inheritDoc} */
    @Override
    public float pitch() {
        return pitch;
    }

    /** {@inheritDoc} */
    @Override
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    /** {@inheritDoc} */
    @Override
    public BlockPos blockPosition() {
        return new BlockPos(blockX(), blockY(), blockZ());
    }

    /** {@inheritDoc} */
    @Override
    public World world() {
        return new VanillaWorld(world);
    }

    /** {@inheritDoc} */
    @Override
    public void setWorld(World world) {
        this.world = ((VanillaWorld) world).world();
    }

    /** {@inheritDoc} */
    public static class Builder implements Location.Builder {
        private Vec3 position = Vec3.ZERO;
        private float yaw = 0;
        private float pitch = 0;
        private Level world = null;

        /** {@inheritDoc} */
        @Override
        public Builder from(Location location) {
            this.position = new Vec3(location.x(), location.y(), location.z());
            this.yaw = location.yaw();
            this.pitch = location.pitch();
            this.world = ((VanillaWorld) location.world()).world();
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Builder position(BlockPos position) {
            this.position = new Vec3(position.x(), position.y(), position.z());
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Builder world(World world) {
            this.world = ((VanillaWorld) world).world();
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Location build() {
            return new VanillaLocation(position, yaw, pitch, world);
        }
    }
}
