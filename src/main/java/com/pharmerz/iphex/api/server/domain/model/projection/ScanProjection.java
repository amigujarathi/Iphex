package com.pharmerz.iphex.api.server.domain.model.projection;

import com.pharmerz.iphex.api.server.domain.model.Scan;
import com.pharmerz.iphex.api.server.domain.model.User;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by ankur on 16-10-2016.
 */
@Projection(name = "detail", types = Scan.class)
public interface ScanProjection extends DomainProjection {
    User getUser();
    User getOther();
}



