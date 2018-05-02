package auction.core.processors;

import auction.core.handlers.BusinessLogicHandler;
import auction.core.handlers.ParseMessageHandler;
import auction.core.handlers.PersistEventsHandler;
import auction.core.handlers.PersistRawMessageHandler;
import auction.events.EventBase;
import auction.events.EventBaseFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import config.Config;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;

public class DisruptorEventProcessor implements EventProcessor {
    private RingBuffer<EventBase> ringBuffer;
    private Disruptor<EventBase> disruptor;

    public DisruptorEventProcessor() {
        int bufferSize = Integer.parseInt(Config.getProperties().getProperty("ring-buffer-size"));
        disruptor = new Disruptor<>(new EventBaseFactory(), bufferSize, Executors.defaultThreadFactory());
        disruptor.handleEventsWith(new ParseMessageHandler(), new PersistRawMessageHandler()).then(new PersistEventsHandler()).then(new BusinessLogicHandler());
        ringBuffer = disruptor.getRingBuffer();
        disruptor.start();
    }

    @Override
    public void processEvent(String eventString) {
        long seq = ringBuffer.next();
        EventBase event = ringBuffer.claimAndGetPreallocated(seq);
        event.setRawMessage(eventString);
        event.setTimestamp(LocalDateTime.now());
        ringBuffer.publish(seq);
    }

    @Override
    public void replayEventsFromFile(File file) {

    }
}
