# ALiveData

[![](https://jitpack.io/v/chanjungkim/AMutableLiveData.svg)](https://jitpack.io/#chanjungkim/AMutableLiveData)

### Setup

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
	        implementation 'com.github.chanjungkim:AMutableLiveData:Tag'
	}
  
### Usage

```kotlin
	val aliveArrayListData = ArrayListMutableLiveData<String>()
    
	// Observe
	aliveArrayListData.observe(this, Observer {
	    tvPrint!!.text = "ALiveData Test ${++cnt}\n ${it.toString()}"
	    runTest()
	})
```

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

# License

MIT License

Copyright (c) 2021 Chanjung Kim

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
