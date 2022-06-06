package com.hammergames.featuresandcreatures.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WispEntity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public WispEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {return Animal.createMobAttributes()
            .add(Attributes.MAX_HEALTH,10.0d)
            .add(Attributes.ATTACK_DAMAGE, 8.0f)
            .add(Attributes.ATTACK_SPEED, 2.0f)
            .add(Attributes.MOVEMENT_SPEED, 2.0f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25d));
        //this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0d, 10.0f, 2.0f,true));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0d));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    protected SoundEvent getAmbientSound() {return SoundEvents.CAT_AMBIENT;}
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.DOLPHIN_HURT;}
    protected SoundEvent getDeathSound() {return SoundEvents.DOLPHIN_DEATH;}
    protected float getSoundVolume() {return 0.2f;}



    /* ANIMATIONS */

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


}
