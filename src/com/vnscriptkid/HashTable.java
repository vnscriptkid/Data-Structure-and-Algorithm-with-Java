package com.vnscriptkid;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Entry(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }
    }

    private final static int SIZE = 5;
    private LinkedList<Entry>[] items;

    public HashTable() {
        items = new LinkedList[SIZE];
    }

    public int hashFunction(int key) {
        return key % SIZE;
    }

    public void put(int key, String value) {
        var bucket = getBucketFromKeyOrCreate(key);

        Entry foundEntry = bucketContainsKey(bucket, key);

        if (foundEntry != null) {
            foundEntry.value = value;
            return;
        }

        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntryFromKey(key);

        if (entry != null)
            return entry.value;

        return null;
    }

    public void remove(int key) {
        Entry foundEntry = getEntryFromKey(key);

        if (foundEntry == null)
            throw new IllegalStateException();

        getBucketFromKeyOrCreate(key).remove(foundEntry);
    }

    private Entry getEntryFromKey(int key) {
        int index = hashFunction(key);

        LinkedList<Entry> bucket = items[index];

        Entry foundEntry = bucketContainsKey(bucket, key);

        return foundEntry;
    }

    private LinkedList<Entry> getBucketFromKeyOrCreate(int key) {
        int index = hashFunction(key);

        var bucket = items[index];

        if (bucket == null)
            bucket = items[index] = new LinkedList<>();

        return bucket;
    }

    private Entry bucketContainsKey(LinkedList<Entry> bucket, int key) {
        Entry entryToFind = new Entry(key);

        if (bucket.contains(entryToFind)) {
            return bucket.get(bucket.indexOf(entryToFind));
        }

        return null;
    }

    @Override
    public String toString() {
        return items.length + Arrays.toString(items);
    }
}
