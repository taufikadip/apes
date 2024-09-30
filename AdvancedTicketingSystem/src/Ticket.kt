data class Ticket(
    val id: Int,
    var description: String,
    val priority: String,
    var status: String,
    var assignee: User? = null,
    var dueDate: LocalDate? = null
) { init {
    require(description.isNotEmpty()){"Deskripsi tidak boleh kosong"}
    require(priority in listOf("Low","Medium", "High")){"Prioritas yang tersedia antara 'Low', 'Medium', atau 'High'"}
    require(status in listOf("Open", "In Progress", "Closed")) {"Status seharusnya 'Open', 'In Progress', or 'Closed'."}
}