package com.error22.thelta.minivox;

import com.error22.thelta.Thelta;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MinivoxSoundEvents {
	public static SoundEvent ENTITY_MINIVOX_IDLE;
	public static SoundEvent ENTITY_MINIVOX_ATTACK;
	public static SoundEvent ENTITY_MINIVOX_TAKEDAMAGE;
	public static SoundEvent ENTITY_MINIVOX_POOP;
	public static SoundEvent ENTITY_MINIVOX_WALK;
	public static SoundEvent ENTITY_MINIVOX_FALL;
	public static SoundEvent ENTITY_MINIVOX_DEATH;
	
	public static void registerSoundEvents() {
		ENTITY_MINIVOX_IDLE			= registerSound("entity.minivox.idle");
		ENTITY_MINIVOX_ATTACK		= registerSound("entity.minivox.attack");
		ENTITY_MINIVOX_TAKEDAMAGE	= registerSound("entity.minivox.takedamage");
		ENTITY_MINIVOX_POOP			= registerSound("entity.minivox.poop");
		ENTITY_MINIVOX_WALK			= registerSound("entity.minivox.walk");
		ENTITY_MINIVOX_FALL			= registerSound("entity.minivox.fall");
		ENTITY_MINIVOX_DEATH		= registerSound("entity.minivox.death");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(Thelta.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}

}
