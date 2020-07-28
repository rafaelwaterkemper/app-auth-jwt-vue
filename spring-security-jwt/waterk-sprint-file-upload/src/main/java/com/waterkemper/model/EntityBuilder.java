package com.waterkemper.model;

import java.util.Objects;

public abstract class EntityBuilder<T> implements IBuilder<T> {
    protected T entity;
    private boolean validate;
    protected final EntityBuilder.EntityState state;

    protected EntityBuilder(T entity, EntityBuilder.EntityState state) {
        this(entity, state, true);
    }

    protected EntityBuilder(T entity, EntityBuilder.EntityState state, boolean autoinject) {
        this.validate = true;
        Objects.requireNonNull(entity);
        Objects.requireNonNull(state);

        this.state = state;
        this.entity = entity;
    }

    protected void beforeValidate() {
    }

    protected void afterValidate() {
    }

    public final T build() {
        Objects.requireNonNull(this.entity);
        if (this.validate) {
            this.beforeValidate();
            this.afterValidate();
        }

        return this.entity;
    }

    protected static enum EntityState {
        NEW,
        BUILT;

        private EntityState() {
        }
    }
}
