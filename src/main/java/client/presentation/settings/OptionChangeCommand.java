package client.presentation.settings;

public interface OptionChangeCommand<T>
{
  void onChange(String key, T value);
}
