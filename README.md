# ALiveData

[![](https://jitpack.io/v/chanjungkim/ALiveData.svg)](https://jitpack.io/#chanjungkim/ALiveData)

### How to

Step 1. 
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.chanjungkim:ALiveData:Tag'
	}
  
### Usage

```kotlin
        // This is valid for the first time
        aliveArrayListData
            .add("ADD 1\n")
            .add("ADD 2\n")
            .update()

        // This won't do anything
        aliveArrayListData
            .add("ADD 3\n")
            .add("ADD 4\n")

        // You need to set new value to make aliveArrayListData usable
        aliveArrayListData
            .set(txtList)
            .add("===========\n")
            .update()

        // You need to use keep() for keeping the current data of ALiveArrayListData after calling update.
        aliveArrayListData
            .keep()
            .add("ADD 5")
            .add("ADD 6")
            .update()
```

```kotlin
	val aliveArrayListData = ALiveArrayListData<String>()
    
	// Observe
	aliveArrayListData.observe(this, Observer {
	    tvPrint!!.text = "ALiveData Test ${++cnt}\n ${it.toString()}"
	    runTest()
	})
```
