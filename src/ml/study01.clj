^{:kindly/hide-code true
  :clay             {:title  "机器学习第一阶段：筑基篇 - 打好坚实基础"
                     :quarto {:author   [:weixin]
                              :type     :post
                              :date     "2026-01-20"
                              :category :clojure
                              :tags     ["机器学习"]}}}
(ns ml.study01
  (:require [clojure.data.csv :as csv]
            [scicloj.kindly.v4.api :as kindly]
            [scicloj.kindly.v4.kind :as kind]
            [tablecloth.api :as tc]
            [clojure.java.io :as io]
            [clojure.repl :refer [doc]]
            [clojure.walk :as walk]))


;; 在接触复杂的算法之前，你需要先搭建起支撑知识大厦的地基。
;; 这个阶段的目标是掌握必要的数学、编程和数据分析技能。

;; ## 核心技能一：编程语言（Clojure）

;; 使用Clojure可以使我们更关注于业务本身而不是语法。

;; 接下来我们可以看一个案例。

;; 测试数据 house_prices内容：

(def house-prices (csv/read-csv "面积,价格,房龄,卧室数,城市
45,120,15,1,北京
60,180,12,2,北京
75,260,8,2,北京
90,320,6,3,北京
110,420,5,3,北京
130,520,3,4,北京
50,80,20,1,成都
70,120,15,2,成都
85,150,12,3,成都
100,190,10,3,成都
120,240,8,4,成都
140,300,5,4,成都
55,150,18,1,上海
70,220,14,2,上海
85,300,10,2,上海
100,380,8,3,上海
120,480,6,3,上海
150,650,4,4,上海
40,60,22,1,武汉
65,95,16,2,武汉
80,130,12,2,武汉
95,170,9,3,武汉
115,220,7,3,武汉
135,280,5,4,武汉"))

^:kindly/hide-code
(kind/table house-prices)

;; 执行如下代码，我们可以生成一些散点图

(let [data (map (partial zipmap [:size :price :age :room :city]) (rest house-prices))]
  (kind/plotly {:data [{:x (map :size data)
                        :y (map :price data)
                        :type :scatter
                        :marker {:size 10
                                 :colorscale :Viridis}
                        :mode :markers}]
                :layout {:title "房屋面积 VS价格"
                         :xaxis {:title "面积（平方米）"}
                         :yaxis {:title "价格（万元）"}}
                :style {:width "300px"
                        :height "300px"}}))

;; ## 核心技能二：必要数学知识

;; 你不需要成为数学家，但需要理解算法背后的基本逻辑。

;; - **线性代数**：理解向量、矩阵、矩阵乘法。这是理解数据在多维空间中表示和变换的基础。
;; - **微积分**：重点是理解导数和偏导数的概念。它们是优化算法（如梯度下降）的核心，用于寻找模型的最佳参数。
;; - **概率与统计**：理解均值、方差、标准差、概率分布、条件概率和贝叶斯定理。这对于评估模型、理解不确定性至关重要。