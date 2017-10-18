/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LOG
{
  private static final Map<Class, Logger> LOGGER_LOOKUP = new HashMap<Class, Logger>();

  public static void warn(Class clazz, String warning)
  {
    warn(clazz, warning, null);
  }

  private static void warn(Class clazz, String warning, Throwable throwable)
  {
    Logger logger = LOGGER_LOOKUP.get(clazz);
    if(logger == null)
    {
      logger = LoggerFactory.getLogger(clazz);
    }
    logger.warn(warning, throwable);
  }

  public static void error(Class clazz, String warning)
  {
    error(clazz, warning, null);
  }

  public static void error(Class clazz, String warning, Throwable throwable)
  {
    Logger logger = LOGGER_LOOKUP.get(clazz);
    if(logger == null)
    {
      logger = LoggerFactory.getLogger(clazz);
    }
    logger.error(warning, throwable);
  }
}
