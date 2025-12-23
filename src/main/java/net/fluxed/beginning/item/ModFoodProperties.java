package net.fluxed.beginning.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodProperties {
    public static final FoodProperties FLOAT_BERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f)
            .alwaysEdible().build();

    public static final Consumable FLOAT_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, 1), 1f)).build();
    public static final Consumable STRONG_FLOAT_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 3), 1f)).build();
}
