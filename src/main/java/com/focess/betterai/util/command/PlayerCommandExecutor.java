package com.focess.betterai.util.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface PlayerCommandExecutor extends CommandExecutor {

    @Override
    default void execute(final CommandSender sender, final String[] args) {
        if (sender instanceof Player && sender.isOp())
            this.execute((Player) sender, args);
        else
            this.executeError(sender, args);
    }

    void execute(Player player, String[] args);

    default void executeError(final CommandSender sender, final String[] args) {
    }

}
