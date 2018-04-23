package auction.core.processors;

import java.io.File;

//interface to support processors with different underlying data structures (Disruptor, ArrayBlockingQueue or others)
public interface EventProcessor {

    //add event to Queue and inform to handlers
    void processEvent(String eventString);

    //replay events in sequence from a file
    void replayEventsFromFile(File file);
}
