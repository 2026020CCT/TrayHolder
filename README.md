# Food Tray Storage System

## Project Overview

The **Food Tray Storage System** is a Java console-based application developed for the Algorithms and Constructs CA-1 assignment. The project demonstrates how data structures can be used to organise and manage food trays in a storage system.

Users can add food trays, remove trays, view stored trays, and check the tray at the front or top of the storage structure.

## Project Objectives

- Develop a menu-driven Java application.
- Implement stack and queue data structures.
- Apply object-oriented programming principles.
- Manage food tray information, including name, weight, and dates.
- Handle invalid input and empty or full storage conditions.
- Analyse the time complexity of the main operations.

## Features

- **Stack operations:** Add a tray, remove the top tray, view the top tray, and display stored trays.
- **Queue operations:** Add a tray to the queue, remove a tray, view the next tray, and display stored trays.
- **Input validation:** Validate user input and handle invalid values.
- **Storage capacity:** The intended maximum capacity is 8 trays per data structure.
- **Date validation:** Check that the best-before date is within the permitted 14-day period.

*Note: Features listed above should be checked against the final implemented code before submission.*

## Data Structures

### Stack — LIFO

A stack follows the **Last In, First Out (LIFO)** principle. The most recently added tray is the first tray removed.

### Queue — FIFO

A queue follows the **First In, First Out (FIFO)** principle. The earliest added tray is the first tray removed.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Arrays
- Stack and queue data structures
- `LocalDate` for date handling

## Time Complexity

| Operation | Stack | Queue (array with shifting) |
|---|---|---|
| Add | O(1) | O(1) |
| Remove | O(1) | O(n) |
| Peek | O(1) | O(1) |
| Display | O(n) | O(n) |
| Search | O(n) | O(n) |

The queue complexity assumes that the implementation shifts the remaining elements after removing a tray. Update this table if the final implementation uses a different approach.

## How to Run the Project

1. Install a Java Development Kit (JDK).
2. Clone or download this repository.
3. Open the project in an IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code.
4. Locate the `TrayHolder.java` file.
5. Run the `main()` method.
6. Follow the menu options displayed in the terminal.

## Testing

The application should be tested with the following scenarios:

- Add a tray to an empty storage structure.
- Remove a tray when the structure is empty.
- Display trays when storage is empty.
- Add trays until the capacity is reached.
- Attempt to add a tray when storage is full.
- Check that stack and queue removal follow their correct ordering rules.
- Enter invalid weights and dates.
- Test valid and invalid best-before dates.

## Project Structure

The project currently uses the `trayholder` package.

```text
Food-Tray-Storage-System/
├── src/
│   └── trayholder/
│       └── TrayHolder.java
└── README.md
```

*Adjust this structure to match the actual files in your repository.*

## Author

**Student:** [Sukhbat Enkhbaatar]  
**Module:** Algorithms and Constructs  
**Assessment:** CA-1  
**Course:** Higher Diploma in Computing

## Academic Integrity

This project was developed for educational purposes. Any AI assistance, external sources, or references used during development should be acknowledged in accordance with the assessment brief and the college's academic integrity requirements.
