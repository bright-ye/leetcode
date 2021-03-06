# leetcode笔记

## 单调栈

### 什么时候使用单调栈

当需要判断一个数组，左边或右边第一个比自己大或者小的元素时，就应该要想到单调栈

### 单调栈的模板

单调栈，那必须得有一个栈，并且栈中的元素得需要是单调递增或递减的。

单调栈只需要将数组遍历一遍，时间复杂度是O(n)，本质上仍然是拿空间换时间

做了几道单调栈的题目，都是寻找下一个更大元素系列的，简单总结单调栈的模板如下：

```java
for i...nums.len{
	while(栈不为空 && nums[curr] > nums[栈顶元素]){
		result[栈顶元素] = nums[curr]
		出栈
	}
	i进栈
}
```

思路是：

1. 先把数组的第一个元素下标压入栈中；
2. 结果数组全部赋值
3. 开始遍历数组，如果数组当前元素大于栈顶元素，那么给result[相应下标]赋值当前元素，同时继续栈顶元素弹出
4. 把当前元素的下标压入栈中

题型总结：

1. 如果遇到有循环数组，则将数组循环两次

   ```java
   for(int i = 0;i<nums.length * 2 - 1;i++)
   ```

2. 如果遇到两个数组：

   1. nums1的元素可能都是在nums2中
   2. num1和nums2的元素在各自数组中都不重复，则可以使用map
   3. 使用map时，需要考虑到数组中有没有重复元素

