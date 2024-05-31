package dev.neuralnexus.taterlib.config;

import dev.neuralnexus.taterlib.TaterLib;
import dev.neuralnexus.taterlib.logger.AbstractLogger;

import io.leangen.geantyref.TypeToken;

import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.serialize.SerializationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/** Config utilities. */
public class ConfigUtils {
    public static CommentedConfigurationNode getRoot(HoconConfigurationLoader loader) {
        try {
            return loader.load();
        } catch (ConfigurateException e) {
            TaterLib.logger()
                    .error("An error occurred while loading this configuration: " + e.getMessage());
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
            return null;
        }
    }

    public static <T> T get(
            CommentedConfigurationNode root,
            TypeToken<T> typeToken,
            String path,
            AbstractLogger logger) {
        try {
            return root.node(path).get(typeToken);
        } catch (SerializationException e) {
            logger.error(
                    "An error occurred while loading the modules configuration: " + e.getMessage());
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
            return null;
        }
    }

    public static <T> void set(
            CommentedConfigurationNode root,
            TypeToken<T> typeToken,
            String path,
            T value,
            AbstractLogger logger) {
        try {
            root.node(path).set(typeToken, value);
        } catch (SerializationException e) {
            logger.error(
                    "An error occurred while saving the modules configuration: " + e.getMessage());
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
        }
    }

    /** Copy the default configuration to the config folder. */
    public static <T> void copyDefaults(
            Class<T> clazz, Path configPath, String defaultConfigPath, AbstractLogger logger) {
        if (configPath.toFile().exists()) {
            return;
        }
        try {
            Files.createDirectories(configPath.getParent());
            Files.copy(
                    Objects.requireNonNull(
                            clazz.getClassLoader().getResourceAsStream(defaultConfigPath)),
                    configPath);
        } catch (IOException e) {
            logger.error(
                    "An error occurred while copying the default configuration: " + e.getMessage());
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
        }
    }
}
