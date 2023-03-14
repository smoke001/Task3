package me.smokesh.task3;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Task3 extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("pet").setExecutor((sender, a, b, args) -> {
            Player player = (Player) sender;
            ArmorStand armorStand = (ArmorStand)player.getWorld().spawnEntity(player.getLocation().add(0.8, 0.9, 0), EntityType.ARMOR_STAND);
            armorStand.setHelmet(new ItemStack(Material.PUMPKIN));
            armorStand.setSmall(true);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location base = player.getLocation();
                    base.add(0.8, 0.9, 0);
                    armorStand.teleport(base);
                }
            }.runTaskTimer(this, 0L, 1L);
            return true;
        });
    }

    @Override
    public void onDisable() {
    }

}
