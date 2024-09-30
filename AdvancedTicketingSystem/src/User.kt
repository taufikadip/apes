data class User (
    val id: Int,
    val name: String,
    val role: String
) {
    init {
        require(name.isEmpty()) { "Nama tidak boleh kosong." }
        require(role in listOf("User", "Admin")) { "Role yang tersedia hanya Admin dan User." }
    }
}