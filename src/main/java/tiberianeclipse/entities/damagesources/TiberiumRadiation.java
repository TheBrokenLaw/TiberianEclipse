package tiberianeclipse.entities.damagesources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntityDamageSourceIndirect;

public class TiberiumRadiation extends EntityDamageSourceIndirect {
    public TiberiumRadiation(String name, Entity transmitter, Entity indirectSource){
        super(name, transmitter, indirectSource);
        this.setDamageBypassesArmor();
    }

}
