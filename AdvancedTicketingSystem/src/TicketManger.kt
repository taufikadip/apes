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
    
    fun assignUser(ticketId: Int, userId: Int) {
        val ticket = tickets.find { it.id == ticketId }
        val user = user.find { it.id == userId }
        if (ticket != null && user != null) {
            ticket.assignee = user
        } else {
            throw Exception("Ticket or user not found")
        }
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
        }
    }

    //View Tickets
    fun viewTickets(){
        if (tickets.isEmpty()) {
            println("No tickets available.")
        } else {
            println("Current Tickets:")
            for (i in tickets){
                println("ID: ${ticket.id}, Description: ${ticket.description}, Priority: ${ticket.priority}, Status: ${ticket.status}, Assignee: ${ticket.assignee?.name ?: "None"}, Due Date: ${ticket.dueDate ?: "None"}")
            }
        }
    }

    //Search Ticket By Id
    fun searchTicketById(ticketId: Int) {
        val ticket = tickets.find { it.id == ticketId }

        if (ticket != null) {
            println("Found Ticket: ID: ${ticket.id}, Description: ${ticket.description}, Priority: ${ticket.priority}, Status: ${ticket.status}, Assignee: ${ticket.assignee?.name ?: "None"}, Due Date: ${ticket.dueDate ?: "None"}")
        } else {
            println("Ticket not found.")
        }
    }
    
}