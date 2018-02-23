package client.view;

import client.presentation.common.ButtonHandle;
import client.presentation.exercise.ExerciseArea;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExerciseAreaImpl
  implements ExerciseArea.View
{
  private final FlexTable panel;
  private final Label kanaDisplay;

  private Command guessAction;
  private final TextBox guessBox;
  private final Label feedback;
  private final VerticalPanel options;

  public ExerciseAreaImpl()
  {
    panel = new FlexTable();
    panel.setWidth("100%");
    panel.getColumnFormatter().setWidth(1, "30px");
    panel.setStyleName("exerciseArea");
    kanaDisplay = new Label();
    kanaDisplay.setStyleName("kanaDisplay");

    guessBox = new TextBox();
    guessBox.setStyleName("guessBox");
    guessBox.setWidth("99%"); // at 100%, the textbox overflows a little for most browsers, causing horizontal scrolling, etc.
    guessBox.setMaxLength(3);
    guessBox.addKeyUpHandler(event -> {
      if (guessAction != null)
      {
        guessAction.execute();
      }
    });

    feedback = new Label();

    panel.getFlexCellFormatter().setColSpan(1, 0, 2);
    panel.getFlexCellFormatter().setColSpan(2, 0, 1);
    panel.setWidget(0, 0,kanaDisplay);
    panel.setWidget(1, 0, feedback);
    panel.setWidget(2, 0, guessBox);

    // kinda like a vertical button bar
    options = new VerticalPanel();
    panel.setWidget(0, 1, options);
  }

  @Override
  public void removeOverlay()
  {
    panel.setWidget(1, 0, feedback);
    panel.setWidget(2, 0, guessBox);
    panel.getFlexCellFormatter().setColSpan(1, 0, 2);
    panel.getFlexCellFormatter().setColSpan(2, 0, 1);
  }

  @Override
  public void overlayArea(Widget widget)
  {
    panel.removeRow(1);
    if(widget != null)
    {
      panel.setWidget(1, 0, widget);
    }
  }

  @Override
  public ButtonHandle addBigFontButton()
  {
    final HTML button = new HTML();
    button.setStyleName("bigButton");
    options.add(button);

    return new ButtonHandle()
    {
      @Override
      public void setAction(final Command action)
      {
        button.addClickHandler(new ClickHandler()
        {
          @Override
          public void onClick(ClickEvent event)
          {
            action.execute();
          }
        });
      }

      @Override
      public void setLabel(SafeHtml label)
      {
        button.setHTML(label);
      }
    };
  }

  @Override
  public void showKana(String kana)
  {
    kanaDisplay.setText(kana);
  }

  @Override
  public void setGuessAction(Command guessAction)
  {
    this.guessAction = guessAction;
  }

  @Override
  public String getGuess()
  {
    return guessBox.getText();
  }

  @Override
  public void clearGuess()
  {
    guessBox.setValue(null);
  }

  @Override
  public void focus()
  {
    guessBox.setFocus(true);
  }

  @Override
  public void setFeedBack(String feedback)
  {
    this.feedback.setText(feedback);
  }

  @Override
  public Widget asWidget()
  {
    return panel.asWidget();
  }
}
