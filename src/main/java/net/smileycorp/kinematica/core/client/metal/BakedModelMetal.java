package net.smileycorp.kinematica.core.client.metal;

import java.util.List;

import javax.vecmath.Matrix4f;
import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BakedModelMetal implements IBakedModel {

	private final ImmutableMap<TransformType, TRSRTransformation> transforms;
	private final IBakedModel base;
	private final TextureAtlasSprite sprite;	
	
	public BakedModelMetal(IBakedModel base, TextureAtlasSprite sprite, ImmutableMap<TransformType, TRSRTransformation> transforms) {
		this.base=base;
		this.sprite=sprite;
		this.transforms=transforms;
	}
	
	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		return PerspectiveMapWrapper.handlePerspective(this, transforms, cameraTransformType);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return ItemCameraTransforms.DEFAULT;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side,
			long rand) {
		return base.getQuads(state, side, rand);
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
	public TextureAtlasSprite getParticleTexture() {
		return sprite;
	}

	@Override
	public ItemOverrideList getOverrides() {
		return null;
	}

}
