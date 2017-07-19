package com.pharmerz.iphex.api.server.domain.audit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * Created by ankur on 13-08-2016.
 */
@Component
public class UtcDateTimeProvider implements DateTimeProvider{
    @Override
    public Calendar getNow() {
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        return  dateTime.toGregorianCalendar();
    }
}
