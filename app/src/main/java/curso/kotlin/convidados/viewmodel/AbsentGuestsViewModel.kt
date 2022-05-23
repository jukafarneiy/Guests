package curso.kotlin.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentGuestsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento dos convidados ausentes"
    }
    val text: LiveData<String> = _text
}