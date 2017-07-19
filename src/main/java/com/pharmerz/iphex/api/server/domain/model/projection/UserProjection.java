package com.pharmerz.iphex.api.server.domain.model.projection;

import com.pharmerz.iphex.api.server.domain.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ankur on 16-10-2016.
 */
@Projection(name = "detail", types = User.class)
public interface UserProjection extends DomainProjection {

}



