package net.smileycorp.kinematica.core.client.metal;

import javax.vecmath.Vector3f;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.block.model.IBakedModel;
import 
net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;


public class MetalOverrideList extends ItemOverrideList {
	
	static final MetalOverrideList INSTANCE = new MetalOverrideList();
	
	private static ImmutableMap<TransformType, TRSRTransformation> itemTransforms() {
        TRSRTransformation thirdperson = get(0, 3, 1, 0, 0, 0, 0.55f);
        TRSRTransformation firstperson = get(1.13f, 3.2f, 1.13f, 0, -90, 25, 0.68f);
        ImmutableMap.Builder<TransformType, TRSRTransformation> builder = ImmutableMap.builder();
        builder.put(TransformType.GROUND,                  get(0, 2, 0, 0, 0, 0, 0.5f));
        builder.put(TransformType.HEAD,                    get(0, 13, 7, 0, 180, 0, 1));
        builder.put(TransformType.THIRD_PERSON_RIGHT_HAND, thirdperson);
        builder.put(TransformType.THIRD_PERSON_LEFT_HAND, leftify(thirdperson));
        builder.put(TransformType.FIRST_PERSON_RIGHT_HAND, firstperson);
        builder.put(TransformType.FIRST_PERSON_LEFT_HAND, leftify(firstperson));
        return (ImmutableMap<TransformType, TRSRTransformation>) builder.build();
    }
	
	private static ImmutableMap<TransformType, TRSRTransformation> rodTransforms() {
        TRSRTransformation thirdperson = get(0, 4, 0.5f, 0, -90, 55, 0.85f);
        TRSRTransformation firstperson = get(1.13f, 3.2f, 1.13f, 0, -90, 25, 0.68f);
        ImmutableMap.Builder<TransformType, TRSRTransformation> builder = ImmutableMap.builder();
        builder.put(TransformType.GROUND,                  get(0, 2, 0, 0, 0, 0, 0.5f));
        builder.put(TransformType.HEAD,                    get(0, 13, 7, 0, 180, 0, 1));
        builder.put(TransformType.THIRD_PERSON_RIGHT_HAND, thirdperson);
        builder.put(TransformType.THIRD_PERSON_LEFT_HAND, leftify(thirdperson));
        builder.put(TransformType.FIRST_PERSON_RIGHT_HAND, firstperson);
        builder.put(TransformType.FIRST_PERSON_LEFT_HAND, leftify(firstperson));
        return (ImmutableMap<TransformType, TRSRTransformation>) builder.build();
    }
	
	private static final TRSRTransformation flipX = new TRSRTransformation(null, null, new Vector3f(-1, 1, 1),
            null); 
	
	private static TRSRTransformation leftify(TRSRTransformation transform) {
        return TRSRTransformation.blockCenterToCorner(
                flipX.compose(TRSRTransformation.blockCornerToCenter(transform)).compose(flipX));
    } 
	
	private static TRSRTransformation get(float tx, float ty, float tz, float ax, float ay, float az, float s) {
         return TRSRTransformation.blockCenterToCorner(new TRSRTransformation(
                 new Vector3f(tx / 16, ty / 16, tz / 16),
                 TRSRTransformation.quatFromXYZDegrees(new Vector3f(ax, ay, az)), new Vector3f(s, s, s), null));
     }	
		public MetalOverrideList() {
			super(ImmutableList.of());
		}
		
		@Override
		public IBakedModel handleItemState(IBakedModel base, ItemStack stack, World world, EntityLivingBase entity) {
			MetalType type = ((ItemMetal)stack.getItem()).type;
			String metal = "base";
			if (stack.getItem() instanceof ItemMetal) {
				metal = ((ItemMetal)stack.getItem()).metal;
			}
			IModel model = null;
			
			try {
				model = ModelLoaderRegistry.getModel(ModDefinitions.getResource("metal/"+type.getName().toLowerCase())).retexture(ImmutableMap.of("layer0", type.getName()+"_"+metal));
				//System.out.println("generated model for " + type.getName().toLowerCase() + "_" + metal.toLowerCase());
			} catch (Exception e) {
				model = ModelLoaderRegistry.getMissingModel();
				//System.out.println("could not generate model for " + type.getName().toLowerCase() + "_" + metal.toLowerCase()+" using missing model");
			}
			TextureAtlasSprite sprite = MetalModelLoader.getTexture(type, metal);
			if (type==MetalType.ROD) {
				return new BakedModelMetal(model.bake(model.getDefaultState(), DefaultVertexFormats.ITEM, MetalModelLoader.metalTextureGetter), sprite, rodTransforms());
			} else {
				return new BakedModelMetal(model.bake(model.getDefaultState(), DefaultVertexFormats.ITEM, MetalModelLoader.metalTextureGetter), sprite, itemTransforms());
			}
		}
	}