package com.error22.thelta.minivox;

import com.error22.thelta.Thelta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderMinivox extends RenderLiving<EntityMinivox>
{
	
    private static final ResourceLocation VOXTEXTURE = new ResourceLocation(Thelta.MODID+":textures/entity/minivox/Minivox.png");
    
    public RenderMinivox()
    {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelMinivox(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMinivox entity)
    {
        return VOXTEXTURE;
    }
}
