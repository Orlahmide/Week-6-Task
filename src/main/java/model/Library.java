package model;

import util.RoleComparator;

import java.util.*;

public class Library {
    private Map<String, Integer> libraryCollection;
    private PriorityQueue<Persons> requestQueue;
    private List<Persons> fifo;

    public Library() {
        libraryCollection = new HashMap<>();
        requestQueue = new PriorityQueue<>(new RoleComparator());
        fifo = new ArrayList<>();
    }

    public PriorityQueue<Persons> getRequestQueue() {
        return requestQueue;
    }

    public Map<String, Integer> getLibraryCollection() {
        return libraryCollection;
    }

    public List<Persons> getFifo() {
        return fifo;
    }
}

