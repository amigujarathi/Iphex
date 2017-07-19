package com.pharmerz.iphex.api.server.domain.exception;

import org.springframework.dao.DataAccessException;

/**
 * Created by ankur on 16-10-2016.
 */
public class CandidateKeyViolationException extends DataAccessException {
    public CandidateKeyViolationException(String msg) {
        super(msg);
    }

    public CandidateKeyViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
