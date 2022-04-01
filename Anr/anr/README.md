# Excel


## 1.使用
* 1，初始化
```xml
ExcelHelp.getInstance().init(getApplicationContext());
```
* 2，数据收集
```xml
ExcelHelp.getInstance().getInfo().mAppInfoInit = System.currentTimeMillis()+"";
```
* 3，适当的时机去提交数据
```xml
//注：提交一次就是提交excel一行数据
ExcelHelp.getInstance().submit();
```
## 2.项目引用
* 1，root build.gradle中
```groovy
classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.8'
```
* 2，module build.gradle中
```groovy
apply plugin: 'android-aspectjx'
implementation 'com.github.zhuyidian.lib_Instrument:excel:V1.1.8'
```
