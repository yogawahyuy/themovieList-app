package com.snystudio.themovielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.snystudio.themovielist.config.MovieRepo
import com.snystudio.themovielist.model.DiscoverMovie
import com.snystudio.themovielist.model.LoadingState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val movieRepo: MovieRepo): ViewModel(), Callback<List<DiscoverMovie>> {

    private val _loadingState=MutableLiveData<LoadingState>()
    val loadingState:LiveData<LoadingState> get()=_loadingState

    private val _data= MutableLiveData<List<DiscoverMovie>>()
    val data:LiveData<List<DiscoverMovie>> get() = _data

    init {
        fetchData()
    }
    private fun fetchData(){
        _loadingState.postValue(LoadingState.LOADING)
        movieRepo.getMovie().enqueue(this)
    }
    override fun onResponse(
        call: Call<List<DiscoverMovie>>,
        response: Response<List<DiscoverMovie>>
    ) {
        if (response.isSuccessful){
            _data.postValue(response.body())
            _loadingState.postValue(LoadingState.LOADED)
        }else{
            _loadingState.postValue(LoadingState.eror(response.errorBody().toString()))
        }

    }


    override fun onFailure(call: Call<List<DiscoverMovie>>?, t: Throwable?) {
        _loadingState.postValue(LoadingState.eror(t?.message))
    }
}