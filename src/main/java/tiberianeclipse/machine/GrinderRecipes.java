package tiberianeclipse.machine;

import com.google.common.collect.Maps;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GrinderRecipes
{
    private static final GrinderRecipes grindingBase = new GrinderRecipes();
    /** The list of grinding results. */
    private final Map grindingList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public static GrinderRecipes instance()
    {
        return grindingBase;
    }

    private GrinderRecipes()
    {
        addGrindingRecipe(
                new ItemStack(Item.getItemFromBlock(Blocks.STONEBRICK)),
                new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), 0.7F);
        addGrindingRecipe(
                new ItemStack(Item.getItemFromBlock(Blocks.STONE_SLAB)),
                new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), 0.7F);
        addGrindingRecipe(
                new ItemStack(Item.getItemFromBlock(Blocks.STONE_SLAB2)),
                new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), 0.7F);
        addGrindingRecipe(
                new ItemStack(Item.getItemFromBlock(Blocks.STONE_BRICK_STAIRS)),
                new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), 0.7F);
    }

    public void addGrindingRecipe(ItemStack parItemStackIn,
                                  ItemStack parItemStackOut, float parExperience)
    {
        grindingList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    /**
     * Returns the grinding result of an item.
     */
    public ItemStack getGrindingResult(ItemStack parItemStack)
    {
        Iterator iterator = grindingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry
                .getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1,
                                       ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem()
                && (parItemStack2.getMetadata() == 32767
                || parItemStack2.getMetadata() == parItemStack1
                .getMetadata());
    }

    public Map getGrindingList()
    {
        return grindingList;
    }

    public float getGrindingExperience(ItemStack parItemStack)
    {
        Iterator iterator = experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack,
                (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}