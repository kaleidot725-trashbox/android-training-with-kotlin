package kaleidot725.serializable

import java.io.Serializable

/**
 * Created by kaleidot725 on 2018/01/24.
 */

// Serializeはインタフェースの実装が必要なのと、
// Serializeに関係しない処理が含まれると上手く動作しなくなることもあるので非推奨
// 特に使う理由がないのであれば、ParcelableやJSONを用いるとのこと
// KotlinではSerializableを定義する際はデータクラスを用いると良い
data class SerializableObject(val name : String) : Serializable