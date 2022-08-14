package de.bettausrosen.pingchecker.commands;

import de.bettausrosen.pingchecker.PingChecker;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping", null, "ms");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer)sender;
            if(args.length == 0) {
                if(player.getPing() <= 50) {
                    sender.sendMessage(PingChecker.PREFIX + "§7Your ping is §2§l" + player.getPing() + "§7!");
                }
                if(player.getPing() <= 100 && player.getPing() >= 50) {
                    sender.sendMessage(PingChecker.PREFIX + "§7Your ping is §a§l" + player.getPing() + "§7!");
                }
                if(player.getPing() >= 100 && player.getPing() <= 130) {
                    sender.sendMessage(PingChecker.PREFIX + "§7Your ping is §e§l" + player.getPing() + "§7!");
                }
                if(player.getPing() >= 130 && player.getPing() <= 180) {
                    sender.sendMessage(PingChecker.PREFIX + "§7Your ping is §6§l" + player.getPing() + "§7!");
                }
                if(player.getPing() >= 180) {
                    sender.sendMessage(PingChecker.PREFIX + "§7Your ping is §4§l" + player.getPing() + "§7!");
                }
            } else {
                sender.sendMessage(PingChecker.PREFIX + "§4§lSyntax: §c/ping");
            }
        } else {
            sender.sendMessage(PingChecker.PREFIX + "§4ONLY A PLAYER CAN EXECUTE THIS COMMAND!");
        }
    }
}
