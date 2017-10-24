/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.home;

import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;

public class Home
  extends Presenter<Home.View>
{
  public interface View
    extends Presenter.View
  {

  }

  public Home()
  {
    super(GWT.<View>create(View.class));
  }
}
