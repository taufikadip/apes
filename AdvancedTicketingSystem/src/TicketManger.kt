import java.time.LocalDate

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

    fun updateTicketStatus(ticketId: Int, newStatus: String) {
        val ticket = tickets.find { it.id == ticketId }

        if (ticket != null) {
            if (newStatus in listOf("Open", "In Progress", "Closed")) {
                ticket.status = newStatus
                println("Ticket '${ticket.description}' status updated to $newStatus.")
            } else {
                println("Invalid status. Status must be 'Open', 'In Progress', or 'Closed'.")
            }
        } else {
            println("Ticket not found.")
        }
    }

    // Set the due date of a ticket
    fun setDueDate(ticketId: Int, dueDate: String) {
        val ticket = tickets.find { it.id == ticketId }

        if (ticket != null) {
            try {
                val parsedDate = LocalDate.parse(dueDate)
                ticket.dueDate = parsedDate
                println("Due date for ticket '${ticket.description}' set to $dueDate.")
            } catch (e: DateTimeParseException) {
                println("Invalid date format. Please use YYYY-MM-DD.")
            }
        } else {
            println("Ticket not found.")
        }
    }
}