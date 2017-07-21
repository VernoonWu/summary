# dot总结

## digraph有向图属性

* **尺寸调解**

  1. size="4,4"，单位是英寸。

  2. 布局方向调节，LR/RL/TB/BT，默认是TB，即从上到下。

  3. rank调节，{rank="same";  node1; node2}，使node1和node2的rank等级相同。     

  4. 图形属性汇总

     | 名称           |     缺省值     | 值                                        |
     | ------------ | :---------: | ---------------------------------------- |
     | bgcolor      |     --      | 画图的背景图                                   |
     | center       |    FALSE    | 在page的中心画图                               |
     | clusterrank  |    local    | global或none                              |
     | color        |    black    | 对cluster,outline颜色等等的没有指定fillcolor时的默认颜色 |
     | comment      |     --      | 注释                                       |
     | compound     |    FALSE    | 允许cluster之间的边缘                           |
     | concentrate  |    FALSE    | 允许边缘的集中                                  |
     | fillcolor    |    black    | cluster的填充色                              |
     | fontcolor    |    black    | 字体颜色                                     |
     | fontname     | Times-Roman | 字体族                                      |
     | fontpath     |     --      | 字体搜索路径                                   |
     | fontsize     |     14      | 字体大小                                     |
     | label        |     --      | 任意字符串                                    |
     | labeljust    |  centered   | l和r用于cluster标签的左对齐和右对齐                   |
     | labelloc     |     top     | t和b用于cluster标签的上对齐和下对齐                   |
     | layers       |     --      | id--id--id                                 |
     | margin       |     0.5     | page的空白，英寸                               |
     | mclimit      |      1      | mincross的跌带比例因子                          |
     | nodesep      |    0.25     | 结点之间的间隔，英寸                               |
     | nslimit      |     --      | 如果设置了f，则使用网络界限迭代f(结点数)来设置x坐标             |
     | nslimit1     |     --      | 如果设置了f，则使用网络界限迭代f(结点数)设置结点排名(rank)       |
     | ordering     |     --      | 如果out则外部边缘顺序会保留                          |
     | orientation  |  portrait   | 如果没用rotate，而值为landscape，使用风景画定位          |
     | page         |     --      | 标记页，例如"8.5,11"                           |
     | pagedir      |     BL      | 多页之间的横断                                  |
     | quantum      |     --      | 结点标签的尺寸根据quantum的量度                      |
     | rank         |     --      | same,min,max,source,sink                 |
     | rankdir      |     TB      | LR(从左向右)或TB(从上到下)                        |
     | ranksep      |    0.75     | 等级之间的间隔，英寸                               |
     | ratio        |     --      | 近似朝向approximate  aspect ratio desired，fill或auto |
     | remincross   |     --      | 如果为true且有多个集群，重新运行crossing最小化            |
     | rotate       |     --      | 如果为90，设置朝向                               |
     | samplepoints |      8      | 输出时用以表现椭圆和圆所用的点数，参见附录C                   |
     | searchsize   |     30      | 切除的最大边缘，当用以寻找网络中的最小一个(完全没看懂?)            |
     | size         |     --      | 最大绘图尺寸，英寸                                |
     | style        |     --      | 图形选项，例如集群的filled                         |
     | URL          |     --      | 图形锚点，依赖于格式                               |

## 结点属性

* **结点形状**     

  1. shape = "box" ，"circle"，"record"，"plaintext"，"polygon"。 

     * 绘制多边形 (polygon)

       形状 polygon 参数 regular , peripheries 和 orientation，数字化参数 sides ,skew ,distortion 。 skew (-1.0~1.0)为从上到下的倾斜度参数，可以用 于把一个矩形转换成平行四边形。distortion为从上到下缩短多边形参数，负数表示增加。可以用于把矩形变成梯形。

       ```
       //画梯形
       digraph G
       {
           a->b->c;
           b->d;
           a[shape=polygon,sides=5,peripheries=3,color=lightblue,style=filled];
           c[shape=polygon,sides=4,skew=.4,label="hello world"];
           d[shape=invtriangle];
           e[shape=polygon,sides=4,distortion=.7];
       }
       ```

       ![test](https://github.com/VernoonWu/summary/blob/master/pic.png)

     * 递归生成多个结点   

       ```c
       digraph structs
       {
       	node[shape=record];
           struct1[shape=record,label="<f0> left|<f1> middle|<f2> right"];
           struct2[shape=record,label="<f0> one|<f1> two"];
           struct3[shape=record,label="hello\nworld |{ b |{c|<here> d|e}| f}| g | h"];
           struct1->struct2;
           struct1->struct3;
       }
       ```

![test2](https://github.com/VernoonWu/summary/blob/master/pic2.png)

  2.  结点属性汇总

      | 名称          |       缺省值       | 值                          |
      | :---------- | :-------------: | :------------------------- |
      | color       |      black      | 结点颜色                       |
      | comment     |       --        | format-depend              |
      | distortion  |       0.0       | 结点扭曲(polygon)              |
      | fillcolor   | lightgrey/black | 结点填充色                      |
      | fixedsize   |      false      | 标签文字不影响结点大小                |
      | fontcolor   |      black      | 字体颜色                       |
      | fontname    |   Times-Roman   | 字体名                        |
      | fontsize    |       14        | 字体大小                       |
      | group       |       --        | 结点所属的组                     |
      | height      |       .5        | 以英寸为单位的高度                  |
      | label       |       结点名       | 任意字符串                      |
      | layer       |      覆盖范围       | all,id 或 id--id            |
      | orientation |       0.0       | 结点旋转角度                     |
      | peripheries |      形状依赖       | 结点界限数量                     |
      | regular     |      false      | 使多边形变得规则                   |
      | shape       |     ellipse     | 结点形状                       |
      | shapefile   |       --        | 扩展的EPSF或SVG自定义形状文件         |
      | sides       |        4        | polygon边数量                 |
      | skew        |       0.0       | polygon相位差                 |
      | style       |       --        | 图形选项(bold ,dotted,filled)  |
      | URL         |       --        | 指定结点的URL(format-dependent) |
      | width       |       .75       | 以英寸为单位的宽度                  |
      | z           |       0.0       | VRML输出的z轴数据                |



## 边的属性

* 属性汇总

  | 名称             |      缺省值       | 值                            |
  | -------------- | :------------: | ---------------------------- |
  | arrowhead      |     normal     | 箭头的样式                        |
  | arrowsize      |       1        | 箭头的比例因子                      |
  | arrowtail      |     normal     | 箭头尾部的样式                      |
  | color          |     black      | 边缘的颜色                        |
  | comment        |       --       | 任意字符串，依赖于格式                  |
  | constraint     |      TRUE      | 强制约束，通过边缘限制结点范围              |
  | decorate       |       --       | 修饰，如果设置了，会画线连接标签到其他边缘        |
  | dir            |    forward     | forward,back,both,none       |
  | fontcolor      |     black      | 字体颜色                         |
  | fontname       |  Times-Roman   | 字体族                          |
  | headlabel      |       --       | 箭头标签                         |
  | headport       |       --       | n,ne,e,se,s,sw,w,nw          |
  | headURL        |       --       | 如果输出格式为ismap时，标签附上URL        |
  | label          |       --       | 边缘标签                         |
  | labelangle     |      -25       | 边缘标签的旋转角度                    |
  | labeldistance  |       1        | 边缘标签距离结点的比例因子                |
  | labelfloat     |     FALSE      | 边缘标签位置的强制约束                  |
  | labelfontcolor |     black      | 标签字体颜色                       |
  | labelfontname  |  Times-Roman   | 标签字体族                        |
  | labelfontsize  |       14       | 标签字体大小                       |
  | layer          | overlay  range | all,id,或id--id                |
  | lhead          |       --       | 箭头使用的簇(cluster)的名字           |
  | ltail          |       --       | 箭尾使用的簇(cluster)的名字           |
  | minlen         |       1        | 头尾间最小长度                      |
  | samehead       |       --       | 头结点的tag，拥有相同头结点tag的边缘会使用统一端点 |
  | sametail       |       --       | 同上，尾结点                       |
  | style          |       --       | 图形选项，例如bold,dotted,filled    |
  | taillabel      |       --       | 箭尾标签                         |
  | tailport       |       --       | n,ne,e,se,s,sw,w,nw          |
  | tailURL        |       --       | 当输出格式为ismap时箭尾标签附加的URL       |
  | weight         |       1        | 边缘的延伸花费整数                    |

