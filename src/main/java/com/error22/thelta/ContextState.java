package com.error22.thelta;

public enum ContextState {
	Uninitialized,
	Intermediary,
	ConfigLoading,
	Initialization,
	BlockRegistration,
	ItemRegistration,
	RecipeRegistration,
	
	//Edit: rater193 (Added this for letting the modules register world gen blocks)
	WorldgenRegistration,
	//End Edit
	
	SoundRegistration,
	EntityRegistration,
	RendererRegistration,
	ModelRegistration,
	LoadingModels,
	LoadingTextures,
	LateInitialization,
	PostInitialization,
	Finished
}
