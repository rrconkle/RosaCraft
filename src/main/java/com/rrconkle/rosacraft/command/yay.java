package com.rrconkle.rosacraft.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.quiltmc.qsl.command.api.client.ClientCommandManager;
import org.quiltmc.qsl.command.api.client.ClientCommandRegistrationCallback;
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource;


public class yay implements ClientCommandRegistrationCallback {
	@Override
	public void registerCommands(CommandDispatcher<QuiltClientCommandSource> dispatcher, CommandBuildContext buildContext,
								 CommandManager.RegistrationEnvironment environment) {
		dispatcher.register(
			ClientCommandManager.literal("test_client_command")
				.executes(ctx -> {
					ctx.getSource().sendFeedback(Text.literal("It works!")
						.styled(style -> style.withClickEvent(
							new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/test_client_command with_arg minecraft:dirt")
						))
					);
					return 0;
				})
				.then(ClientCommandManager.literal("with_arg")
					.then(ClientCommandManager.argument("block", BlockStateArgumentType.blockState(buildContext))
						.executes(ctx -> {
							BlockStateArgument arg = ctx.getArgument("block", BlockStateArgument.class);
							ctx.getSource().sendFeedback(Text.literal("You have given me: ")
								.append(Text.literal(arg.getBlockState().toString()).formatted(Formatting.GOLD))
								.append("!"));

							return 0;
						})
					)
				)
		);

		dispatcher.register(
			ClientCommandManager.literal("seed")
				.executes(ctx -> {
					ctx.getSource().sendFeedback(Text.of("This is a client-only command which conflicts with a server command!"));
					return 0;
				})
		);
	}
}
