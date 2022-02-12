# SmartClickableSpan [![](https://jitpack.io/v/HseinNd98/SmartClickableSpan.svg)](https://jitpack.io/#HseinNd98/SmartClickableSpan)
Easiest and fastest way to implement Clickable Spans for Android. 
Adding regular Clickable Spans in Android requires calculating sizes for each clickable text, and when it comes to adding a lot of clickable and regular words or sentences in a TextView is becomes a mess..
By using SmartClickableSpan, you'll be able to add whatever amount of clickable words or sentences without any worries of calculating length of each text on every update on it.

## Download
To implement SmartClickableSpan in your project:

### Using Gradle:
Step 1. Add JitPack in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Step 2. Add the dependency:
```
dependencies {
        implementation 'com.github.HseinNd98:SmartClickableSpan:v0.1.5'
}
```

### Using Maven:
Step 1. Add the JitPack repository to your build file:
```
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```
Step 2. Add the dependency:
```
<dependency>
    <groupId>com.github.HseinNd98</groupId>
    <artifactId>SmartClickableSpan</artifactId>
    <version>0.1.5</version>
</dependency>
```

## How do I use SmartClickableSpan?
### Single clickable text:
```
new SmartClickableSpan
  .Builder(this)
  .regularText("I agree to all ")
  .clickableText(new ClickableOptions().setText("Terms of Use").setOnClick(new ClickableSpan() {
      @Override
      public void onClick(@NonNull View view) {
          // Your Code..
      }
  }))
  .into(myTextView);
```

### More clickable texts:
```
new SmartClickableSpan
  .Builder(this)
  .regularText("I agree to all ")
  .clickableText(new ClickableOptions().setText("Terms of Use").setOnClick(new ClickableSpan() {
      @Override
      public void onClick(@NonNull View view) {
          // Your Code..
      }
  }))
  .regularText(" and ")
  .clickableText(new ClickableOptions().setText("Privacy Policy").setOnClick(new ClickableSpan() {
      @Override
      public void onClick(@NonNull View view) {
          // Your Code..
      }
  }))
  .into(myTextView);
```

### Customizing:
```
ClickableOptions clickableOptions = new ClickableOptions();
clickableOptions.setColor(Color.BLUE);
clickableOptions.setText("terms and conditions");
clickableOptions.setOnClick(new ClickableSpan() {
    @Override
    public void onClick(@NonNull View view) {
       // Your Code..
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
       // Customizing your clickable text
       ds.setUnderlineText(false);
       ds.setColor(Color.BLUE);
       //...
    }
});

new SmartClickableSpan
  .Builder(this)
  .regularText("I agree to all ")
  .clickableText(clickableOptions)
  .into(myTextView);
```

## Optional useful methods:
- **autoSpacing()** Adds space automatically every time a new text is added, which helps to keep the sentence well formed. (*Default: false*)
- **setHighlightColor(int color)** Removes highlight color on clickable texts. (*Default: Color.Transparent*)

## Compatibility:
- **Minimum Android SDK:** requires a minimum API level of 15

## Applications using this library:
- [**CookFeed**](https://play.google.com/store/apps/details?id=com.cookfeed.recipes)
