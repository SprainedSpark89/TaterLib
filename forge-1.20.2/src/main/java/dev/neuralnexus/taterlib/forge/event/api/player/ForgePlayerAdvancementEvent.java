package dev.neuralnexus.taterlib.forge.event.api.player;

import dev.neuralnexus.taterlib.common.event.player.PlayerAdvancementEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import java.util.Collection;

/**
 * Forge implementation of {@link PlayerAdvancementEvent}.
 */
public class ForgePlayerAdvancementEvent extends ForgePlayerEvent implements PlayerAdvancementEvent {
    private final AdvancementEvent event;

    public ForgePlayerAdvancementEvent(AdvancementEvent event) {
        super(event);
        this.event = event;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getAdvancement() {
        if (!this.event.getAdvancement().value().name().isPresent()) {
            if (this.event.getAdvancement().value().parent().isPresent()) {
                return this.event.getAdvancement().value().parent().get().getNamespace();
            } else {
                return "";
            }
        }
        return this.event.getAdvancement().value().name().get().getString();
    }

    /**
     * Forge implementation of {@link AdvancementFinished}.
     */
    public static class ForgeAdvancementFinished extends ForgePlayerAdvancementEvent implements AdvancementFinished {
        public ForgeAdvancementFinished(AdvancementEvent.AdvancementEarnEvent event) {
            super(event);
        }
    }

    /**
     * Forge implementation of {@link AdvancementProgress}.
     */
    public static class ForgeAdvancementProgress extends ForgePlayerAdvancementEvent implements AdvancementProgress {
        private final AdvancementEvent.AdvancementProgressEvent event;

        public ForgeAdvancementProgress(AdvancementEvent.AdvancementProgressEvent event) {
            super(event);
            this.event = event;
        }

        /**
         * @inheritDoc
         */
        @Override
        public Collection<String> getCriterion() {
            Iterable<String> criteria = this.event.getAdvancementProgress().getRemainingCriteria();
            Collection<String> collection = new java.util.ArrayList<>();
            criteria.iterator().forEachRemaining(collection::add);
            return collection;
        }
    }
}
