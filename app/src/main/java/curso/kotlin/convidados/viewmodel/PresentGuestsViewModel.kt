package curso.kotlin.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentGuestsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento dos convidados presentes"
    }
    val text: LiveData<String> = _text
}