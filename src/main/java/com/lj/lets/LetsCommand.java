package com.lj.lets;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class LetsCommand extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel()
    {
        return -1;
    }

    @Override
    public boolean checkPermission(MinecraftServer i, ICommandSender ii)
    {
        return true;
    }

    @Override
    public String getName()
    {
        return "l";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender)
    {
        return "l <vec3, playerId>";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] parameters) throws CommandException
    {
        if (parameters.length > 1)
        {
            BlockPos pos = this.parseBlockPos(iCommandSender, parameters, 0, true);
            EntityPlayerMP sourcePlayer = this.getCommandSenderAsPlayer(iCommandSender);
            sourcePlayer.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());

            return;
        }

        this.executeToPlayer(iCommandSender, parameters[0]);
    }

    public void executeToPlayer(ICommandSender iCommandSender, String name)
    {
        try
        {
            EntityPlayerMP sourcePlayer = this.getCommandSenderAsPlayer(iCommandSender);
            EntityPlayerMP targetPlayer = this.getPlayer(sourcePlayer.getServer(), iCommandSender, name);

            sourcePlayer.setWorld(targetPlayer.world);
            sourcePlayer.setPositionAndUpdate(targetPlayer.posX, targetPlayer.posY, targetPlayer.posZ);
        } catch (Exception e)
        {
            return;
        }
    }
}
