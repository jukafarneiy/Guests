package curso.kotlin.convidados.service.constants

class DataBaseConstants {

    object GUEST {
        const val TABLE_NAME = "Tabela de Convidados"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "nome"
            const val PRESENCE = "presença"
        }
    }
}