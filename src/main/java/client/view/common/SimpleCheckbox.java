package client.view.common;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTML;
import org.jadice.web.gwt.fontawesome.client.FontAwesome;

public class SimpleCheckbox
  extends HTML
  implements HasValueChangeHandlers<Boolean>
{
  private final String label;
  private boolean value;
  private HandlerManager handlerManager;

  public SimpleCheckbox(String label)
  {
    this.label = label;
    addStyleName("simpleCheckBox");
    addStyleName("hasBorder");
    setValue(false);

    setHtml();

    addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent event)
      {
        setValue(!value);
      }
    });
  }

  private void setHtml()
  {
    SafeHtmlBuilder sb = new SafeHtmlBuilder();

    sb.append(value ? FontAwesome.CHECK_SQUARE_O.toSafeHtml() : FontAwesome.SQUARE_O.toSafeHtml());

    if(label != null)
    {
      sb.appendHtmlConstant("<br>");
      sb.appendEscaped(label);
    }

    setHTML(sb.toSafeHtml());
  }

  private static String getStyle(boolean value)
  {
    return value ? "simpleCheckBoxChecked" : "simpleCheckBoxUnchecked";
  }

  public void setValue(boolean value)
  {
    setValue(value, false);
  }

  public void setValue(boolean value, boolean silent)
  {
    doChange(value);
    if(!silent)
    {
      ValueChangeEvent.fire(SimpleCheckbox.this, value);
    }
  }

  private void doChange(boolean value)
  {
    this.value = value;

    setHtml();
    removeStyleName(getStyle(!value));
    addStyleName(getStyle(value));
  }

  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler)
  {
    return addHandler(handler, ValueChangeEvent.getType());
  }
}
