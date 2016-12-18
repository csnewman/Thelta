package com.error22.thelta.utility;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;

public class PropertyAxis extends PropertyEnum<EnumFacing.Axis> {
	protected PropertyAxis(String name, Collection<EnumFacing.Axis> values) {
		super(name, EnumFacing.Axis.class, values);
	}

	public static PropertyAxis create(String name) {
		return create(name, Predicates.<EnumFacing.Axis>alwaysTrue());
	}

	public static PropertyAxis create(String name, Predicate<EnumFacing.Axis> filter) {
		return create(name, Collections2.<EnumFacing.Axis>filter(Lists.newArrayList(EnumFacing.Axis.values()), filter));
	}

	public static PropertyAxis create(String name, Collection<EnumFacing.Axis> values) {
		return new PropertyAxis(name, values);
	}
}