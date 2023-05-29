# 结构体内存对齐

每个特定平台的编译器有自己的**封装对齐系数**， gcc中可以通过 `#pragma pack(num)`来设置该对齐系数。

**有效对齐系数** 结构体中最长数据长度与封装对齐系数的最小值。

对其系数 
- 结构体内存成员按照声明顺序存储
- 结构体第一个成员的偏移量为0
- 其他的成员offset必须是当前成员类型的对其系数与有效对齐系数中最小值的整数倍,编译器会在上一个成员变量与当前成员变量之间填充字节。
- 结构体的总大小为 有效对齐值 的整数倍，如有需要编译器会在最末一个成员之后加上填充字节。
 换言之，假定对结构体$Struct$,依次存在成员变量$m_0, m_1, m_2, \cdots, m_n$，我们记${off}_i$为第
$i$个成员变量相对于该结构体首地址的偏移量，${a_i}$为各个成员变量的对齐系数, 即${a_i}=alignof(m_i)$， 封装对齐系数为`n`, 则我们有
1. $off_0 = 0$
2. $off_i | min(s_i, n)$
3. $sizeof(Struct) | min(n, max(s_0,s_1,\cdots,m_n))$

## alignof(T)
该方法用于获取结构体T的有效对齐系数。

## alignas
alignas可以指定结构体的对齐系数，若指定的值小于结构体原本的对齐系数，则不生效。

若想强制指定结构体的对齐系数， 可以使用`#pragma pack(push n)`, 其中n为新的对齐系数。


Reference 
- [The Lost Art of Structure Packing](http://www.catb.org/esr/structure-packing/)
- [失传的C结构体打包技艺](https://github.com/ludx/The-Lost-Art-of-C-Structure-Packing)