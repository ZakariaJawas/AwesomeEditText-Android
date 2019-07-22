# AwesomeEditText-Android

![Release](https://img.shields.io/github/release/zakariajawas/AwesomeEditText-Android.svg) ![Licence](https://img.shields.io/github/license/zakariajawas/AwesomeEditText-Android.svg) ![Downloads](https://img.shields.io/github/downloads/zakariajawas/AwesomeEditText-Android/total.svg)

## Installation
Add jitpack to your repositories in your `build.gradle` file

```
allprojects {
    repositories {
      // ...
      maven { url 'https://jitpack.io' }
    }
}
```

Add the below to your dependencies, again in your `gradle.build` file

```implementation 'com.github.ZakariaJawas:AwesomeEditText-Android:{release}'```

## Preview

### title

(https://github.com/ZakariaJawas/AwesomeEditText-Android/blob/master/images/EditTextHint.gif)

### clearable



## Usage

basic

```xml
    <com.edunology.awsomezakedittext.AwesomeEditText
        android:id="@+id/cleanableEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        app:hint="Please enter your name"
        app:title="Full name" >      
```


## Compatibility
Minimum Android SDK: API level 15

## Author
Zakaria Jawas [@zakariajawas](https://twitter.com/zakariajawas)

## Getting help
If you spot a problem you can open an issue on the Github page, or alternatively, you can contact me via `jawas.zakaria@gmail.com`

If you enjoy, please make this library better :)

