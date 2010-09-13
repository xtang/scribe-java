package org.scribe.utils;

import java.util.*;

public class MapUtils
{

  public static final Map<String, List<String>> sort(Map<String, List<String>> map)
  {
    Preconditions.checkNotNull(map, "Cannot sort a null object.");

    Map<String, List<String>> sorted = new LinkedHashMap<String, List<String>>();
    for (String key : getSortedKeys(map))
    {
      if(map.get(key).size() > 1)
      {
        Collections.sort(map.get(key));
      }
      sorted.put(key, map.get(key));
    }
    return sorted;
  }

  private static List<String> getSortedKeys(Map<String, List<String>> map)
  {
    List<String> keys = new ArrayList<String>(map.keySet());
    Collections.sort(keys);
    return keys;
  }

  @SuppressWarnings("unchecked")
  public static final <T> Map<String, List<T>> toListMap(Map<String, T> map)
  {
    Preconditions.checkNotNull(map, "Cannot sort a null object.");

    Map<String, List<T>> result = new HashMap<String, List<T>>();
    for (Map.Entry<String, T> entry : map.entrySet())
    {
      result.put(entry.getKey(), Arrays.asList(entry.getValue()));
    }
    return result;
  }
}
