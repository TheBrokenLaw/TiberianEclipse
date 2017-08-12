package tiberianeclipse.world.biomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Random;

public class ModDecorateBiomeEvent {
    private final World world;
    private final Random rand;
    private final BlockPos pos;

    public ModDecorateBiomeEvent(World world, Random rand, BlockPos pos)
    {
        this.world = world;
        this.rand = rand;
        this.pos = pos;
    }
    public World getWorld()
    {
        return world;
    }

    public Random getRand()
    {
        return rand;
    }

    public BlockPos getPos()
    {
        return pos;
    }
    public static class Pre extends DecorateBiomeEvent
    {
        public Pre(World world, Random rand, BlockPos pos)
        {
            super(world, rand, pos);
        }
    }

    public static class Post extends DecorateBiomeEvent
    {
        public Post(World world, Random rand, BlockPos pos)
        {
            super(world, rand, pos);
        }
    }

    @Event.HasResult
    public static class ModDecorate extends ModDecorateBiomeEvent
    {
        public EventType getType()
        {
            return type;
        }
        public static enum EventType {TibTree, TibCrystal, TibCondensedCrystal, tibBush, tibFlower}

        private final EventType type;

        public ModDecorate(World world, Random rand, BlockPos pos, EventType type)
        {
            super(world, rand, pos);
            this.type = type;
        }
    }
}

