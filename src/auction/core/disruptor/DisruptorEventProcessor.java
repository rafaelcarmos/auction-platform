package auction.core.disruptor;

import auction.core.EventProcessor;
import auction.events.EventBase;
import auction.events.EventBaseFactory;
import com.lmax.disruptor.dsl.Disruptor;
import config.Config;

import java.io.File;
import java.util.concurrent.Executors;

public class DisruptorEventProcessor implements EventProcessor {

    private Disruptor<EventBase> disruptor;

    public DisruptorEventProcessor() {
        int bufferSize = Integer.parseInt(Config.getProperties().getProperty("RingBufferSize"));
        disruptor = new Disruptor<>(new EventBaseFactory(), bufferSize, Executors.defaultThreadFactory());

    }

    @Override
    public void processEvent(EventBase event) {

    }

    @Override
    public void replayEventsFromFile(File file) {

    }
}
