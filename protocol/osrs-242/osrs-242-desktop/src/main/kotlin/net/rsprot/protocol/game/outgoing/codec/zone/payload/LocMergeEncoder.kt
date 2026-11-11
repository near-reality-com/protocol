package net.rsprot.protocol.game.outgoing.codec.zone.payload

import net.rsprot.buffer.JagByteBuf
import net.rsprot.protocol.ServerProt
import net.rsprot.protocol.game.outgoing.prot.GameServerProt
import net.rsprot.protocol.game.outgoing.zone.payload.LocMerge
import net.rsprot.protocol.internal.game.outgoing.codec.zone.payload.ZoneProtEncoder

public class LocMergeEncoder : ZoneProtEncoder<LocMerge> {
    override val prot: ServerProt = GameServerProt.LOC_MERGE

    override fun encode(
        buffer: JagByteBuf,
        message: LocMerge,
    ) {
        // The 242 client (osrs.class159.method5561, LOC_MERGE branch) reads these 14 bytes
        // and discards them, so only the byte layout is verified; the field-to-slot
        // assignment below follows the 241 field set and is not observable client-side.
        buffer.p1Alt1(message.coordInZonePacked)
        buffer.p1Alt3(message.locPropertiesPacked)
        buffer.p1Alt1(message.minX)
        buffer.p1Alt3(message.maxX)
        buffer.p1Alt3(message.minZ)
        buffer.p2Alt3(message.start)
        buffer.p2Alt2(message.end)
        buffer.p2Alt1(message.index)
        buffer.p1Alt1(message.maxZ)
        buffer.p2Alt1(message.id)
    }
}
