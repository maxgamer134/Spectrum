package de.dafuqs.spectrum.helpers;

import net.minecraft.nbt.*;

// TODO: migrate to net.minecraft.world.tick ?
public final class TickLooper {

    private int currentTick;
    private int maxTick;

    public TickLooper(int maxTick) {
        this.maxTick = maxTick;
    }

    public void tick() {
        currentTick++;
    }

    public boolean reachedCap() {
        return currentTick >= maxTick;
    }

    public void reset() {
        currentTick = 0;
    }

    public int getTick() {
        return currentTick;
    }

    public int getMaxTick() {
        return maxTick;
    }

    public float getProgress() {
        return (float) currentTick / (float) maxTick;
    }
    
    @Override
    public String toString() {
        return "TickLooper (" + currentTick + "/" + maxTick + ")";
    }
    
    public void readNbt(NbtCompound nbt) {
        maxTick = nbt.getInt("max");
        currentTick = nbt.getInt("current");
    }
    
    public NbtElement toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("max", maxTick);
        nbt.putInt("current", currentTick);
        return nbt;
    }
}