package auction.core.handlers;

import auction.datasources.Datasource;
import auction.datasources.MongoDatasource;
import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;

public class PersistEventsHandler implements EventHandler {

    private Datasource datasource;

    public PersistEventsHandler() {
        datasource = MongoDatasource.getInstance();
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
        datasource.insertEvent(((EventBase) event).getDocument());
    }
}
