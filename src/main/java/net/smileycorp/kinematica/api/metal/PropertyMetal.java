package net.smileycorp.kinematica.api.metal;

import java.util.Collection;

import net.smileycorp.atlas.api.block.PropertyString;

public class PropertyMetal extends PropertyString {

	public PropertyMetal() {
		super("type");
	}
	
	@Override
	public Collection<String> getAllowedValues() {
		return MetalRegistry.getMetals();
	}

}
