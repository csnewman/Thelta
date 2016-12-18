package com.error22.thelta.pipeline;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IPipelineAware {

	void definePipeline(TheltaPipeline pipeline);

	@SideOnly(Side.CLIENT)
	void defineClientPipeline(TheltaPipeline pipeline);
	
	@SideOnly(Side.SERVER)
	void defineServerPipeline(TheltaPipeline pipeline);

}
