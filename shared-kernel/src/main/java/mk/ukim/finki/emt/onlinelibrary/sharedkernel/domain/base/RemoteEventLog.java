package mk.ukim.finki.emt.onlinelibrary.sharedkernel.domain.base;


import mk.ukim.finki.emt.onlinelibrary.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
