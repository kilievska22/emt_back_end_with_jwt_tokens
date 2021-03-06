package mk.ukim.finki.emt.onlinelibrary.bookscatalog.domain.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.onlinelibrary.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.onlinelibrary.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.onlinelibrary.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingReturnedEventTranslator implements RemoteEventTranslator {
    private final ObjectMapper objectMapper;

    BorrowingReturnedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent remoteEvent) {
        return remoteEvent.domainEventClassName().equals("mk.ukim.finki.emt.onlinelibrary.librarymanagment.domain.event.BorrowingReturned");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, BorrowingReturnedEvent.class));
    }
}
