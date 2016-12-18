package com.error22.thelta.mobapi;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;

public class MobRenderListItem {
	
	public Class<? extends Entity> entityClass;
	public Class<? extends RenderLiving> renderClass;

	public MobRenderListItem(Class<? extends Entity> entityClass, Class<? extends RenderLiving> renderClass) {
		this.entityClass = entityClass;
		this.renderClass = renderClass;
	}

}
