package client.presentation.layout;

import java.util.HashMap;
import java.util.Map;

import client.logic.AppData;
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

    Map<String, Command> navigationCommands = new HashMap<>();
    navigationCommands.put(Home.class.getSimpleName(), showStartPage());
    navigationCommands.put(ExerciseArea.class.getSimpleName(), navigateToExercise());
    navigationCommands.put(SettingsArea.class.getSimpleName(), navigateToSettings());

    getView().addNavigation("Home", navigationCommands.get(Home.class.getSimpleName()));
    getView().addNavigation("Exercise", navigationCommands.get(ExerciseArea.class.getSimpleName()));
    getView().addNavigation("Settings", navigationCommands.get(SettingsArea.class.getSimpleName()));

    String selectedPage = AppData.get().getSelectedPage();
    Command pageCommand = navigationCommands.get(selectedPage);
    if(pageCommand == null)
    {
      pageCommand = navigationCommands.get(Home.class.getSimpleName()); // by default, show start page
    }

    pageCommand.execute();
  }

  private Command showStartPage()
  {
    return new Command()
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
  }

  private Command navigateToSettings()
  {
    return new Command()
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
    };
  }

  private Command navigateToExercise()
  {
    return new Command()
    {
      @Override
      public void execute()
      {
        if(exerciseArea == null)
        {
          exerciseArea = new ExerciseArea(Kana.ALL_KANA);
        }
        changePage(new ChangeContentEvent(exerciseArea));
      }
    };
  }

  private void changePage(ChangeContentEvent event)
  {
    getView().setShowMobileMenu(false);
    getEventBus().fireEvent(event);
  }
}
