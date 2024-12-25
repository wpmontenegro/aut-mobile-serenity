# Automation Test Mobile Android/iOS

## Architecture

This project is built with **Serenity-BDD** and **Appium**, integrated with **BrowserStack/SauceLabs** for mobile testing.

![Architecture](docs/arq-aut-mobile-serenity.jpg)

---

## TestApp

### Download the App

1. Download **MyDemoApp** from the following link:  
   [**MyDemoApp**](https://github.com/saucelabs/my-demo-app-rn/releases/)

### Local Execution

- To run mobile tests locally:  
  Download the app and place it in the directory:  
  `src/test/resources/app/`

### Cloud Execution

- To run mobile tests in the cloud:  
  - Upload the app to **BrowserStack/SauceLabs** and verify the `bstack` or `sauce` profile configuration.
  - Set **BrowserStack Credentials** as environment variables: {`BROWSERSTACK_USER` and `BROWSERSTACK_KEY`} or {`SAUCE_USER` and `SAUCE_KEY`}

---

## Run Tests

### Command to Execute Tests

Run the following command in the terminal:

```
gradlew clean test --tests "*.TestCartRunner" -Dplatform={PLATFORM} -Dtype={DRIVER}
```

### Accepted Parameters

`platform` (required):

Specifies the mobile platform to test. Supported values:

```
android (for Android devices)
ios (for iOS devices)
```

`type` (required):

Defines the driver type. Supported values:

```
local (to execute tests on a locally connected device or emulator)
bstack (to execute tests using BrowserStack)
sauce (to execute tests using SauceLabs)
```