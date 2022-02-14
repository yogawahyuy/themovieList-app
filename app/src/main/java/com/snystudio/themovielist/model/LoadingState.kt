package com.snystudio.themovielist.model

import javax.net.ssl.SSLEngineResult

data class LoadingState private constructor(val status: Status,val msg:String?=null){
    companion object{
        val LOADED=LoadingState(Status.SUCCES)
        val LOADING=LoadingState(Status.RUNNING)
        fun eror(msg: String?)=LoadingState(Status.FAILED,msg)

    }
    enum class Status{
        RUNNING,SUCCES,FAILED
    }
}
