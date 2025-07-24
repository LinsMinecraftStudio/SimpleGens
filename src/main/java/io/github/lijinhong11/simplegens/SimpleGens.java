package io.github.lijinhong11.simplegens;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpleGens extends JavaPlugin {
    private static SimpleGens instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static SimpleGens getInstance() {
        return instance;
    }
}
