package com.error22.thelta.craftingcomponents;

public class CraftingComponents {
	public static void preInit() {
		//Here i created an example of how to use it
		new CraftingIngredientItem("exampleingredient");
		//its ItemModel would be in assets.thelts.models.item.exampleingredient.json
		//dont forget to change the lang for item.exampleingredient.name
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		
	}
	
	public static void registerItemRenderers() {
		
	}
	
	public static void registerBlockRenderers() {
		
	}
}
