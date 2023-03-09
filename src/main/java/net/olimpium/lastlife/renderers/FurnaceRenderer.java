package net.olimpium.lastlife.renderers;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;

public class FurnaceRenderer extends BlockEntityRenderer<FurnaceBlockEntity>{
    private static final Identifier TEXTURE = new Identifier("mymod", "textures/block/myblock.png");
    private final BlockRenderManager blockRenderManager;
    public FurnaceRenderer(BlockEntityRenderDispatcher dispatcher, BlockRenderManager blockRenderManager) {
        super(dispatcher);
        this.blockRenderManager = blockRenderManager;
    }

    @Override
    public void render(FurnaceBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(0));
        matrices.translate(-0.5, -0.5, -0.5);
        RenderSystem.renderCrosshair(50);
        matrices.pop();
    }
}