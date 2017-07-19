package com.pharmerz.iphex.api.server.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pharmerz.iphex.api.server.domain.model.Product;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * Created by ankur on 16-10-2016.
 */
@Projection(name = "detail", types = Product.class)
public interface ProductProjection extends DomainProjection {


}
