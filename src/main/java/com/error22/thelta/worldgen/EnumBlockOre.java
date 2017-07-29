package com.error22.thelta.worldgen;

import net.minecraft.init.Blocks;

public enum EnumBlockOre {
	Copper(
			"oreCopper",
			"thelta_world:ores/copper",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(1, 9, 10, 0, 40)),
	Lead(
			"oreLead",
			"thelta_world:ores/lead",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(2, 9, 10, 0, 50)),
	Tin(
			"oreTin",
			"thelta_world:ores/tin",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(1, 9, 10, 0, 40)),
	Magnesium(
			"oreMagnesium",
			"thelta_world:ores/magnesium",
			"pickaxe",
			3,
			5f,
			5f,
			new GenerationInformation(5, 15, 8, 0, 20)),
	Aluminum(
			"oreAluminum",
			"thelta_world:ores/aluminum",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(1, 10, 10, 0, 40)),
	Nickel(
			"oreNickel",
			"thelta_world:ores/nickel",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(3, 10, 8, 40, 60)),
	Zinc(
			"oreZinc",
			"thelta_world:ores/zinc",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 20, 40)),
	Sulfur(
			"oreSulfur",
			"thelta_world:ores/sulfur",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(10, 20, 8, 0, 20, Blocks.LAVA)),
	Onyx(
			"oreOnyx",
			"thelta_world:ores/onyx",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Ruby(
			"oreRuby",
			"thelta_world:ores/ruby",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Sapphire(
			"oreSapphire",
			"thelta_world:ores/sapphire_blue",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Jade(
			"oreJade",
			"thelta_world:ores/jade",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Silver(
			"oreSilver",
			"thelta_world:ores/silver",
			"pickaxe",
			1,
			5f,
			5f,
			new GenerationInformation(3, 9, 8, 10, 40)),
	Tungsten(
			"oreTungsten",
			"thelta_world:ores/tungsten",
			"pickaxe",
			3,
			5f,
			5f,
			new GenerationInformation(2, 4, 8, 10, 20)),
	Uranium(
			"oreUranium",
			"thelta_world:ores/uranium",
			"pickaxe",
			3,
			5f,
			5f,
			new GenerationInformation(2, 4, 8, 1, 40)),
	Titanium(
			"oreTitanium",
			"thelta_world:ores/titanium",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Jadeite(
			"oreJadeite",
			"thelta_world:ores/jadeite",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Platinum(
			"orePlatinum",
			"thelta_world:ores/platinum",
			"pickaxe",
			2,
			5f,
			5f,
			new GenerationInformation(3, 4, 8, 10, 40)),
	Chromite(
			"oreChromite",
			"thelta_world:ores/chromite",
			"pickaxe",
			3,
			5f,
			5f,
			new GenerationInformation(2, 4, 8, 10, 20)),
	Cobalt(
			"oreCobalt",
			"thelta_world:ores/cobalt",
			"pickaxe",
			3,
			5f,
			5f,
			new GenerationInformation(2, 4, 8, 10, 20));
	
	public String oredict, texture, tool;
	public int level;
	public float hardness, resistance;
	public GenerationInformation generation;
	
	private EnumBlockOre(String oredict, String texture, String tool, int level, float hardness, float resistance, GenerationInformation generation) {
		this.oredict = oredict;
		this.texture = texture;
		this.level = level;
		this.hardness = hardness;
		this.resistance = resistance;
		this.generation = generation;
	}
}
