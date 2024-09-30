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