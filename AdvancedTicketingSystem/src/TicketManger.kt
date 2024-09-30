class TicketManger {
    val tickets = mutableListOf<Ticket>()
    val users = mutableListOf<User>()

    fun createTicket(description: String, priority: String): Ticket {
        val ticket = Ticket(
            id = tickets.size + 1,
            description = description,
            priority = priority,
            status = "Open",
            assignee = null,
            dueDate = null
        )
        tickets.add(ticket)
        return ticket
    }

    fun assignUser(ticketId: Int, userId: Int) {
        val ticket = tickets.find { it.id == ticketId }
        val user = user.find { it.id == userId }
        if (ticket != null && user != null) {
            ticket.assignee = user
        } else {
            throw Exception("Ticket or user not found")
        }
    }
}