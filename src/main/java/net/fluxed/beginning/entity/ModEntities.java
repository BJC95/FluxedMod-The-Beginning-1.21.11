package net.fluxed.beginning.entity;

import net.fluxed.beginning.TheBeginning;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TheBeginning.MOD_ID);

//    public static ResourceKey<EntityType<?>> JAVELIN_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.withDefaultNamespace("javelin"));
//
//    public static final Supplier<EntityType<JavelinEntity>> JAVELIN =
//            ENTITY_TYPES.register("javelin", () -> EntityType.Builder.<JavelinEntity>of(JavelinEntity::new, MobCategory.MISC)
//                    .sized(0.5f, 1.15f).build(JAVELIN_KEY));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
}
}
