package com.dbydd.suuuuuper_herbal_tea.registeried_lists;

import com.dbydd.suuuuuper_herbal_tea.Suuuuuuuper_herbal_tea;
import com.dbydd.suuuuuper_herbal_tea.blocks.tileentitys.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//fuck it
public class Registered_TileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILEENTITY_TYPE_REGISTER = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Suuuuuuuper_herbal_tea.NAME);
    public static final RegistryObject<TileEntityType<TileBig_Black_Pot>> TilE_BIG_BLACK_POT_TYPE = TILEENTITY_TYPE_REGISTER.register("big_black_pot_tileentity", ()->TileEntityType.Builder.create(TileBig_Black_Pot::new, Registered_Blocks.BIG_BLACK_POT).build(null));
    public static final RegistryObject<TileEntityType<TileEarth_Stovetop>> TILE_EARTH_STOVETOP_TYPE = TILEENTITY_TYPE_REGISTER.register("earth_stovetop_tileentity", ()->TileEntityType.Builder.create(TileEarth_Stovetop::new, Registered_Blocks.EARTH_STOVETOP).build(null));
    public static final RegistryObject<TileEntityType<TileStone_Table>> TILE_STONE_TABLE_TYPE = TILEENTITY_TYPE_REGISTER.register("stone_table", ()->TileEntityType.Builder.create(TileStone_Table::new,Registered_Blocks.STONE_TABLE).build(null));
    public static final RegistryObject<TileEntityType<TileTeaCup>> TEA_CUP = TILEENTITY_TYPE_REGISTER.register("tea_cup",()->TileEntityType.Builder.create(TileTeaCup::new, Registered_Blocks.TEA_CUP).build(null));
    public static final RegistryObject<TileEntityType<TileSink>> TILE_SINK = TILEENTITY_TYPE_REGISTER.register("sink", ()->TileEntityType.Builder.create(TileSink::new, Registered_Blocks.SINK).build(null));
}
