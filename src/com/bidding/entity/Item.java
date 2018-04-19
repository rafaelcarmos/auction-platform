package com.bidding.entity;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String name;
    private List<Bid> bids = new ArrayList<>();
    private String offerer = null;

    public Item() {

    }

    public String getOfferer() {
        return offerer;
    }

    public void setOfferer(String offerer) {
        this.offerer = offerer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
