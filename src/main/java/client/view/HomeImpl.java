/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.view;

import client.presentation.home.Home;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class HomeImpl
  implements Home.View
{
  @Override
  public Widget asWidget()
  {
    return new HTML("Home here!");
  }
}
