package client.view;

import client.presentation.exercise.ExerciseArea;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jadice.web.gwt.fontawesome.client.FontAwesome;

public class ExerciseAreaImpl
  implements ExerciseArea.View
{
  private final FlexTable panel;
  private final Label kanaDisplay;

  private Command guessAction;
  private final TextBox guessBox;
  private final Label feedback;
  private boolean displaySelection;

  public ExerciseAreaImpl()
  {
    panel = new FlexTable();
    panel.setStyleName("exerciseArea");
    kanaDisplay = new Label();
    kanaDisplay.setStyleName("kanaDisplay");

    guessBox = new TextBox();
    guessBox.setStyleName("guessBox");
    guessBox.setMaxLength(3);
    guessBox.addKeyUpHandler(new KeyUpHandler()
    {
      @Override
      public void onKeyUp(KeyUpEvent event)
      {
        if (guessAction != null)
        {
          guessAction.execute();
        }
      }
    });

    feedback = new Label();

    panel.setWidget(0, 0,kanaDisplay);
    panel.setWidget(1, 0, feedback);
    panel.getFlexCellFormatter().setColSpan(1, 0, 2);
    panel.setWidget(2, 0, guessBox);
    panel.getFlexCellFormatter().setColSpan(2, 0, 2);
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
  public void setSelectionWidget(final Widget widget)
  {
    HTML bars = new HTML(FontAwesome.BARS.toSafeHtml());
    bars.addStyleName("bars");
    displaySelection = false;
    bars.addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent event)
      {
        if(!displaySelection)
        {
          panel.getFlexCellFormatter().setColSpan(3, 0, 2);
          panel.setWidget(2, 0, widget);
          displaySelection = true;
        }
        else
        {
          panel.removeRow(2);
          displaySelection = false;
        }
      }
    });

    VerticalPanel options = new VerticalPanel();
    options.add(bars);
    panel.setWidget(0, 1, options);
  }

  @Override
  public void setWidth(int width)
  {
    panel.setWidth(width + "px");
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
