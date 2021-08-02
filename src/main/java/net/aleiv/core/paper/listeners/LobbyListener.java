package net.aleiv.core.paper.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import net.aleiv.core.paper.Core;
import net.aleiv.core.paper.Game.GameStage;

public class LobbyListener implements Listener{
    
    Core instance;

    public LobbyListener(Core instance){
        this.instance = instance;
    }
    
    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        var game = instance.getGame();
        if(game.getGameStage() == GameStage.LOBBY){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent e){
        var game = instance.getGame();
        if(game.getGameStage() == GameStage.LOBBY){
            e.setCancelled(true);
        }
    }
}
