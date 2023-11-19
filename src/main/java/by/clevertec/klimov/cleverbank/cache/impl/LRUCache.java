package by.clevertec.klimov.cleverbank.cache.impl;

import by.clevertec.klimov.cleverbank.cache.Cache;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> implements Cache<K, V> {

  private final int capacity;
  private final Map<K, Node<K, V>> cache;
  private final Node<K, V> head;
  private final Node<K, V> tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = HashMap.newHashMap(capacity);
    this.head = new Node<>(null, null);
    this.tail = new Node<>(null, null);
    this.head.next = tail;
    this.tail.prev = head;
  }

  @Override
  public void put(K key, V value) {
    Node<K, V> node = cache.get(key);
    if (node != null) {
      node.value = value;
      remove(node);
      add(node);
    } else {
      if (cache.size() == capacity) {
        cache.remove(tail.prev.key);
        remove(tail.prev);
      }
      Node<K, V> newNode = new Node<>(key, value);
      cache.put(key, newNode);
      add(newNode);
    }
  }

  @Override
  public Optional<V> get(K key) {
    Node<K, V> node = cache.get(key);
    if (node == null) {
      return Optional.empty();
    }
    remove(node);
    add(node);
    return Optional.ofNullable(node.value);
  }

  @Override
  public int size() {
    return cache.size();
  }

  @Override
  public boolean isEmpty() {
    return cache.isEmpty();
  }

  @Override
  public void clear() {
    cache.clear();
  }

  private void add(Node<K, V> node) {
    Node<K, V> headNext = head.next;
    head.next = node;
    node.prev = head;
    node.next = headNext;
    headNext.prev = node;
  }

  private void remove(Node<K, V> node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private static class Node<K, V> {
    private final K key;
    private V value;
    private Node<K, V> prev;
    private Node<K, V> next;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}