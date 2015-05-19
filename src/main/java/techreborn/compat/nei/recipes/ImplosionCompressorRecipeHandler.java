package techreborn.compat.nei.recipes;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.client.gui.GuiImplosionCompressor;
import techreborn.util.ItemUtils;
import codechicken.nei.PositionedStack;

public class ImplosionCompressorRecipeHandler extends GenericRecipeHander implements INeiBaseRecipe {
	@Override
	public void addPositionedStacks(List<PositionedStack> input, List<PositionedStack> outputs, IBaseRecipeType recipeType) {
		int offset = 4;
		PositionedStack pStack = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(0)), 34 - offset, 16 - offset);
		input.add(pStack);

		PositionedStack pStack2 = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(1)), 34 - offset, 34 - offset);
		input.add(pStack2);

		PositionedStack pStack3 = new PositionedStack(recipeType.getOutputs().get(0), 86 - offset, 25 - offset);
		outputs.add(pStack3);

		PositionedStack pStack4 = new PositionedStack(recipeType.getOutputs().get(1), 104 - offset, 25 - offset);
		outputs.add(pStack4);
	}

	@Override
	public String getRecipeName() {
		return "implosionCompressorRecipe";
	}

	@Override
	public String getGuiTexture() {
		return "techreborn:textures/gui/implosion_compressor.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiImplosionCompressor.class;
	}

	@Override
	public INeiBaseRecipe getNeiBaseRecipe() {
		return this;
	}
}
