package net.olimpium.lastlife.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.olimpium.lastlife.Lastlife;
import org.jetbrains.annotations.NotNull;

import static net.olimpium.lastlife.Lastlife.version;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class LastlifeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

    }
    public static void registerBlockRenderer() {
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.FURNACE, RenderLayer.getCutout());
    }
}
