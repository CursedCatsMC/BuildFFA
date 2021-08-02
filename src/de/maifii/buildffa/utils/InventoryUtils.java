package de.maifii.buildffa.utils;


import de.maifii.buildffa.BuildFFA;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryUtils {
    public void setEquipment(Player spieler) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.spigot().setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);
        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.spigot().setUnbreakable(true);
        chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(chestplateMeta);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        leggingsMeta.spigot().setUnbreakable(true);
        leggings.setItemMeta(leggingsMeta);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.spigot().setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        spieler.getEquipment().setHelmet(helmet);
        spieler.getEquipment().setChestplate(chestplate);
        spieler.getEquipment().setLeggings(leggings);
        spieler.getEquipment().setBoots(boots);
    }

    public void setInventory(Player spieler) {
        ItemUtils items = new ItemUtils();
        items.setItemInInventoryWithEnchantment(spieler.getInventory(), Material.IRON_SWORD, "", Enchantment.DAMAGE_ALL, 1, 0);
        items.setItemInInventoryWithEnchantment(spieler.getInventory(), Material.STICK, "", Enchantment.KNOCKBACK, 1, 1);
        items.setItemInInventory(spieler.getInventory(), Material.ENDER_PEARL, "", 2, 2);
        items.setItemInInventory(spieler.getInventory(), Material.SANDSTONE, "", 3, 64);
        items.setItemInInventory(spieler.getInventory(), Material.SANDSTONE, "", 4, 64);
        items.setItemInInventory(spieler.getInventory(), Material.SANDSTONE, "", 5, 64);
        items.setItemInInventory(spieler.getInventory(), Material.SANDSTONE, "", 6, 64);
        items.setItemInInventory(spieler.getInventory(), Material.SANDSTONE, "", 7, 64);
        items.setItemInInventory(spieler.getInventory(), Material.LADDER, "", 8, 4);
    }

    public void addEnderPearl(Player player) {
        ItemUtils items = new ItemUtils();
        items.addItemInInventory(player.getInventory(), Material.ENDER_PEARL, "", 1);
    }

}