package kaleidot725.parcelable

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by kaleidot725 on 2018/01/29.
 * https://qiita.com/nonylene/items/df90157b1f89b077d98b
 */
class MyParcelable : Parcelable {
    // クラス内のシングルトンとして定義する
    // そのためcompanion objectを利用する
    companion object {
        // JvmFieldを付けない場合、Javaから呼び出す際に問題が出るらしい
        @JvmField

        // object式を利用してParcelable.Createを継承した無名のオブジェクトを作成する
        val CREATOR: Parcelable.Creator<MyParcelable> =  object : Parcelable.Creator<MyParcelable> {
            override fun createFromParcel(source: Parcel): MyParcelable {
                return MyParcelable(source)
            }

            override fun newArray(size: Int): Array<MyParcelable?> {
                // サイズ分の要素を持つ配列を返す、各要素はNULL値で初期化される。
                return arrayOfNulls(size)
            }
        }
    }

    var mData : Int? = null

    constructor()
    constructor(parcel : Parcel) {
        mData = parcel.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        if (mData == null) {
            return
        }
        dest?.writeInt(mData as Int)
    }
}
