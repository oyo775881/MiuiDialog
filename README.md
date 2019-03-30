# MiuiDialog [![](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)  [![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)  [![](https://jitpack.io/v/oyo775881/MiuiDialog.svg)](https://jitpack.io/#oyo775881/MiuiDialog) [![Gradle-5.2.1](https://img.shields.io/badge/Gradle-5.2.1-brightgreen.svg)](https://img.shields.io/badge/Gradle-5.2.1-brightgreen.svg)

## 简介

    仿MIUI10对话框（界面，动画，功能）
    
    支持对话框，输入框，列表对话框，进度对话框

## 使用

> Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	
> Step 2. 然后在 build.gradle(Module:app) 的 dependencies 添加:

	dependencies {
	       implementation 'com.github.oyo775881:MiuiDialog:+'
	}
	
## 效果

> 对话框

<img src="https://raw.githubusercontent.com/oyo775881/MiuiDialog/master/screenshot/01.png" width="250" height="auto"/>

> 输入框

<img src="https://raw.githubusercontent.com/oyo775881/MiuiDialog/master/screenshot/02.png" width="250" height="auto"/>

> 列表框

<img src="https://raw.githubusercontent.com/oyo775881/MiuiDialog/master/screenshot/03.png" width="250" height="auto"/>

> 进度框

<img src="https://raw.githubusercontent.com/oyo775881/MiuiDialog/master/screenshot/04.png" width="250" height="auto"/>

## 文档

> 对话框

    new MiuiQueryDialog.Builder(this)//Activity
        .setCancelable(true)//是否点击外部消失
        .setTitle("MIUI对话框")//标题
        .setContent("MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框")//内容
        .setNegativeButton("取消", v -> Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_LONG).show())//左边的按钮
        .setPositiveButton("确认", v -> Toast.makeText(MainActivity.this, "点击了确认", Toast.LENGTH_LONG).show())//右边的按钮
        .show()//显示

> 输入框

    new MiuiInputDialog.Builder(this)
        .setCancelable(false)//是否点击外部消失
        .setTitle("MIUI输入框")//标题
        .setContent("MIUI输入框")//内容
        .setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)//输入类型
        .setNegativeButton("取消", content -> Toast.makeText(MainActivity.this, "点击了取消:" + content, Toast.LENGTH_LONG).show())//左边的按钮
        .setPositiveButton("确认", content -> Toast.makeText(MainActivity.this, "点击了确认:" + content, Toast.LENGTH_LONG).show())//右边的按钮
        .show()
        
> 列表框

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("男");
    arrayList.add("女");
    new MiuiListDialog.Builder(this)
        .setCancelable(false)//是否点击外部消失
        .setTitle("测试List")//标题
        .setList(arrayList)//列表数组
        .setSelector(1)//选中项，不可大于数组
        .setListListener((position, content) -> Toast.makeText(MainActivity.this, "点击了选项:" + position + content, Toast.LENGTH_LONG).show())//点击列表项监听
        .setPositiveButton("取消", (position, content) -> Toast.makeText(MainActivity.this, "点击了取消:" + position + content, Toast.LENGTH_LONG).show())//按钮
        .show()//显示

> 进度框

    new MiuiLoadDialog.Builder(this)
        .setCancelable(false)//是否点击外部消失
        .setContent("加载中")//内容
        .show()//显示
        
## Licenses

    Copyright 2018 oyo775881
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    