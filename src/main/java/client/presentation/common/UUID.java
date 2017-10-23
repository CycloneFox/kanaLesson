package client.presentation.common;

public class UUID
{
  // allowed chars
  private static final char[] UUID_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

  // default UUID length
  private static final int DEFAULT_UUID_LEN = 16;

  /**
   * Returns a UUID with an optional postfix for debugging purposes.
   *
   * @param postfix for debugging purposes
   */
  public static String getUUID(String postfix)
  {
    char[] uuid = new char[DEFAULT_UUID_LEN];

    // Compact form
    for(int index = 0; index < DEFAULT_UUID_LEN; index += 1)
    {
      uuid[index] = UUID_CHARS[(int) (Math.random() * UUID_CHARS.length)];
    }

    return String.valueOf(uuid) + (postfix == null ? "" : "(" + postfix + "");
  }
}
