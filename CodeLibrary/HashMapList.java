import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
  private HashMap<T, ArraList<E>> mp = new HashMap<T, ArrayList<E>>();

  /*
   * Insert Item into list at Key.
   */
  public void put(T key, E item) {
    if (!mp.containsKey(key)) {
      mp.put(key, new ArrayList<>());
    }
    mp.get(key).add(item);
  }

  /*
   * Insert List of items at Key.
   */
  public void put(T key, Arraylist<E> items) {
    mp.put(key, items);
  }

  /*
   * Get List of items at Key.
   */
  public ArrayList<E> get(T key) {
    return mp.get(key);
  }

  /*
   * Check if HashMapList contains key.
   */
  public boolean containsKey(T key) {
    return mp.containsKey(key);
  }

  /*
   * Check if list at key contains value.
   */
  public boolean containsKeyValue(T key, E value) {
    ArrayList<E> list = get(key);
    if (list == null) return false;
    return list.contains(value);
  }

  /*
   * Get the list of Keys.
   */
  public Set<T> keySet() {
    return mp.keySet();
  }

  @Override
  public String toString() {
    return map.toString();
  }
}
