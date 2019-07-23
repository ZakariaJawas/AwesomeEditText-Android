# AwesomeEditText-Android

![Release](https://img.shields.io/github/release/zakariajawas/AwesomeEditText-Android.svg) ![Licence](https://img.shields.io/github/license/zakariajawas/AwesomeEditText-Android.svg) ![Downloads](https://img.shields.io/github/downloads/zakariajawas/AwesomeEditText-Android/total.svg)

## Installation
Add Jitpack to your repositories in your `build.gradle` file

```
allprojects {
    repositories {
      // ...
      maven { url 'https://jitpack.io' }
    }
}
```

Add the below to your dependencies, again in your `gradle.build` file

```
implementation 'com.github.ZakariaJawas:AwesomeEditText-Android:{release}'
```

## Preview

**title**

![title](https://github.com/ZakariaJawas/AwesomeEditText-Android/blob/master/images/EditTextHint.gif)


**clearable**

![clearable](https://github.com/ZakariaJawas/AwesomeEditText-Android/blob/master/images/clearable.png)


**validation**

![validation](https://github.com/ZakariaJawas/AwesomeEditText-Android/blob/master/images/validation.png)



## Usage

**basic**

```xml
    <com.edunology.awsomezakedittext.AwesomeEditText
        android:id="@+id/cleanableEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        app:hint="Please enter your name"
        app:title="Full name" >      
```
**available properities**

_border color_

`app:border_color="#8997B3"`

_border color when edittext got focus_

`app:focus_border_color="#3b5998"`

_title color when user starts typing and the title goes to the top as a hint_

`app:upper_hint_color="#8997B3"`

_title background color when it goes to the top as a hint (used to hide the border line behinde the text so it must be the same as the parent's layout background color)_

`app:upper_hint_background=""`

_text color_

`app:text_color="#3b5998"`

_show the clear button when user starts typing (default is false)_

`app:is_clearable="true"`

_supporting RIGHT-TO-LEFT (default is false)_

`app:is_rtl="true"`


## Compatibility
Minimum Android SDK: API level 15

## Author
Zakaria Jawas [@zakariajawas](https://twitter.com/zakariajawas)
`AwesomeEditText` design was inspired by [MDalsaeed](https://github.com/MDalsaeed)
## Getting help
If you spot a problem you can open an issue on the Github page, or alternatively, you can contact me via `jawas.zakaria@gmail.com`

If you enjoy, please make this library better :)

