# 贪吃蛇


### 项目介绍
试着用java开发一个简单的贪吃蛇程序。

### 项目部分
1. 核心算法
2. GUI显示部分
3. 控制部分
4. 主体程序部分

### 一些技术规范
1. 使用二维数组map来制作地图。
2. map地图数组大小可变。
3. 使用双缓冲技术刷新界面。
4. 使用LinkedList<Point>来实现蛇的主体。
5. 将GetKet实例传入Game中，来实现实时获取。
6. 将Game实例传入GameJpanel中，来实现实时绘制。
7. GetKey实例为独立线程来获取按键。
8. Game实例为独立线程用来自动运算游戏数据。
9. GameJPanel实例为独立线程，不断刷新，来实时显示游戏内容。
10. 为实现按键获取，GetKey继承自TextField，来实现获取按键事件。

### 文件说明
1. Desktop.java
窗口主体程序。
2. Game.java
游戏核心算法程序。
3. GameJPanel.java
游戏显示画板程序.
4. GetKey.java
按键获取程序。
5. Point.java
基础点类。
6. JF_Options.java
设置窗口类。
7. JF_About.java
关于窗口类。


### 目前人员
1. 夜猫
2. 杨超超
3. 李栋

### 遇到的问题记录
- 2018-5-15  开发进度缓慢
- 2018-5-16  实现按键获取需要该类继承自可以使用KeyEvent的类

### 版本更新记录
- 2018-5-14  大体框架建立。
- 2018-5-15  GameJPanel部分基本功能实现。

![简单测试一下绘制功能](https://gitee.com/uploads/images/2018/0515/161827_8c0e1669_1790958.png "简单测试一下绘制功能.png")

- 2018-5-15  修复了GameJPanel绘制蛇主体的判断bug
- 2018-5-16  基本实现了GetKey类的功能。
- 2018-5-16  基本实现JF_Options窗口设置游戏参数功能。
- 2018-5-16  实现了界面根据Game信息自动拉伸功能。

![设置界面](https://gitee.com/uploads/images/2018/0516/212026_b1cf8042_1790958.png "设置界面.png")

![设置后界面](https://gitee.com/uploads/images/2018/0516/212041_eb9d327c_1790958.png "设置后界面.png")
