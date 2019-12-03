# TopActivity
### 展示当前app所处的最顶activity<br>
#### GIF展示：<br>
![](https://github.com/FantasyEngineer/TopActivity/blob/master/topdemo.gif)  <br>
### 引入：<br>
Step 1.Add it in your root build.gradle at the end of repositories:<br>
```Java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
  Step 2. Add the dependency<br>
 ```Java
 	dependencies {
	        compile 'com.github.FantasyEngineer:TopActivity:V3.0'
	}
```
### 代码使用<br>
```Java
     //展示
       TopActivity.INSTANCE.show(MainActivity.this);
     //消失
     TopActivity.INSTANCE.dismiss(MainActivity.this);
```



