package com.error22.thelta.pipeline;

import java.util.ArrayList;
import java.util.List;

class PipelineNode {
	private List<PipelineNode> dependencies;
	private PipelineStage stage;

	public PipelineNode(PipelineStage stage) {
		dependencies = new ArrayList<PipelineNode>();
		this.stage = stage;
	}

	public PipelineStage getStage() {
		return stage;
	}

	public void addDependency(PipelineNode node) {
		if (!dependencies.contains(node)) {
			dependencies.add(node);
		}
	}

	public List<PipelineNode> getDependencies() {
		return dependencies;
	}

	public String getName() {
		return stage != null ? stage.getName() : "root";
	}
}
