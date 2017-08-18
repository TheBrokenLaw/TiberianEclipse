package tiberianeclipse.item;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.ClientProxy;
import tiberianeclipse.item.tools.*;
import tiberianeclipse.util.IModelProvider;

public class ModItems extends ClientProxy{
    // Tiberium Varieties
    public static ItemBase ripariusShard;
    public static ItemBase viniferaShard;
    public static ItemBase cruentusShard;
    public static ItemBase arboreaShard;
    public static ItemBase ripariusCluster;
    public static ItemBase viniferaCluster;
    public static ItemBase cruentusCluster;
    public static ItemBase arboreaCluster;
    public static ItemBase ripVinCluster;
    public static ItemBase vinRipCluster;
    public static ItemBase vinCruCluster;
    public static ItemBase cruVinCluster;
    public static ItemBase cruArborCluster;
    public static ItemBase arborCruCluster;
    public static ItemBase ripDustedIron;
    public static ItemBase ripDustedGold;
    public static ItemBase vinDustedIron;
    public static ItemBase vinDustedGold;
    public static ItemBase cruDustedIron;
    public static ItemBase cruDustedGold;
    public static ItemBase arbDustedIron;
    public static ItemBase arbDustedGold;
    //Tools
    public static ItemBase refinedTibRod;
    public static ItemBase tibHammer;
        //Swords
    public static BaseSword refTibSword;
    public static BaseSword ripariusBlade;
    public static BaseSword viniferaBlade;
    public static BaseSword cruentusBlade;
    public static BaseSword arboreaBlade;
        //Picks
    public static BasePick refTibPick;
/*    public static BasePick ripariusPick;
    public static BasePick viniferaPick;
    public static BasePick cruentusPick;
    public static BasePick arboreaPick;
*/       //Shovels
    public static BaseShovel refTibShovel;
/*    public static BaseShovel ripariusShovel;
    public static BaseShovel viniferaShovel;
    public static BaseShovel cruentusShovel;
    public static BaseShovel arboreaShovel;
*/        //Axes
    public static BaseAxe refTibAxe;
/*    public static BaseAxe ripariusAxe;
    public static BaseAxe viniferaAxe;
    public static BaseAxe cruentusAxe;
    public static BaseAxe arboreaAxe;
*/        //Music Discs
    public static ItemRecordRainNite recordRainNite;
    public static ItemRecordWhatLurks recordWhatLurks;
        //Intermediate Items
    public static ItemBase crushedRiparius;
    public static ItemBase crushedVinifera;
    public static ItemBase crushedCruentus;
    public static ItemBase crushedArborea;
        //Armor
    public static ModArmor basicHelm;
    public static ModArmor basicChest;
    public static ModArmor basicLegs;
    public static ModArmor basicFeet;
    public static ItemBase refinedTiberium;

    public static DummyItem dummyItem;
    public static void init() {
        //Tiberium shards and clusters
        ripariusShard = register(new ItemBase("ripariusShard",0));
        viniferaShard = register(new ItemBase("viniferaShard",0));
        cruentusShard = register(new ItemBase("cruentusShard",0));
        arboreaShard = register(new ItemBase("arboreaShard",0));
        ripariusCluster =register(new ItemBase("ripariusCluster",0));
        viniferaCluster = register(new ItemBase("viniferaCluster",0));
        cruentusCluster = register(new ItemBase("cruentusCluster",0));
        arboreaCluster = register(new ItemBase("arboreaCluster",0));
        ripVinCluster =register(new ItemBase("ripVinCluster",0));
        vinRipCluster = register(new ItemBase("vinRipCluster",0));
        vinCruCluster = register(new ItemBase("vinCruCluster",0));
        cruVinCluster = register(new ItemBase("cruVinCluster",0));
        cruArborCluster =register(new ItemBase("cruArborCluster",0));
        arborCruCluster = register(new ItemBase("arborCruCluster",0));
        refinedTiberium = register(new ItemBase("refinedTiberium",0));
        crushedRiparius=register(new ItemBase("crushedRiparius",0));
        crushedVinifera=register(new ItemBase("crushedVinifera",0));
        crushedCruentus=register(new ItemBase("crushedCruentus",0));
        crushedArborea=register(new ItemBase("crushedArborea",0));

        //Tiberium Tools
        tibHammer=register(new TibHammer());
            //Swords
        refTibSword=register(new BaseSword(BaseTool.refinedTibMaterial,"refTibSword"));
        ripariusBlade = register(new BaseSword(BaseTool.riparius, "ripariusBlade"));
        viniferaBlade = register(new BaseSword(BaseTool.vinifera, "viniferaBlade"));
        cruentusBlade = register(new BaseSword(BaseTool.cruentus, "cruentusBlade"));
        arboreaBlade = register(new BaseSword(BaseTool.arborea, "arboreaBlade"));
            //Picks
        refTibPick= register(new BasePick(BaseTool.refinedTibMaterial,"refTibPick"));
    /*  ripariusPick = register(new BasePick(BaseTool.riparius, "ripariusPick"));
        viniferaPick = register(new BasePick(BaseTool.vinifera, "viniferaPick"));
        cruentusPick = register(new BasePick(BaseTool.cruentus, "cruentusPick"));
        arboreaPick = register(new BasePick(BaseTool.arborea, "arboreaPick"));
    */         //Axes
        refTibAxe=register(new BaseAxe(BaseTool.refinedTibMaterial,"refTibAxe"));
    /*  ripariusShovel = register(new BaseShovel(BaseTool.riparius, "ripariusShovel"));
        viniferaShovel = register(new BaseShovel(BaseTool.vinifera, "viniferaShovel"));
        cruentusShovel = register(new BaseShovel(BaseTool.cruentus, "cruentusShovel"));
        arboreaShovel = register(new BaseShovel(BaseTool.arborea, "arboreaShovel"));
    */         //Shovels
        refTibShovel=register(new BaseShovel(BaseTool.refinedTibMaterial,"refTibShovel"));
    /*    ripariusAxe = register(new BaseAxe(BaseTool.riparius, "ripariusAxe"));
        viniferaAxe = register(new BaseAxe(BaseTool.vinifera, "viniferaAxe"));
        cruentusAxe = register(new BaseAxe(BaseTool.cruentus, "cruentusAxe"));
        arboreaAxe = register(new BaseAxe(BaseTool.arborea, "arboreaAxe"));
    */  refinedTibRod = register(new ItemBase("refinedTibRod",0));
                //Music discs
      recordRainNite=new ItemRecordRainNite();
        recordWhatLurks=new ItemRecordWhatLurks();
                //Armor
        basicChest=register(new ModArmor("basicChest",ModItems.basic, EntityEquipmentSlot.CHEST,1));
        basicHelm=register(new ModArmor("basicHelm",ModItems.basic, EntityEquipmentSlot.HEAD ,0));
        basicLegs=register(new ModArmor("basicLegs",ModItems.basic, EntityEquipmentSlot.LEGS,2));
        basicFeet=register(new ModArmor( "basicFeet",ModItems.basic, EntityEquipmentSlot.FEET,3));
                //Misc
        ripDustedIron=register(new ItemBase("ripDustedIron", 0));
        ripDustedGold=register(new ItemBase("ripDustedGold", 0));
        vinDustedIron=register(new ItemBase("vinDustedIron", 0));
        vinDustedGold=register(new ItemBase("vinDustedGold", 0));
        cruDustedIron=register(new ItemBase("cruDustedIron", 0));
        cruDustedGold=register(new ItemBase("cruDustedGold", 0));
        arbDustedIron=register(new ItemBase("arbDustedIron", 0));
        arbDustedGold=register(new ItemBase("arbDustedGold", 0));

        dummyItem=register(new DummyItem());
    }
    public static ItemArmor.ArmorMaterial basic = EnumHelper.addArmorMaterial("BASIC", "tiberianeclipse:basicArmor", 60, new int[]{4, 9, 7, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof IModelProvider) {
            ((IModelProvider) item).registerItemModel(item, 0);
        }

        return item;
    }
}