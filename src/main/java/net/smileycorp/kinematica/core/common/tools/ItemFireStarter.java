package net.smileycorp.kinematica.core.common.tools;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ItemFireStarter extends Item {

	private final boolean isTinderbox;

	public ItemFireStarter(boolean isTinderbox) {
		super(new Properties().rarity(isTinderbox ? Rarity.RARE : Rarity.UNCOMMON).stacksTo(1).durability(isTinderbox ? 72 : 0));
		this.isTinderbox = isTinderbox;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return isTinderbox ? 20 : 50;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (entity instanceof Player) {
			Player player = (Player) entity;
			HitResult result = player.pick(5, 0, true);
			if (result instanceof BlockHitResult) {
				BlockHitResult blockresult = (BlockHitResult) result;
				BlockPos pos = blockresult.getBlockPos();
				InteractionHand hand = entity.getUsedItemHand();
				BlockState blockstate = level.getBlockState(pos);
				if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
					Direction dir = blockresult.getDirection();
					BlockPos placePos = pos.relative(dir);
					if (BaseFireBlock.canBePlacedAt(level, placePos, dir)) {
						level.playSound(player, placePos, isTinderbox ? SoundEvents.FLINTANDSTEEL_USE : SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
						BlockState fire = BaseFireBlock.getState(level, placePos);
						level.setBlock(placePos, fire, 11);
						level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);
						if (player instanceof ServerPlayer) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, placePos, stack);
							stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
						}
					}
				} else {
					level.playSound(player, pos, isTinderbox ? SoundEvents.FLINTANDSTEEL_USE : SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
					level.setBlock(pos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
					level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);
					if (player != null) {
						stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
					}
				}
			}
		}
		return stack;
	}

	@Override
	public void onUsingTick(ItemStack stack, LivingEntity entity, int duration) {
		Level level = entity.level;
		level.playSound(null, entity.blockPosition(), isTinderbox ? SoundEvents.COPPER_STEP : SoundEvents.WOOD_STEP, SoundSource.PLAYERS, 1F, 1F);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		player.startUsingItem(hand);
		return InteractionResultHolder.success(itemstack);
	}

}
