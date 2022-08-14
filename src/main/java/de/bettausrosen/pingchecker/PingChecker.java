package de.bettausrosen.pingchecker;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import de.bettausrosen.pingchecker.commands.PingCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public final class PingChecker extends Plugin {

    public static PingChecker instance;
    public static String PREFIX = IridiumColorAPI.process("§8» <GRADIENT:00b3db>§lPING</GRADIENT:78e6ff> §8▏ §7");

    @Override
    public void onEnable() {
        instance = this;

        if(!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new PingCommand());

        getProxy().getConsole().sendMessage(new TextComponent(PingChecker.PREFIX + "§7The §bPingChecker §7was §2enabled!"));
    }

    @Override
    public void onDisable() {
        getProxy().getConsole().sendMessage(new TextComponent(PingChecker.PREFIX + "§7The §bPingChecker §7was §4disabled!"));
    }

    public static PingChecker getInstance() {
        return instance;
    }
}
