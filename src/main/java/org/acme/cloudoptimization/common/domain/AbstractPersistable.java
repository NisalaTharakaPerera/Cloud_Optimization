package org.acme.cloudoptimization.common.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

public abstract class AbstractPersistable {

    public Long id;

    protected AbstractPersistable() {
    }

    protected AbstractPersistable(long id) {
        this.id = id;
    }

    @PlanningId
    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }

}
