package com.synisys.training.entities;

public abstract class Entity {

    public static final String ID_KEY = "com.synisys.training.id";

    private final int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() &&
                getId() == ((Entity)obj).getId();
    }

    @Override
    public final int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return String.format("{%s, %d}", getClass().getName(), getId());
    }
}
