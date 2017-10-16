package client.presentation;

import client.logic.Kana;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Logical presentation of an are, which shows random kanas and a text-field for users to input their guesses, which romaji the current kana stands for.
 */
public class ExerciseArea extends Presenter<ExerciseArea.View>
{
  /**
   * currently shown kana
   */
  private Kana currentKana;

  /**
   * all kanas this excercising area alternates between
   */
  private Kana[] kanas;

  public interface View extends IsWidget
  {
    void showKana(String kana);

    void setGuessAction(Command guessAction);

    String getGuess();

    void clearGuess();

    void focus();
  }

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

    String guess = getView().getGuess();
    if(guess == null)
    {
      return;
    }

    if(guess.toLowerCase().trim().equals(currentKana.getRomaji()))
    {
      getView().clearGuess();
      nextExercise();
    }
  }

  @Override
  protected void onShow()
  {
    super.onShow();

    nextExercise();

    getView().focus();
  }

  public void nextExercise()
  {
    int kanaCount = kanas.length;

    int randomKanaIndex = (int) (Math.random() * kanaCount);

    currentKana = kanas[randomKanaIndex];

    getView().showKana(currentKana.getHiragana());
  }

  public void setKanas(Kana[] kanas)
  {
    this.kanas = kanas;
  }
}
