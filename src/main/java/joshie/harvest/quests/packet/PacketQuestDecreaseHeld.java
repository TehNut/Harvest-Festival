package joshie.harvest.quests.packet;

import io.netty.buffer.ByteBuf;
import joshie.harvest.core.network.Packet;
import joshie.harvest.core.network.Packet.Side;
import joshie.harvest.core.network.PenguinPacket;
import net.minecraft.entity.player.EntityPlayer;

@Packet(Side.SERVER)
public class PacketQuestDecreaseHeld extends PenguinPacket {
    private int amount;
    
    public PacketQuestDecreaseHeld() {}
    public PacketQuestDecreaseHeld(int amount) {
        this.amount = amount;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(amount);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        amount = buf.readByte();
    }

    @Override
    public void handlePacket(EntityPlayer player) {
        player.inventory.decrStackSize(player.inventory.currentItem, amount);
    }
}