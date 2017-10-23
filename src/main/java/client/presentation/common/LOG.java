package client.presentation.common;

/**
 * Utility class to use Loggers without having a constant field in each class.
 */
public class LOG
{
//  private static final Map<Class, Logger> LOGGER_LOOKUP = new HashMap<Class, Logger>();

  public static void warn(Class clazz, String warning)
  {
    warn(clazz, warning, null);
  }

  private static void warn(Class clazz, String warning, Throwable throwable)
  {
//    Logger logger = LOGGER_LOOKUP.get(clazz);
//    if(logger == null)
//    {
//      logger = LoggerFactory.getLogger(clazz);
//    }
//    logger.warn(warning, throwable);
  }

  public static void error(Class clazz, String warning)
  {
    error(clazz, warning, null);
  }

  public static void error(Class clazz, String warning, Throwable throwable)
  {
//    Logger logger = LOGGER_LOOKUP.get(clazz);
//    if(logger == null)
//    {
//      logger = LoggerFactory.getLogger(clazz);
//    }
//    logger.error(warning, throwable);
  }
}
