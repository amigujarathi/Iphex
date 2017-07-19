package com.pharmerz.iphex.api.server.domain.model.projection;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ankur on 16-10-2016.
 */
public interface DomainProjection {
    UUID getId();
    Boolean getDeleted();
    Date getCreated();
    Date getUpdated();
    String getCreatedBy();
    String getUpdatedBy();
}
