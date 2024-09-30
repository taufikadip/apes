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
}