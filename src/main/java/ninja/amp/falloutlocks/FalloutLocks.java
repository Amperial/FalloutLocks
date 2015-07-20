/*
 * This file is part of FalloutLocks.
 *
 * Copyright (c) 2015-2015 <http://github.com/ampayne2/FalloutLocks//>
 *
 * FalloutLocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FalloutLocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FalloutLocks.  If not, see <http://www.gnu.org/licenses/>.
 */
package ninja.amp.falloutlocks;

import ninja.amp.fallout.Fallout;
import ninja.amp.fallout.FalloutCore;
import ninja.amp.fallout.character.CharacterManager;
import ninja.amp.fallout.command.CommandController;
import ninja.amp.fallout.command.CommandGroup;
import ninja.amp.fallout.command.commands.character.knowledge.Information;
import ninja.amp.fallout.faction.FactionManager;
import ninja.amp.fallout.command.commands.roll.RollManager;
import ninja.amp.fallout.config.ConfigManager;
import ninja.amp.fallout.message.Messenger;
import ninja.amp.falloutlocks.command.AboutCommand;
import ninja.amp.falloutlocks.command.ReloadCommand;
import ninja.amp.falloutlocks.config.FOLConfig;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;
import java.util.LinkedHashSet;

/**
 * The main class of the Fallout Locks plugin.
 *
 * @author Austin Payne
 */
public class FalloutLocks extends JavaPlugin implements FalloutCore, Listener {

    private FalloutCore fallout;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("Fallout")) {
            fallout = JavaPlugin.getPlugin(Fallout.class);
        } else {
            return;
        }

        saveDefaultConfig();
        fallout.getConfigManager().registerCustomConfigs(EnumSet.allOf(FOLConfig.class), this);

        // Create fallout locks command tree
        CommandGroup falloutlocks = new CommandGroup(this, "falloutlocks")
                .addChildCommand(new AboutCommand(this))
                .addChildCommand(new ReloadCommand(this));

        // Add fallout locks command tree to command controller
        fallout.getCommandController().addCommand(falloutlocks);
    }

    @Override
    public void onDisable() {
        CommandController commandController = fallout.getCommandController();
        for (CommandGroup command : new LinkedHashSet<>(commandController.getCommands())) {
            if (command.getPlugin().equals(this)) {
                commandController.removeCommand(command);
            }
        }
        fallout = null;
    }

    @Override
    public JavaPlugin getPlugin() {
        return this;
    }

    @Override
    public ConfigManager getConfigManager() {
        return fallout.getConfigManager();
    }

    @Override
    public Messenger getMessenger() {
        return fallout.getMessenger();
    }

    @Override
    public CommandController getCommandController() {
        return fallout.getCommandController();
    }

    @Override
    public CharacterManager getCharacterManager() {
        return fallout.getCharacterManager();
    }

    @Override
    public RollManager getRollManager() {
        return fallout.getRollManager();
    }

    @Override
    public FactionManager getFactionManager() {
        return fallout.getFactionManager();
    }

    static {
        Information.addInformation("PoseidoNet");
        Information.addInformation("Vault-Tec");
    }

}
