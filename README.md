# StudyNest (StudyGroupFinderProject)

**Study Nest — Where Hawks Study Smart.**  
StudyNest is a full-stack web application designed to help students find, create, and join study groups. It makes collaboration simple, organized, and useful.

---

## Features

### User Authentication
- Login with backend validation  

### Create Study Groups
- Add title, subject, date, and time  
- Uses Factory Pattern for clean object creation  

### Find Study Groups
- Search by keywords (title/subject)  
- View all groups if no search input is provided  

### Join Study Groups
- Connect users to groups via backend logic  

### Responsive UI
- Custom CSS design system  
- Clean, modern layout  

---

## Tech Stack

### Frontend
- HTML  
- CSS  
- JavaScript (Fetch API)

### Backend
- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  

### Database
- H2 for development

---

## Design Patterns Used

### Factory Pattern
Centralizes the creation of `StudyGroup` objects.

```java
StudyGroup group = StudyGroupFactory.create(title, subject, date, time);
