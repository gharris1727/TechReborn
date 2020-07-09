/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
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

package techreborn.enet;

import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.minecraft.server.MinecraftServer;
import team.reborn.energy.EnergyTier;
import techreborn.TechReborn;

import java.util.HashSet;
import java.util.Set;

public final class ElectricNetworkManager implements ServerTickCallback {
	public static ElectricNetworkManager INSTANCE;

	private final Set<ElectricNetwork> electricNetworks = new HashSet<>();

	private ElectricNetworkManager() {
		ServerTickCallback.EVENT.register(this::tick);
	}

	public static void init(MinecraftServer server) {
			INSTANCE = new ElectricNetworkManager();
	}

	@Override
	public void tick(MinecraftServer minecraftServer) {
		electricNetworks.removeIf(network -> {
			network.tick();

			if (network.isEmpty()) {
				TechReborn.LOGGER.debug("Electric Network {} is empty, removed", network);
			}

			return network.isEmpty();
		});
	}

	public ElectricNetwork newNetwork(EnergyTier tier) {
		ElectricNetwork newNetwork = new ElectricNetwork(tier);
		electricNetworks.add(newNetwork);

		TechReborn.LOGGER.debug(
				"Enqueued new electric network ID: {}",
				newNetwork);

		return newNetwork;
	}

	// Debug functions

	public int getNetworkCount(){
		return electricNetworks.size();
	}
}
