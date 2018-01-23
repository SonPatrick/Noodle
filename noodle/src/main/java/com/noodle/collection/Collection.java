package com.noodle.collection;

import com.noodle.Description;
import com.noodle.Result;

import java.util.List;

/**
 * Collection is a generic interface for manipulating entities.
 * Usually you don't construct collections on your own, but use
 * {@link com.noodle.Noodle#collectionOf(Class)} method to get one.
 *
 * @see com.noodle.Result
 * @see Converter
 * @see Description
 */
public interface Collection<T> {

  /**
   * Get the item by it's id. Returns {@link Result},
   * holding this item or null, if not found.
   *
   * @param id of the given item, should be positive
   * @return {@link Result} that wraps item or null
   */
  Result<T> get(long id);

  /**
   * Store the entity in the collection. If it does not have an id,
   * it will be stored as new, and assigned one. Otherwise old entity
   * will be replaced
   *
   * @param t entity to store
   * @return {@link Result} that wraps an updated item
   */
  Result<T> put(T t);

  /**
   * Puts all elements with put.
   *
   * @param all items
   * @return {@link Result}, that holds actual result of this operation.
   */
  Result<List<T>> putAll(T... all);

  /**
   * Puts all elements with put.
   *
   * @param all items
   * @return {@link Result}, that holds actual result of this operation.
   */
  Result<List<T>> putAll(Iterable<T> all);

  /**
   * Delete stored entity by its id. If not found, does nothing,
   * returning null in the result.
   *
   * @param id of the item to delete
   * @return {@link Result} that wraps deleted item or null, if not found
   */
  Result<T> delete(long id);

  /**
   * Deletes all items from this collection.
   *
   * @return {@link Result}, that holds actual result of this operation.
   */
  Result<Boolean> deleteAll();

  /**
   * Counts all items in this collection.
   *
   * @return {@link Result}, that holds the number of items in this collection.
   */
  Result<Integer> count();

  /**
   * Returns unmodifiable list of all items in this collection.
   *
   * @return {@link Result}, that holds unmodifiable list
   * of all items in this collection.
   */
  Result<List<T>> all();

  /**
   * Returns unmodifiable list of all items in this collection,
   * that satisfy given predicate.
   *
   * @param predicate test function to filter items
   * @return {@link Result}, with unmodifiable list of all items,
   * that satisfy given predicate.
   */
  Result<List<T>> filter(Predicate<T> predicate);

  /**
   * Test function, used to filter items.
   *
   * @param <T> type of objects to be tested.
   */
  interface Predicate<T> {
    boolean test(T t);
  }
}
