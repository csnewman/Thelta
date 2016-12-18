package com.error22.thelta.mobapi;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;

public class MobListItem {
	public int mobid;
	public String mobname;
	public Class<? extends Entity> entityClass;
	public Class<? extends RenderLiving> renderClass;
	
	public MobListItem(int mobid, String mobname, Class<? extends Entity> entityClass, Class<? extends RenderLiving> renderClass) {
		this.mobid = mobid;
		this.mobname = mobname;
		this.entityClass = entityClass;
		this.renderClass = renderClass;
	}
}
