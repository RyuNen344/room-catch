# room-catch
~~androidx.roomのバグ確認用プロジェクト~~
javaの予約語だとkaptがおかしくなるよって仕様の確認用プロジェクト

## 概要
- roomは@Entityがついているclassをテーブル定義として使用するがcolumn名がcatchだとpublic constructorがマッチングせずビルド失敗になる
- **kaptの仕様としてjavaの予約語は使ってはいけないよ、という話**

### 確認方法
- [entity](https://github.com/RyuNen344/room-catch/tree/master/app/src/main/java/com/ryunen344/room/column/db/entity)を用意してあるのでkeyの部分をcatchに変更してビルドしてみてください
- 下記のようにビルド失敗になると思います


```log
エラー: Entities and POJOs must have a usable public constructor. You can have an empty constructor or a constructor whose parameters match the fields (by name and type).
public final class StringEntity {
             ^
  Tried the following constructors but they failed to match:
  StringEntity(int,java.lang.String) -> [param:id -> matched field:id, param:catch -> matched field:unmatched]\room-catch\app\build\tmp\kapt3\stubs\debug\com\ryunen344\room\column\db\entity\StringEntity.java:9: エラー: Cannot find setter for field.
    private final int id = 0;
```

### 原因
- [ここ](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-master-dev:room/compiler/src/main/kotlin/androidx/room/processor/PojoProcessor.kt;l=376)でエラーが吐かれているのは確認したが詳しい原因まで終えてないです
- ~~roomが中で使ってるgoogle AutoValueが悪いのやもしれません~~
- [issue tracker](https://issuetracker.google.com/issues/129374517)
- [your track](https://youtrack.jetbrains.com/issue/KT-27804)


### 結論
**kaptでjavaの予約語は使ってはいけない**
