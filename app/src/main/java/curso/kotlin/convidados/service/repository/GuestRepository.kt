package curso.kotlin.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import curso.kotlin.convidados.service.constants.DataBaseConstants
import curso.kotlin.convidados.service.model.GuestModel
import java.lang.Exception
import java.util.ArrayList

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    //Singleton
    companion object {

        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {

            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }

    }

    fun save(guest: GuestModel): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()

            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true

        } catch (e: Exception) {
            false
        }

    }

    fun getAllGuests(guest: GuestModel): List<GuestModel> {

        val list: MutableList<GuestModel> = ArrayList()
        return list

    }

    fun getPresentGuests(guest: GuestModel): List<GuestModel> {

        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsentGuests(guest: GuestModel): List<GuestModel> {

        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun update(guest: GuestModel) {

    }

    fun delete(guest: GuestModel) {

    }

}