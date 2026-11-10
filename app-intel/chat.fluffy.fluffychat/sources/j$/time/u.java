package j$.time;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class u implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a, reason: collision with root package name */
    public byte f18409a;

    /* renamed from: b, reason: collision with root package name */
    public Object f18410b;

    public u() {
    }

    public u(byte b7, Object obj) {
        this.f18409a = b7;
        this.f18410b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b7 = this.f18409a;
        Object obj = this.f18410b;
        objectOutput.writeByte(b7);
        switch (b7) {
            case 1:
                e eVar = (e) obj;
                objectOutput.writeLong(eVar.f18266a);
                objectOutput.writeInt(eVar.f18267b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f18194a);
                objectOutput.writeInt(instant.f18195b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f18345a);
                objectOutput.writeByte(hVar.f18346b);
                objectOutput.writeByte(hVar.f18347c);
                return;
            case 4:
                ((l) obj).h0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f18198a;
                objectOutput.writeInt(hVar2.f18345a);
                objectOutput.writeByte(hVar2.f18346b);
                objectOutput.writeByte(hVar2.f18347c);
                localDateTime.f18199b.h0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f18201a;
                h hVar3 = localDateTime2.f18198a;
                objectOutput.writeInt(hVar3.f18345a);
                objectOutput.writeByte(hVar3.f18346b);
                objectOutput.writeByte(hVar3.f18347c);
                localDateTime2.f18199b.h0(objectOutput);
                zonedDateTime.f18202b.b0(objectOutput);
                zonedDateTime.f18203c.P(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((A) obj).f18188b);
                return;
            case 8:
                ((z) obj).b0(objectOutput);
                return;
            case 9:
                s sVar = (s) obj;
                sVar.f18372a.h0(objectOutput);
                sVar.f18373b.b0(objectOutput);
                return;
            case 10:
                r rVar = (r) obj;
                LocalDateTime localDateTime3 = rVar.f18369a;
                h hVar4 = localDateTime3.f18198a;
                objectOutput.writeInt(hVar4.f18345a);
                objectOutput.writeByte(hVar4.f18346b);
                objectOutput.writeByte(hVar4.f18347c);
                localDateTime3.f18199b.h0(objectOutput);
                rVar.f18370b.b0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((w) obj).f18414a);
                return;
            case 12:
                y yVar = (y) obj;
                objectOutput.writeInt(yVar.f18418a);
                objectOutput.writeByte(yVar.f18419b);
                return;
            case 13:
                p pVar = (p) obj;
                objectOutput.writeByte(pVar.f18365a);
                objectOutput.writeByte(pVar.f18366b);
                return;
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                t tVar = (t) obj;
                objectOutput.writeInt(tVar.f18375a);
                objectOutput.writeInt(tVar.f18376b);
                objectOutput.writeInt(tVar.f18377c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b7 = objectInput.readByte();
        this.f18409a = b7;
        this.f18410b = a(b7, objectInput);
    }

    public static Object a(byte b7, ObjectInput objectInput) throws IOException {
        switch (b7) {
            case 1:
                e eVar = e.f18265c;
                long j7 = objectInput.readLong();
                long j8 = objectInput.readInt();
                return e.A(Math.addExact(j7, Math.floorDiv(j8, 1000000000L)), (int) Math.floorMod(j8, 1000000000L));
            case 2:
                Instant instant = Instant.f18193c;
                return Instant.A(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f18343d;
                return h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.c0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f18196c;
                h hVar2 = h.f18343d;
                return LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f18196c;
                h hVar3 = h.f18343d;
                LocalDateTime localDateTimeI = LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
                z zVarA0 = z.a0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof z) || zVarA0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeI, zoneId, zVarA0);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i7 = A.f18187d;
                return ZoneId.A(objectInput.readUTF(), false);
            case 8:
                return z.a0(objectInput);
            case 9:
                int i8 = s.f18371c;
                return new s(l.c0(objectInput), z.a0(objectInput));
            case 10:
                int i9 = r.f18368c;
                h hVar4 = h.f18343d;
                return new r(LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput)), z.a0(objectInput));
            case 11:
                int i10 = w.f18413b;
                return w.s(objectInput.readInt());
            case 12:
                int i11 = y.f18417c;
                int i12 = objectInput.readInt();
                byte b8 = objectInput.readByte();
                j$.time.temporal.a.YEAR.X(i12);
                j$.time.temporal.a.MONTH_OF_YEAR.X(b8);
                return new y(i12, b8);
            case 13:
                int i13 = p.f18364c;
                byte b9 = objectInput.readByte();
                byte b10 = objectInput.readByte();
                n nVarI = n.I(b9);
                Objects.requireNonNull(nVarI, "month");
                j$.time.temporal.a.DAY_OF_MONTH.X(b10);
                if (b10 <= nVarI.F()) {
                    return new p(nVarI.getValue(), b10);
                }
                throw new c("Illegal value for DayOfMonth field, value " + ((int) b10) + " is not valid for month " + nVarI.name());
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                t tVar = t.f18374d;
                return t.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f18410b;
    }
}
