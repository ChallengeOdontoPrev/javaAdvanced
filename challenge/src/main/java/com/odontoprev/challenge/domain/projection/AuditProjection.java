package com.odontoprev.challenge.domain.projection;

import java.time.LocalDateTime;

public interface AuditProjection {
    Long getAuditId();
    String getOperation();
    String getChangedBy();
    LocalDateTime getChangeTimestamp();
}
