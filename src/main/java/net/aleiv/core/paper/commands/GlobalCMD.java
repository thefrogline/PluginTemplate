package net.aleiv.core.paper.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.NonNull;
import net.aleiv.core.paper.Core;
import net.aleiv.core.paper.Game.GameStage;
import net.md_5.bungee.api.ChatColor;

@CommandAlias("global")
@CommandPermission("admin.perm")
public class GlobalCMD extends BaseCommand {

    private @NonNull Core instance;
    Entity current = null;

    public GlobalCMD(Core instance) {
        this.instance = instance;

    }

    @Subcommand("velocity|v|velo")
    public void velocity(Player sender, Float x, Float y, Float z){

        var entity = sender.getTargetEntity(10, true);

        if(entity != null){
            entity.setVelocity(new Vector(x, y, z));
            sender.sendMessage(ChatColor.BLUE + "Velocity target: " + x + " " + y + " " + z);
            current = entity;

        }else if(current != null){
            current.setVelocity(new Vector(x, y, z));
            sender.sendMessage(ChatColor.BLUE + "Velocity current: " + x + " " + y + " " + z);

        }else{
            sender.sendMessage(ChatColor.RED + "No target.");
        }

    }

    @Subcommand("stage")
    public void stage(CommandSender sender, GameStage string){
        var game = instance.getGame();

        switch (string) {
            case LOBBY:{
                game.setGameStage(GameStage.LOBBY);
            }break;

            case PREGAME:{
                game.setGameStage(GameStage.PREGAME);
            }break;

            case INGAME:{
                game.setGameStage(GameStage.INGAME);
            }break;

            case POSTGAME:{
                game.setGameStage(GameStage.POSTGAME);
                
            }break;
        
            default:
                break;
        }
        sender.sendMessage("Stage change to " + string);
    }
}
