package net.blay09.mods.farmingforblockheads.compat;

import net.blay09.mods.farmingforblockheads.api.FarmingForBlockheadsAPI;
import net.blay09.mods.farmingforblockheads.api.IMarketRegistryDefaultHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class HarvestcraftAddon {

    private static final String KEY_SEEDS = "Pams Harvestcraft Seeds";
    private static final String KEY_SAPLINGS = "Pams Harvestcraft Saplings";
    private static final String[] SEEDS = new String[]{
            "blackberry", "blueberry", "candleberry", "raspberry", "strawberry", "cactusfruit", "asparagus", "barley",
            "oats", "rye", "corn", "bambooshoot", "cantaloupe", "cucumber", "wintersquash", "zucchini", "beet", "onion",
            "parsnip", "peanut", "radish", "rutabaga", "sweetpotato", "turnip", "rhubarb", "celery", "garlic", "ginger",
            "spiceleaf", "tea", "coffee", "broccoli", "cauliflower", "leek", "lettuce", "scallion", "artichoke",
            "brusselsprout", "cabbage", "spinach", "whitemushroom", "bean", "soybean", "bellpepper", "chilipepper",
            "eggplant", "okra", "peas", "tomato", "cotton", "pineapple", "grape", "kiwi", "cranberry", "rice",
            "seaweed", "curryleaf", "sesameseeds", "waterchestnut", "mustard"
    };

    private static final String[] SAPLINGS = new String[]{
            "apple", "almond", "apricot", "avocado", "banana", "cashew", "cherry", "chestnut", "coconut", "date",
            "dragonfruit", "durian", "fig", "gooseberry", "grapefruit", "lemon", "lime", "mango", "nutmeg", "olive",
            "orange", "papaya", "peach", "pear", "pecan", "peppercorn", "persimmon", "pistachio", "plum", "pomegranate",
            "starfruit", "vanillabean", "walnut", "cinnamon", "maple", "paperbark"
    };

    public HarvestcraftAddon() {
        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SEEDS, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(ItemStack defaultPayment, int defaultAmount) {
                for (String cropName : SEEDS) {
                    String seedName = cropName + "seeditem";
                    Item seedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Compat.HARVESTCRAFT, seedName));
                    if (seedItem != null) {
                        FarmingForBlockheadsAPI.registerMarketEntry(new ItemStack(seedItem, defaultAmount), defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySeeds());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SAPLINGS, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(ItemStack defaultPayment, int defaultAmount) {
                for (String treeName : SAPLINGS) {
                    String saplingName = treeName + "_sapling";
                    Item saplingItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Compat.HARVESTCRAFT, saplingName));
                    if (saplingItem != null) {
                        FarmingForBlockheadsAPI.registerMarketEntry(new ItemStack(saplingItem, defaultAmount), defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });
    }

}
