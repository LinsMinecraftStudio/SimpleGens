package io.github.lijinhong11.simplegens.gens;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class GenDrop {
    private final String id;
    private Material dropItemMaterial;
    private double economyValue;

    public GenDrop(String id, Material drop, double economyValue) {
        this.id = id;
        this.dropItemMaterial = drop;
        this.economyValue = economyValue;
    }

    public String getId() {
        return id;
    }

    public void setDropItemMaterial(Material dropItemMaterial) {
        this.dropItemMaterial = dropItemMaterial;
    }

    public Material getDropItemMaterial() {
        return dropItemMaterial;
    }

    public void setEconomyValue(double economyValue) {
        if (economyValue < 0) {
            throw new IllegalArgumentException("economyValue must be greater than or equal to 0");
        }

        this.economyValue = economyValue;
    }

    public double getEconomyValue() {
        return economyValue;
    }

    private ItemStack generateItem() {
        ItemStack drop = new ItemStack(dropItemMaterial);
        drop.editMeta(m -> {

        });

        return drop;
    }

    void publishDrop(Location genLoc) {
        Location loc = findChestOrEmpty(genLoc);
        if (loc == null) {
            return;
        }

        Block block = loc.getBlock();
        World w = block.getWorld();

        if (block.getState() instanceof Chest c) {
            c.getInventory().addItem(generateItem());
        } else {
            w.dropItemNaturally(loc, generateItem());
        }
    }

    private Location findChestOrEmpty(Location genLoc) {
        Location clone = genLoc.clone();
        for (int i = genLoc.getBlockY() + 1; i < (319 - genLoc.getBlockY()); i++) {
            clone.setY(i);
            Block block = clone.getBlock();
            Material type = block.getType();
            if (type == Material.CHEST || type == Material.TRAPPED_CHEST || type == Material.AIR) {
                return clone;
            }
        }

        return null;
    }
}
