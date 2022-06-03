package curso.kotlin.convidados.service.constants

class GuestConstants private constructor() {
    companion object {
        const val GUESTID = "guestID"
    }

    object FILTERS {
        const val EMPTY = 0
        const val PRESENTS = 1
        const val ABSENTS = 2
    }
}