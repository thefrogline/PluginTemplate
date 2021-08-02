package net.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.aleiv.core.paper.events.GameTickEvent;

@Data
@EqualsAndHashCode(callSuper = false)
public class Game extends BukkitRunnable {
    Core instance;

    long gameTime = 0;
    long startTime = 0;

    GameStage gameStage;
    GameType gameType;
    GameMap map;


    public Game(Core instance) {
        this.instance = instance;
        this.startTime = System.currentTimeMillis();

        this.gameStage = GameStage.LOBBY;
        this.gameType =  GameType.POWERS;
        this.map = GameMap.POWERS;


    }

    @Override
    public void run() {

        var new_time = (int) (Math.floor((System.currentTimeMillis() - startTime) / 1000.0));

        gameTime = new_time;

        Bukkit.getPluginManager().callEvent(new GameTickEvent(new_time, true));
    }

    public enum GameStage {
        LOBBY, PREGAME, INGAME, POSTGAME
    }

    public enum GameType {
        POWERS
    }

    public enum GameMap {
        POWERS
    }
}