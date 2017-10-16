package client.view;

import client.presentation.ExerciseArea;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExerciseAreaImpl
  implements ExerciseArea.View
{
  private final VerticalPanel panel;
  private final Label kanaDisplay;

  private Command guessAction;
  private final TextBox guessBox;

  public ExerciseAreaImpl()
  {
    panel = new VerticalPanel();
    kanaDisplay = new Label();
    kanaDisplay.setStyleName("kanaDisplay");

    guessBox = new TextBox();
    guessBox.addKeyUpHandler(event ->
    {
      if (guessAction != null)
      {
        guessAction.execute();
      }
    });

    panel.add(kanaDisplay);
    panel.add(guessBox);
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
  public Widget asWidget()
  {
    return panel.asWidget();
  }
}
