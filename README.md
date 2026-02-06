# Civitas个人小站

<img src="src/images/civitas-icon.svg" alt="Civitas Icon" align="right">

Fork from [Clojure Civitas Website](https://clojurecivitas.github.io).

**快速开始**

1. 运行命令如下

```sh
clojure -M:clay
```

2. 在[`/src`](src)目录下创建clj文件，添加如下元数据

```clojure
^{:kindly/hide-code true     ; don't render this code to the HTML document
  :clay             {:title  "About Civitas Metadata"
                     :quarto {:author   :my-unique-id
                              :draft    true           ; remove to publish
                              :type     :post
                              :date     "2025-06-05"
                              :category :clojure
                              :tags     [:metadata :civitas]}}}
(ns my.namespace.example)
```

3. 编辑文件将自动渲染到浏览器

**注意事项**

> [!TIP]
> 可视化相关参考[Kindly](https://scicloj.github.io/kindly-noted/kindly)。

```clojure
^kind/table
{:tables      ["clean layout" "easy to scan" "communicates clearly"]
 :charts      ["information-dense" "reveals insights" "pattern-focused"]
 :hiccup      ["build anything" "custom layouts" "unlimited flexibility"]
 :many-others ["see the examples" "creative uses" "visual variety"]}
```
参考[Clay examples](https://scicloj.github.io/clay/clay_book.examples.html)。

> [!TIP]
> markdown文件放在 [`/site`](site) 目录，
> 个人日记可以放在 [`/site/blog`](site/blog) 目录。

> [!TIP]
> 图片文件放在同级目录下，通过`;; ![caption](my-image.jpg)`引用。

**网站预览**

```sh
clojure -M:clay -A:markdown
quarto preview site
```

(`bb preview`同时运行以上两条命令)

单个文件命令如下：

```sh
clojure -M:clay -A:markdown games/beginning_to_build_a_browser_game.clj
```