# master-toast-android 

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.phamhuuan:master-toast-android:0.0.1'
}
```
## Usage

Each method always returns a `MasterToast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

To display an default Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.DEFAULT);
```
To display a success Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.SUCCESS);
```
To display an info Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.INFO);
```
To display a warning Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.WARNING);
```
To display the error Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.ERROR);
```
To display the confusing Toast:

``` java
MasterToast.makeText(this,"Hello World !",MasterToast.LENGTH_LONG,MasterToast.CONFUSING);
```
