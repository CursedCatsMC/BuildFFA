package de.maifii.buildffa.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public void setItemInInv(Inventory inventory, Material material, String name, Integer slot, Integer zahl) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        item.setAmount(zahl);
        inventory.setItem(slot, item);
    }

    public void addItemInInventory(Inventory inventory, Material material, String displayName, Integer amount) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        item.setAmount(amount);
        inventory.addItem(new ItemStack[]{item});
    }

    public void setItemInInventoryWithEnchantment(Inventory inventory, Material material, String name, Enchantment enchantment, Integer enchantmentValue, Integer slot) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.addEnchant(enchantment, enchantmentValue, true);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        inventory.setItem(slot, item);
    }
}



