package auction.core.handlers;

import auction.datasources.Datasource;
import auction.datasources.MongoDatasource;
import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;
import org.bson.Document;

public class PersistRawMessageHandler implements EventHandler {

    private Datasource datasource;

    public PersistRawMessageHandler() {
        datasource = MongoDatasource.getInstance();
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
        datasource.insertRawMessage(new Document().append("message", ((EventBase) event).getRawMessage()));
    }
}
