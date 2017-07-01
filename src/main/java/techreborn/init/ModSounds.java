/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.GameData;

/**
 * Created by Mark on 20/03/2016.
 */
public class ModSounds {

	public static SoundEvent CABLE_SHOCK;
	public static SoundEvent BLOCK_DISMANTLE;
	public static SoundEvent SAP_EXTRACT;
	public static SoundEvent AUTO_CRAFTING;

	public static void init() {
		CABLE_SHOCK = getSound("cable_shock");
		BLOCK_DISMANTLE = getSound("block_dismantle");
		SAP_EXTRACT = getSound("sap_extract");
		AUTO_CRAFTING = getSound("auto_crafting");
	}

	private static SoundEvent getSound(String str) {
		ResourceLocation resourceLocation = new ResourceLocation("techreborn", str);
		SoundEvent soundEvent = new SoundEvent(resourceLocation);
		soundEvent.setRegistryName(resourceLocation);
		return GameData.register_impl(soundEvent);
	}

}
