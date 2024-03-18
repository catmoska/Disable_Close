package com.catmoska.disable_close;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.lwjgl.glfw.GLFWKeyCallback;

public class DisableCloseClient implements ClientModInitializer {
	public static final Logger LOGGER = DisableClose.LOGGER;
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			long handle = client.getWindow().getHandle();
			GLFW.glfwSetWindowCloseCallback(handle, (window) -> {
				GLFW.glfwSetWindowShouldClose(window, false);
				LOGGER.info("Disable Close");
			});
		});
	}
}