package com.error22.thelta.mobapi;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public class MobListItem {
	public int mobid;
	public String mobname;
	public Class<? extends Entity> entityClass;
	public Render<? extends Entity> renderInstance;
	
	public MobListItem(int mobid, String mobname, Class<? extends Entity> entityClass, Render<? extends Entity> renderInstance) {
		this.mobid = mobid;
		this.mobname = mobname;
		this.entityClass = entityClass;
		this.renderInstance = renderInstance;
	}
}
