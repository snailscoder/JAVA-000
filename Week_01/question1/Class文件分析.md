# 作业1-Class文件分析

```java
package com.snailscoder.learn.week01;

public class Hello {

    public static final int[] MULTIPLIER = {1, 2, 4, 8};

    public static void main(String[] args) {
        int num = 5;
        int maxValue = 200;
        Hello hello = new Hello();
        int result = hello.shiftSum(num, maxValue);
        System.out.println(result);
    }

    private int shiftSum(int num, int maxValue){
        int sum = 0;
        for (int multiplier: MULTIPLIER) {
            sum = sum + (num * multiplier);
            if(sum > maxValue){
                return sum;
            }
        }
        return sum;
    }
}
```
```java
Classfile /Users/huaxin/IdeaProjects/javaLearn/target/classes/com/snailscoder/learn/week01/Hello.class
  Last modified 2020-10-18; size 1043 bytes
  MD5 checksum 46bd01d48464ba9e58a5c8a1f2f58863
  Compiled from "Hello.java"
public class com.snailscoder.learn.week01.Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #8.#37         // java/lang/Object."<init>":()V
   #2 = Class              #38            // com/snailscoder/learn/week01/Hello
   #3 = Methodref          #2.#37         // com/snailscoder/learn/week01/Hello."<init>":()V
   #4 = Methodref          #2.#39         // com/snailscoder/learn/week01/Hello.shiftSum:(II)I
   #5 = Fieldref           #40.#41        // java/lang/System.out:Ljava/io/PrintStream;
   #6 = Methodref          #42.#43        // java/io/PrintStream.println:(I)V
   #7 = Fieldref           #2.#44         // com/snailscoder/learn/week01/Hello.MULTIPLIER:[I
   #8 = Class              #45            // java/lang/Object
   #9 = Utf8               MULTIPLIER
  #10 = Utf8               [I
  #11 = Utf8               <init>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               LocalVariableTable
  #16 = Utf8               this
  #17 = Utf8               Lcom/snailscoder/learn/week01/Hello;
  #18 = Utf8               main
  #19 = Utf8               ([Ljava/lang/String;)V
  #20 = Utf8               args
  #21 = Utf8               [Ljava/lang/String;
  #22 = Utf8               num
  #23 = Utf8               I
  #24 = Utf8               maxValue
  #25 = Utf8               hello
  #26 = Utf8               result
  #27 = Utf8               shiftSum
  #28 = Utf8               (II)I
  #29 = Utf8               multiplier
  #30 = Utf8               sum
  #31 = Utf8               StackMapTable
  #32 = Class              #38            // com/snailscoder/learn/week01/Hello
  #33 = Class              #10            // "[I"
  #34 = Utf8               <clinit>
  #35 = Utf8               SourceFile
  #36 = Utf8               Hello.java
  #37 = NameAndType        #11:#12        // "<init>":()V
  #38 = Utf8               com/snailscoder/learn/week01/Hello
  #39 = NameAndType        #27:#28        // shiftSum:(II)I
  #40 = Class              #46            // java/lang/System
  #41 = NameAndType        #47:#48        // out:Ljava/io/PrintStream;
  #42 = Class              #49            // java/io/PrintStream
  #43 = NameAndType        #50:#51        // println:(I)V
  #44 = NameAndType        #9:#10         // MULTIPLIER:[I
  #45 = Utf8               java/lang/Object
  #46 = Utf8               java/lang/System
  #47 = Utf8               out
  #48 = Utf8               Ljava/io/PrintStream;
  #49 = Utf8               java/io/PrintStream
  #50 = Utf8               println
  #51 = Utf8               (I)V
{
  //常量数组，在static方法中执行初始化操作
  public static final int[] MULTIPLIER;
    descriptor: [I
    flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL

  //Hello默认无参构造方法
  public com.snailscoder.learn.week01.Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      
      stack=1, locals=1, args_size=1
         //从局部变量0中装载引用类型值，局部变量表中0位置为当天对象this的引用。其他局部变量从1开始。
         //所有非静态方法编译时都会在方法参数中加入当天对象的引用this参数。
         //因存在this，故此处args_size=1，locals=1
         0: aload_0
         //调用父类的init方法
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/snailscoder/learn/week01/Hello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=5, args_size=1      //
         0: iconst_5              //常量5压入栈
         1: istore_1              //局部变量表1: num
         2: sipush        200         //将16位带符号整数200压入栈,-1~5采用单独的iconst命令将常量压入栈，其中-1为iconst_m1
         5: istore_2              //局部变量maxValue
         6: new           #2                  // 创建一个新对象 class com/snailscoder/learn/week01/Hello
         9: dup                 //将栈顶的元素复制一份，也就是当前栈存在两个Hello对象的引用。
                            //原因是下一步invokespecial调用初始化的时候会消耗一个。方法的第一个参数。
                                              //还需要留一个引用保存到局部变量表，即赋值给局部变量hello： Hello hello = new Hello();
        10: invokespecial #3                  // 初始化Hello对象，Method "<init>":()V
        13: astore_3              //将栈顶Hello对象的引用赋值给hello变量
        14: aload_3
        15: iload_1
        16: iload_2
        17: invokespecial #4                  // Method shiftSum:(II)I
        20: istore        4
        22: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        25: iload         4
        27: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
        30: return
      LineNumberTable:
        line 8: 0
        line 9: 2
        line 10: 6
        line 11: 14
        line 12: 22
        line 13: 30
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      31     0  args   [Ljava/lang/String;
            2      29     1   num   I
            6      25     2 maxValue   I
           14      17     3 hello   Lcom/snailscoder/learn/week01/Hello;
           22       9     4 result   I

  private int shiftSum(int, int);
    descriptor: (II)I
    flags: ACC_PRIVATE
    Code:
      stack=3, locals=8, args_size=3
         0: iconst_0             //0压入栈
         1: istore_3             //此处为局部变量3：sum=0，其中0，1，2分别为this、num,maxValue
         2: getstatic     #7                  // Field MULTIPLIER:[I
         5: astore        4           //引用类型 MULTIPLIER:[I
         7: aload         4
         9: arraylength             //数据长度
        10: istore        5           //数组长度放入局部变量5
        12: iconst_0
        13: istore        6           //局部变量6，当前MULTIPLIER数组的遍历索引0
        15: iload         6
        17: iload         5
        19: if_icmpge     49          //比较当前索引与数组长度，如果>=,则跳出循环
        22: aload         4           //当前数组
        24: iload         6           //当前遍历索引
        26: iaload                //从数组中取出对应索引的元素
        27: istore        7           //保存到本地变量7
        29: iload_3               //局部变量3 sum
        30: iload_1               //局部变量1：num
        31: iload         7           //局部变量7：当前遍历的数组元素
        33: imul                //两数相城
        34: iadd                //乘机结果 + sum
        35: istore_3              //sum保存在局部变量3
        36: iload_3
        37: iload_2
        38: if_icmple     43          //比较sum与maxValue大小，<=则跳转
        41: iload_3               //sum压栈
        42: ireturn               //返回
        43: iinc          6, 1          //当前数组索引+1
        46: goto          15          //下一个循环
        49: iload_3
        50: ireturn
      LineNumberTable:
        line 16: 0
        line 17: 2
        line 18: 29
        line 19: 36
        line 20: 41
        line 17: 43
        line 23: 49
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           29      14     7 multiplier   I
            0      51     0  this   Lcom/snailscoder/learn/week01/Hello;
            0      51     1   num   I
            0      51     2 maxValue   I
            2      49     3   sum   I
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 15
          locals = [ class com/snailscoder/learn/week01/Hello, int, int, int, class "[I", int, int ]
          stack = []
        frame_type = 27 /* same */
        frame_type = 248 /* chop */
          offset_delta = 5

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=4, locals=0, args_size=0
         0: iconst_4
         1: newarray       int      //创建数组并将引用压入栈
         3: dup
         4: iconst_0
         5: iconst_1
         6: iastore
         7: dup
         8: iconst_1
         9: iconst_2
        10: iastore
        11: dup
        12: iconst_2
        13: iconst_4
        14: iastore
        15: dup
        16: iconst_3
        17: bipush        8
        19: iastore
        20: putstatic     #7                  // Field MULTIPLIER:[I
        23: return
      LineNumberTable:
        line 5: 0
}
SourceFile: "Hello.java"

```
