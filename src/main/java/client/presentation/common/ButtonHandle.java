package client.presentation.common;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Command;

public interface ButtonHandle
{
  void setAction(Command action);

  void setLabel(SafeHtml label);
}
