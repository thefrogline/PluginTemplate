package net.aleiv.core.paper.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.aleiv.core.paper.Core;
import net.aleiv.core.paper.events.GameTickEvent;

public class GlobalListener implements Listener{
    
    Core instance;

    public GlobalListener(Core instance){
        this.instance = instance;
    }

    @EventHandler
    public void onGameTick(GameTickEvent e) {
        Bukkit.getScheduler().runTask(instance, () -> {
            
        });
    }

}
