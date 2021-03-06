package com.demonwav.ectotokens.commands;

import com.demonwav.ectotokens.EctoTokens;
import com.demonwav.ectotokens.Perm;
import com.demonwav.ectotokens.gui.Window;

import lombok.AllArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ShopCommand implements EctoCommand {

    private EctoTokens plugin;

    @Override
    public boolean hasPermission(CommandSender sender, String[] args) {
        return sender.hasPermission(Perm.getPlayerStore());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Window window = plugin.getWindowConfig().getWindow().getWindow(
                plugin.getMainConfig().getGui().getHeight(),
                null,
                ((Player) sender),
                plugin);
            window.createWindow();
        } else {
            sender.sendMessage("You must be a player to run this command.");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
