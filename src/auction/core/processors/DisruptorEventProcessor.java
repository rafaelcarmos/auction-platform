package auction.core.processors;

import auction.events.EventBase;
import auction.events.EventBaseFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import config.Config;

import java.io.File;
import java.util.concurrent.Executors;

public class DisruptorEventProcessor implements EventProcessor {
    private RingBuffer<EventBase> ringBuffer;
    private Disruptor<EventBase> disruptor;

    public DisruptorEventProcessor() {

        int bufferSize = Integer.parseInt(Config.getProperties().getProperty("RingBufferSize"));
        disruptor = new Disruptor<>(new EventBaseFactory(), bufferSize, Executors.defaultThreadFactory());
        ringBuffer = disruptor.getRingBuffer();
    }

    @Override
    public void processEvent(String eventString) {
        long seq = ringBuffer.next();
        EventBase event = ringBuffer.claimAndGetPreallocated(seq);
        event.setRawMessage(eventString);
        ringBuffer.publish(seq);
    }

    @Override
    public void replayEventsFromFile(File file) {

    }
}
