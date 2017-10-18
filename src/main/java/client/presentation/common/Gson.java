package client.presentation.common;


//import com.google.gson.GsonBuilder;

/**
 * Utility class for easy use of com.google.code.gson.
 */
public class Gson
{
//  private static com.google.gson.Gson gson;

//  private static com.google.gson.Gson get()
//  {
//    if (gson == null)
//    {
//      gson = new GsonBuilder().create();
//    }
//    return gson;
//  }

  public static <T> T fromJson(String json, Class clazz)
  {
//    try
//    {
//      Object o = get().fromJson(json, clazz);
//      return (T) o;
//    }
//    catch (Exception e)
//    {
//      return null;
//    }
    return null;
  }

  public static <T> String toJson(T object)
  {
//    return get().toJson(object);
    return null;
  }
}
