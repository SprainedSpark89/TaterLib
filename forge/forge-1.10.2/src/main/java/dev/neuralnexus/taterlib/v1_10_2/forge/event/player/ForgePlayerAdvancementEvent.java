package dev.neuralnexus.taterlib.v1_10_2.forge.event.player;

import dev.neuralnexus.taterlib.event.player.PlayerAdvancementEvent;
import dev.neuralnexus.taterlib.player.Player;
import dev.neuralnexus.taterlib.v1_10_2.forge.player.ForgePlayer;
import java.util.Collection;
import java.util.Collections;
import net.minecraftforge.event.entity.player.AchievementEvent;

/** Forge implementation of {@link PlayerAdvancementEvent}. */
public class ForgePlayerAdvancementEvent implements PlayerAdvancementEvent {
    private final AchievementEvent event;

    public ForgePlayerAdvancementEvent(AchievementEvent event) {
        this.event = event;
    }

    /** {@inheritDoc} */
    @Override
    public String advancement() {
        return event.getAchievement().getStatName().getFormattedText();
    }

    /** {@inheritDoc} */
    @Override
    public Player player() {
        return new ForgePlayer(event.getEntityPlayer());
    }

    /** Forge implementation of {@link PlayerAdvancementEvent.AdvancementFinished}. */
    public static class AdvancementFinished extends ForgePlayerAdvancementEvent
            implements PlayerAdvancementEvent.AdvancementFinished {
        public AdvancementFinished(AchievementEvent event) {
            super(event);
        }
    }

    /** Forge implementation of {@link PlayerAdvancementEvent.AdvancementProgress}. */
    public static class AdvancementProgress extends ForgePlayerAdvancementEvent
            implements PlayerAdvancementEvent.AdvancementProgress {
        private final AchievementEvent event;

        public AdvancementProgress(AchievementEvent event) {
            super(event);
            this.event = event;
        }

        /** {@inheritDoc} */
        @Override
        public Collection<String> criterion() {
            return Collections.singleton(this.event.getAchievement().getCriteria().getName());
        }
    }
}
