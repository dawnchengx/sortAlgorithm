# sortAlgorithm
```
cd java
javac -encoding UTF-8 Main.java && javap Main.class && java Main
```


```
// "1w随机数排序100次的平均时间(Java压测)"

......
private int randomNum = 10000; // 随机数的数量
private int testCount = 100; // 压测的次数
......

基础冒泡排序耗时：122.357933ms
优化冒泡排序耗时：101.650605ms
基础快速排序耗时：0.667169ms
递归版优化快速排序耗时：0.691681ms
循环版优化快速排序耗时：4.722155ms
基础插入排序耗时：10.107073ms
希尔优化插入排序耗时：0.774114ms
选择排序耗时：27.230833ms
```


