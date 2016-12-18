package com.error22.thelta.minivox.entities.render;

import com.error22.thelta.Thelta;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;
import com.error22.thelta.minivox.models.ModelMinivox;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderMinivox extends RenderLiving<EntityMinivox>
{
    private static final ResourceLocation VOXTEXTURE = new ResourceLocation(Thelta.MODID+":textures/entity/minivox/Minivox.png");

    public RenderMinivox(RenderManager rmanager)
    {
        super(rmanager, new ModelMinivox(), 0.7F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMinivox entity)
    {
        return VOXTEXTURE;
    }
}