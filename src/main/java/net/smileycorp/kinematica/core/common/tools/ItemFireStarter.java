package net.smileycorp.kinematica.core.common.tools;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class ItemFireStarter extends Item {
	
	public ItemFireStarter() {
		String name = "Firestarter";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		setCreativeTab(KineTabs.TOOLS);
		setMaxStackSize(1);
		setFull3D();
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        return 50;
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			RayTraceResult trace = player.rayTrace(5, 0);
			EnumFacing facing = trace.sideHit;
			BlockPos pos = trace.getBlockPos().offset(facing);
			EnumHand hand = entity.getActiveHand();
			if (Blocks.FIRE.canPlaceBlockAt(world, pos)&&!world.isRainingAt(pos)) {
				if (world.isRemote) {
					world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, (itemRand.nextFloat() - itemRand.nextFloat()) * 0.2F + 1.0F, true);
				}
				if (!player.capabilities.isCreativeMode&&!(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, player.getHeldItem(hand))>0)) {
					stack.shrink(1);
				}
				world.setBlockState(pos, Blocks.FIRE.getDefaultState(), 3);
				if (ForgeEventFactory.onPlayerBlockPlace(player, 
						new BlockSnapshot(world, pos, Blocks.FIRE.getDefaultState()), facing, hand).getResult()==Result.DENY
						&&world.getBlockState(pos).getBlock()==Blocks.FIRE) {
					world.setBlockToAir(pos);
				}
				
			}
		}
        return stack;
    }
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase entity, int count) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			World world = player.world;
			RayTraceResult trace = player.rayTrace(5, 0);
			EnumFacing facing = trace.sideHit;
			BlockPos pos = trace.getBlockPos().offset(facing);
			if (Blocks.FIRE.canPlaceBlockAt(world, pos)&&!world.isRainingAt(pos)) {
				if (world.isRemote&&count%5==1) {
					world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.BLOCK_WOOD_STEP, SoundCategory.PLAYERS, 1.0F, 1.0F, true);
				}
			}
		}
    }
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(world.isRemote){
			return EnumActionResult.PASS;
		}
		BlockPos newpos = pos.offset(facing);
		if ((world.isAirBlock(newpos)||world.getBlockState(newpos).getMaterial()==Material.PLANTS)&&!world.isRainingAt(newpos)) {
			player.setActiveHand(hand);
	        return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
    }
}
