package tiberianeclipse.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntityDamageSourceIndirect;

public class EntityDamageSourceTiberiumRadiation extends EntityDamageSourceIndirect {
    public EntityDamageSourceTiberiumRadiation (String name, Entity transmitter, Entity indirectSource){
        super(name, transmitter, indirectSource);
        this.setDamageBypassesArmor();
    }

}
