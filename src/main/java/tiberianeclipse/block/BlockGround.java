package tiberianeclipse.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockGround extends BlockBase {
    public float hardness;
    public float resistance;
    public BlockGround(Material material, String name,float hardness, float resistance){
        super(material, name,"spade", 0);
        this.hardness=hardness;
        this.resistance=resistance;
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(SoundType.GROUND);
    //    this.setHarvestLevel("spade",0);
    }
}
