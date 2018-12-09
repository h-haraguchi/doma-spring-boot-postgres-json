# これは何？
[doma-spring-boot](https://github.com/domaframework/doma-spring-boot)を使用して
postgresqlのjson型へjson文字列を格納することができるようにするサンプル実装です。
`kotlin`で実装しています。

[kotlin用のDomaガイド](https://doma.readthedocs.io/ja/stable/kotlin-support/)にそって実装してましたが、`build`タスク実行時にSQLファイルのリソースを検知してくれませんでした。
`compileJava.dependsOn processResources` でjavaのコンパイルより前にリソースコピーするようにしてたので見よう見まねで`kotlin`用の宣言(`compileKotlin.dependsOn processResources`)を書いたら解決しました。


本実装において`Json`クラスはjson文字列にしか対応してません。
