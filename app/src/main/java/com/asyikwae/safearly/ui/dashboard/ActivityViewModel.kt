package com.asyikwae.safearly.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    private val questionList = arrayListOf<String>(
        "Sudah mengkonsumsi makanan sehat?",
        "Sudah melakukan kegiatan stimulasi otak?",
        "Sudah melakukan kegiatan fisik selama 30 menit?"
    )
    private val _question = MutableLiveData<ArrayList<String>>().apply {
        postValue(questionList)
    }
    val text: LiveData<ArrayList<String>> = _question
}