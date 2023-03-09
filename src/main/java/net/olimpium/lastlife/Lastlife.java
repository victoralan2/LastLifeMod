package net.olimpium.lastlife;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.impl.biome.modification.BuiltInRegistryKeys;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.olimpium.lastlife.renderers.FurnaceRenderer;
import net.minecraft.block.FurnaceBlock;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Lastlife implements ModInitializer {
    public static String version = "81072";
    @Override
    public void onInitialize() {

        ClientPlayConnectionEvents.JOIN.register((a, b, c) -> {
            Lastlife.sendStringPacket(version, "version");
            Lastlife.sendStringPacket(Lastlife.allMods(), "modauth");


        });

        // TODO: UNCOMMENT THIS WHEN FINAL VERSION
//        Hasher hasher = new Hasher("SHA-256");
//        String modPath = "";
//        try {
//            for (ModContainer mod : FabricLoader.getInstance().getAllMods()){
//                if (mod.toString().startsWith("lastlife")){
//                    modPath = Lastlife.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().substring(1);
//                }
//            }
//            version = hasher.hashBytes(Files.readAllBytes(Paths.get(modPath)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static String allMods(){
        StringBuilder emptyString = new StringBuilder();
        for (ModContainer mod : FabricLoader.getInstance().getAllMods()){
            if (emptyString.toString().isEmpty()){
                emptyString.append(mod);
            } else {
                emptyString.append("<<<MODSEPARATOR>>>").append(mod);
            }
        }
        return emptyString.toString();
    }
    public void registerPacketListener(){

        ClientSidePacketRegistry.INSTANCE.register(
            new Identifier("lastlife", "packet"), // channel name
            (packetContext, packetByteBuf) -> {
                System.out.println("recived");
                sendStringPacket(version, "version");
                sendStringPacket(allMods(), "modauth");
        });
    }

    public static void sendStringPacket(String packetData, String channel) {
        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());
        packetByteBuf.writeString(channel+"<<SEPARATOR>>"+packetData);
        ClientSidePacketRegistry.INSTANCE.sendToServer(new Identifier("lastlife","packet"), packetByteBuf);
        System.out.println("Sent:" + channel+"<<SEPARATOR>>"+packetData);
    }
}
