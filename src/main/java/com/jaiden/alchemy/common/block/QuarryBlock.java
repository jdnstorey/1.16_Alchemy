package com.jaiden.alchemy.common.block;

import com.jaiden.alchemy.client.gui.QuarryGUI;
import com.jaiden.alchemy.common.container.QuarryContainer;
import com.jaiden.alchemy.common.tileentity.QuarryTileEntity;
import com.jaiden.alchemy.core.init.TileEntityTypesInit;
import io.netty.util.internal.SuppressJava6Requirement;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class QuarryBlock extends Block {

    public QuarryBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(15f)
                .sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.QUARRY_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public ActionResultType use(BlockState blockState, World world,
                                BlockPos blockPos, PlayerEntity player,
                                Hand hand, BlockRayTraceResult hit) {
        TileEntity tile = world.getBlockEntity(blockPos);
        if(tile instanceof QuarryTileEntity && player instanceof ServerPlayerEntity) {
            QuarryTileEntity te = (QuarryTileEntity) tile;
            IContainerProvider provider = QuarryContainer.getServerContainerProvider(te, blockPos);
            INamedContainerProvider namedProvider = new SimpleNamedContainerProvider(provider, QuarryContainer.title);
            System.out.println("Player: " + player + " - Provider: " + provider + " - NamedProv: " + namedProvider);
            NetworkHooks.openGui((ServerPlayerEntity) player, namedProvider);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
        return ActionResultType.SUCCESS;
    }
}
