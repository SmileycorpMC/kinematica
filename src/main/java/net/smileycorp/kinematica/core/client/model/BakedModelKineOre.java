package net.smileycorp.kinematica.core.client.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.world.blocks.BlockOreBase;

public class BakedModelKineOre extends BakedModelWrapper<IBakedModel>  {
	
	protected TextureAtlasSprite particle = null;
	
	public BakedModelKineOre(IBakedModel baked, IModel base) {
		super(baked);
	}
	
	@Override
    public TextureAtlasSprite getParticleTexture() {
        return particle == null ? Minecraft.getMinecraft().getBlockRendererDispatcher().getModelForState(Blocks.STONE.getDefaultState())
        		.getQuads(Blocks.STONE.getDefaultState(), EnumFacing.UP, 0).get(0).getSprite()  :
        			particle;
    }
	
	@Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing facing, long rand) {
		try {
			Minecraft mc = Minecraft.getMinecraft();
			ResourceLocation location = ModDefinitions.getResource("blocks/ores/"+state.getBlock().getRegistryName().getResourcePath());
			List<BakedQuad> quads = new ArrayList<BakedQuad>();
			BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();
			IBlockState backgroundState;
			if (state instanceof IExtendedBlockState && ((IExtendedBlockState) state).getUnlistedProperties().containsKey(BlockOreBase.BACKGROUND)) {
				String background = ((IExtendedBlockState) state).getValue(BlockOreBase.BACKGROUND);
				//System.out.println(background);
				ResourceLocation backgroundLoc;
				if (background!=null) {
					String[] split = background.split(":");
					if (split.length>1) {
						backgroundLoc = new ResourceLocation(split[0], split[1]);
					} else {
						backgroundLoc = new ResourceLocation(background);
					}
					Block backgroundBlock = ForgeRegistries.BLOCKS.getValue(backgroundLoc);
					backgroundState = backgroundBlock.getDefaultState();
					if (split.length>2) {
						try {
							int meta = Integer.valueOf(split[2]);
							backgroundState = backgroundBlock.getStateFromMeta(meta);
						} catch(Exception e) {}
					}	
				} else {
					backgroundState = Blocks.STONE.getDefaultState();
				}
				
				IBakedModel backgroundModel = dispatcher.getModelForState(backgroundState);
				//TextureAtlasSprite sprite = new TextureAtlasLayered(location,  backgroundModel.getQuads(backgroundState, facing, rand).get(0).getSprite(), textures.get(location));
				
				quads.addAll(backgroundModel.getQuads(backgroundState, facing, rand));
				if (particle == null && !quads.isEmpty()) {
					particle = quads.get(0).getSprite();
				}
				if (facing!=null) {
					quads.addAll(RenderingUtils.getQuadsForPlane(facing, Color.WHITE, location.toString()));
				}
			}
			
			return quads;
		} catch (Exception e) {
			e.printStackTrace();
			return originalModel.getQuads(state, facing, rand);
		}
       
    }

    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return null;
    }

}
