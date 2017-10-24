package client.presentation.layout;

import client.logic.Kana;
import client.presentation.common.Presenter;
import client.presentation.common.ResponsivePresenter;
import client.presentation.events.ChangeContentEvent;
import client.presentation.exercise.ExerciseArea;
import client.presentation.home.Home;
import client.presentation.settings.SettingsArea;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;

public class Navigation
  extends ResponsivePresenter<Navigation.View>
{
  private Home home;
  private ExerciseArea exerciseArea;
  private SettingsArea settingsArea;

  public interface View
    extends Presenter.View, ResponsivePresenter.View
  {
    void setShowMobileMenu(boolean show);

    void addNavigation(String label, Command command);
  }

  public Navigation()
  {
    super(GWT.<View>create(View.class));

    Command showStartPage = new Command()
    {
      @Override
      public void execute()
      {
        if(home == null)
        {
          home = new Home();
        }
        changePage(new ChangeContentEvent(home));
      }
    };
    getView().addNavigation("Home", showStartPage);

    getView().addNavigation("Exercise", new Command()
    {
      @Override
      public void execute()
      {
        navigateToExercise();
      }
    });

    getView().addNavigation("Settings", new Command()
    {
      @Override
      public void execute()
      {
        if(settingsArea == null)
        {
          settingsArea = new SettingsArea();
        }
        changePage(new ChangeContentEvent(settingsArea));
      }
    });

    showStartPage.execute(); // by default, show start page

    navigateToExercise();
  }

  public void navigateToExercise()
  {
    if(exerciseArea == null)
    {
      exerciseArea = new ExerciseArea(Kana.ALL_KANA);
    }
    changePage(new ChangeContentEvent(exerciseArea));
  }

  private void changePage(ChangeContentEvent event)
  {
    getView().setShowMobileMenu(false);
    getEventBus().fireEvent(event);
  }
}
