package auction.events;

import com.lmax.disruptor.EventFactory;

public class EventBaseFactory implements EventFactory<EventBase> {

    @Override
    public EventBase newInstance() {
        return new EventBase();
    }
}
