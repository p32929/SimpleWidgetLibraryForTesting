# SimpleWidgetLibraryForTesting

A small test project that answers one question: **can an Android home-screen widget live inside a library module** (`appwidgetlibrary`) instead of the app itself, and still work when the app uses that library? The answer is yes, and this repo shows how.

It is an experiment kept for reference, not a library to use in your app.

## What's in here

| Module | What it is |
|---|---|
| `appwidgetlibrary/` | A library module containing an `AppWidgetProvider` (`MyAppWidget1`) and a small `WebActivity` |
| `app/` | A demo app that depends on the module and hosts the widget |

## The point

`appwidgetlibrary/src/main/java/.../WidgetRelated/MyAppWidget1.java` is the home-screen widget, declared in the **library's** manifest. The app module just pulls the library in — proving a widget provider and its manifest entry survive being packaged in an Android library.

## Build and run

```bash
git clone https://github.com/p32929/SimpleWidgetLibraryForTesting.git
```

Open it in Android Studio, run the `app` module on a device/emulator, then add the widget from your launcher's widget picker.

## License

MIT License — Copyright (c) 2018 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are very welcome, thank you! Before you start on a pull request, please open an issue and tell me what you would like to add or change. That way we can agree on it first, and your time is not wasted on something that might not fit. Thanks for helping make this example better.

## Share

<a href="https://p32929.github.io/share/?repo=SimpleWidgetLibraryForTesting"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/share-dark.svg"><img src="https://p32929.github.io/readme/share-light.svg" alt="Share this with your friends in just a click" width="420"></picture></a>

## Support

<a href="https://p32929.github.io/support/"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/support-dark.svg"><img src="https://p32929.github.io/readme/support-light.svg" alt="If you like my works and want to support me, feel free to support" width="420"></picture></a>
