package auction.core.disruptor.handlers;

import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;
import config.Config;

import java.io.Writer;

public class PersistingHandler implements EventHandler {
    private Writer writer;

    public PersistingHandler(Writer w) {
        String bidsFilePath = Config.getProperties().getProperty("bidsFile");
        writer = w;
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) throws Exception {
        EventBase e = (EventBase) event;
        writer.write(e.getRawMessage() + "\n");
    }
}
