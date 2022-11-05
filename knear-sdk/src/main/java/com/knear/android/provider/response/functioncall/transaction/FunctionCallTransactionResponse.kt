package com.knear.android.provider.response.functioncall.transaction

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.Response
import android.util.Log


data class FunctionCallTransactionResponse(

    @SerializedName("jsonrpc") var jsonrpc: String? = null,
    @SerializedName("result") var result: Result = Result(),
    @SerializedName("id") var id: Int? = null

) {
    companion object {
        @JvmStatic
        @JvmName("create")
        fun Response.toFunctionCallTransactionResponse(): FunctionCallTransactionResponse {
            val gson = Gson()
//            Log.i("TransactionResponse", this.toString() + " " + this.body?.string() +   " " + this.isSuccessful);
            if (this.isSuccessful) {
                this.body?.let {
                    return gson.fromJson(it.string(), FunctionCallTransactionResponse::class.java)
                } ?: FunctionCallTransactionResponse()
            }
            return FunctionCallTransactionResponse()
        }
    }
}
