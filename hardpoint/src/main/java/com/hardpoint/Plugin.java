package com.hardpoint;

import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.ImmutableMap;

import com.hardpoint.hardpoint.FileManagement;
import com.hardpoint.hardpoint.HardPointGestion;

/*
 * hardpoint java plugin
 */
public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("hardpoint");

  public void onEnable() {

    Map<String, Boolean> names = ImmutableMap.of(
        "test.yml", false,
        "hardpoint.yml", false,
        "schematics", true);
    FileManagement fileManagement = new FileManagement(this, names);

    getCommand("hardpoint").setExecutor(new HardPointGestion(this, fileManagement));
  }

  public void onDisable() {
    LOGGER.info("hardpoint disabled");
  }
}
