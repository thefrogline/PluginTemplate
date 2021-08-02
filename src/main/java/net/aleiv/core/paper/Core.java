package net.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import co.aikar.commands.PaperCommandManager;
import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChainFactory;
import lombok.Getter;
import lombok.Setter;
import net.aleiv.core.paper.commands.GlobalCMD;
import net.aleiv.core.paper.listeners.GlobalListener;
import net.aleiv.core.paper.listeners.LobbyListener;


public class Core extends JavaPlugin{

    private static @Getter Core instance;
    private static @Getter @Setter TaskChainFactory taskChainFactory;
    private @Getter Game game;
    private @Getter PaperCommandManager commandManager;

    private LobbyListener lobbyListener;

    @Override
    public void onEnable() {
        instance = this;

        game = new Game(this);
        game.runTaskTimerAsynchronously(this, 0L, 20L);

        taskChainFactory = BukkitTaskChainFactory.create(this);

        lobbyListener = new LobbyListener(this);

        Bukkit.getPluginManager().registerEvents(new GlobalListener(this), this);
        Bukkit.getPluginManager().registerEvents(lobbyListener, this);

        unregisterListener(lobbyListener);

        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new GlobalCMD(this));

    }

    @Override
    public void onDisable() {

    }

    public void unregisterListener(Listener listener) {
        HandlerList.unregisterAll(listener);
    }
    
}