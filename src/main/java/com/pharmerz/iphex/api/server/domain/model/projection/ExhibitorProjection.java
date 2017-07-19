package com.pharmerz.iphex.api.server.domain.model.projection;

import com.pharmerz.iphex.api.server.domain.model.Exhibitor;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by User on 17-04-2017.
 */
@Projection(name = "detail", types = Exhibitor.class)
public interface ExhibitorProjection extends DomainProjection {

    String  getStall();
}
