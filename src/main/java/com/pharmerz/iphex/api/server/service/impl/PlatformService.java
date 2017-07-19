package com.pharmerz.iphex.api.server.service.impl;

import com.pharmerz.iphex.api.server.service.IPlatformService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ankur on 04-10-2016.
 */
@Service
@Transactional(readOnly = true)
public class PlatformService implements IPlatformService{
}
