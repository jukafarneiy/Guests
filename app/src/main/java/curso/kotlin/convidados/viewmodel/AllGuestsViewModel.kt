package curso.kotlin.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import curso.kotlin.convidados.service.constants.GuestConstants
import curso.kotlin.convidados.service.model.GuestModel
import curso.kotlin.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun loadAll(filter: Int) {
        when (filter) {
            GuestConstants.FILTERS.EMPTY -> {
                mGuestList.value = mGuestRepository.getAllGuests()
            }
            GuestConstants.FILTERS.PRESENTS -> {
                mGuestList.value = mGuestRepository.getPresentGuests()
            }
            else -> {
                mGuestList.value = mGuestRepository.getAbsentGuests()
            }
        }
    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }

}