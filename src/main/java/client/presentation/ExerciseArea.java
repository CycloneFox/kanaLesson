package client.presentation;

import client.Kana;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.IsWidget;

public class ExerciseArea extends Presenter<ExerciseArea.View>
{

  private Kana currentKana;

  public interface View extends IsWidget
  {
    void showKana(String kana);

    void setGuessAction(Command guessAction);

    String getGuess();
  }

  private Kana[] kanas;

  public ExerciseArea(Kana... kanas)
  {
    super(GWT.create(View.class));
    this.kanas = kanas;

    getView().setGuessAction(new Command()
    {
      @Override
      public void execute()
      {
        takeGuess();
      }
    });
  }

  private void takeGuess()
  {
    if (currentKana == null)
    {
      return;
    }

    String text = getView().getGuess();
    if (text == null)
    {
      return;
    }

    if (text.toLowerCase().trim().equals(currentKana.getRomaji()))
    {
      nextExercise();
    }
  }

  @Override
  protected void onShow()
  {
    super.onShow();

    nextExercise();
  }

  private void nextExercise()
  {
    int kanaCount = kanas.length;

    int randomKanaIndex = (int) (Math.random() * kanaCount);

    currentKana = kanas[randomKanaIndex];

    getView().showKana(currentKana.getKana());
  }

  public void setKanas(Kana[] kanas)
  {
    this.kanas = kanas;
  }
}
