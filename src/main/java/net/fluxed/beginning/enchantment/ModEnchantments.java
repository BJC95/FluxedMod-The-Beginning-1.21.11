package net.fluxed.beginning.enchantment;

import net.fluxed.beginning.TheBeginning;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.MovementPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.item.enchantment.effects.ExplodeEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> HOLLOW = ResourceKey.create(Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, "hollow"));
    public static final ResourceKey<Enchantment> SPEAR_WIND_BURST = ResourceKey.create(Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, "burst_back"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);
        HolderGetter<DamageType> holdergetter = context.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> holdergetter1 = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> holdergetter2 = context.lookup(Registries.ITEM);
        HolderGetter<Block> holdergetter3 = context.lookup(Registries.BLOCK);
        HolderGetter<EntityType<?>> holdergetter4 = context.lookup(Registries.ENTITY_TYPE);

        register(context, HOLLOW, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        10,
                        5,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        1,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, "enchantment.hollow"),
                                Attributes.ATTACK_SPEED,
                                LevelBasedValue.perLevel(0.1f),
                                AttributeModifier.Operation.ADD_VALUE)));

        register(context, SPEAR_WIND_BURST, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.SPEARS),
                        5,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .withEffect(
                        EnchantmentEffectComponents.POST_ATTACK,
                        EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.ATTACKER,
                        new ExplodeEffect(
                                false,
                                Optional.empty(),
                                Optional.of(LevelBasedValue.lookup(List.of(1.0F, 1.2F, 1.5F), LevelBasedValue.perLevel(1.5F, 0.15F))),
                                holdergetter3.get(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity()),
                                new Vec3(0.0, 1.0, 0.0),
                                LevelBasedValue.constant(3.5F),
                                false,
                                Level.ExplosionInteraction.TRIGGER,
                                ParticleTypes.WHITE_SMOKE,
                                ParticleTypes.SMOKE,
                                WeightedList.of(),
                                SoundEvents.NOTE_BLOCK_CHIME
                        ),
                        LootItemEntityPropertyCondition.hasProperties(
                                LootContext.EntityTarget.DIRECT_ATTACKER,
                                EntityPredicate.Builder.entity()
                                        .flags(EntityFlagsPredicate.Builder.flags().setIsFlying(false))
                                        .moving(MovementPredicate.horizontalSpeed(MinMaxBounds.Doubles.atLeast(5)))
                        )
                )
        );
    }


    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder) {
        registry.register(key, builder.build(key.identifier()));
    }
}