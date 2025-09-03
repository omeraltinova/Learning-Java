# 📚 Proje 1: Library Management System

## 🎯 Proje Hedefi
Section 11'de öğrendiğiniz **Abstract Classes**, **Interfaces**, ve **Collections** bilgilerini pekiştiren gerçek dünya projesi.

---

## 🏗️ Sistem Architecture

### Core Components
```
Library Management System
├── Models (Abstract & Concrete Classes)
│   ├── Item (Abstract)
│   ├── Book extends Item
│   ├── Magazine extends Item  
│   └── DVD extends Item
├── Interfaces
│   ├── Borrowable
│   ├── Searchable
│   └── Manageable
├── Services
│   ├── LibraryService
│   └── UserService
└── Storage
    └── FileManager (JSON persistence)
```

---

## 🔧 Technical Requirements

### Must-Have Features
- [ ] **Item Management**: Add, remove, update library items
- [ ] **User Management**: Register users, manage profiles
- [ ] **Borrowing System**: Check out/in items with due dates
- [ ] **Search Functionality**: Find items by title, author, category
- [ ] **File Persistence**: Save/load data from JSON files

### Nice-to-Have Features
- [ ] **Fine Calculation**: Late return penalties
- [ ] **Reservation System**: Queue for popular items  
- [ ] **Report Generation**: Usage statistics
- [ ] **Category Management**: Dynamic categories

---

## 📋 Implementation Phases

### Phase 1: Core Models (Bu Hafta)
#### Abstract Item Class
```java
public abstract class Item implements Borrowable, Searchable {
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected LocalDate dueDate;
    
    // Abstract methods to implement
    public abstract String getItemType();
    public abstract double getLateFee(LocalDate returnDate);
    public abstract void displayDetails();
}
```

#### Concrete Implementations
- **Book**: Author, ISBN, genre fields
- **Magazine**: Issue number, publication date
- **DVD**: Director, duration, rating

### Phase 2: Interface Implementation (Gelecek Hafta)
#### Core Interfaces
```java
interface Borrowable {
    boolean checkOut(String userId);
    boolean checkIn();
    boolean isOverdue();
    double calculateLateFee();
}

interface Searchable {
    boolean matches(String searchTerm);
    String getSearchableText();
}

interface Manageable {
    void save();
    void load();
    void update();
}
```

### Phase 3: Service Layer (3. Hafta)
- Collection management with ArrayLists/HashMaps
- User management system
- Search algorithms implementation

### Phase 4: Persistence (4. Hafta)  
- JSON file operations
- Data validation
- Error handling

---

## 💡 Learning Objectives

### Week 1: Abstract Classes Mastery
- Abstract class design patterns
- Template method pattern usage
- Inheritance vs composition decisions

### Week 2: Interface Implementation
- Multiple interface implementation
- Default methods usage
- Interface segregation principle

### Week 3: Collections Integration
- ArrayList vs HashMap usage
- Custom comparators
- Search and sort algorithms

### Week 4: File I/O & Exception Handling
- JSON serialization
- Exception hierarchy design
- Resource management

---

## 🎯 Success Criteria

### Technical Achievements
- [ ] Clean abstract class hierarchy
- [ ] Multiple interface implementation
- [ ] Proper exception handling
- [ ] JSON persistence working
- [ ] Search functionality complete

### Learning Achievements
- [ ] Abstract class design understanding
- [ ] Interface best practices
- [ ] Collection framework usage
- [ ] File operations confidence
- [ ] Error handling proficiency

---

## 🚀 Getting Started

### Step 1: Project Setup
1. Create new package: `LibraryManagement`
2. Set up folder structure
3. Create basic abstract Item class
4. Write first unit test

### Step 2: Model Development
- Implement Book class first
- Add Borrowable interface
- Test basic functionality

### Step 3: Expand Gradually
- Add Magazine and DVD classes
- Implement search functionality  
- Add user management

---

## 📝 Daily Tasks (Week 1)

### Day 1: Project Setup
- [ ] Create project structure
- [ ] Design Item abstract class
- [ ] Write basic constructors

### Day 2: Book Implementation
- [ ] Implement Book class
- [ ] Add Borrowable interface
- [ ] Write unit tests

### Day 3: Multiple Item Types
- [ ] Add Magazine class
- [ ] Add DVD class  
- [ ] Test inheritance

### Day 4: Interface Integration
- [ ] Implement Searchable interface
- [ ] Add search functionality
- [ ] Test polymorphism

### Day 5: Collections Integration
- [ ] Create Library class
- [ ] Use ArrayList for items
- [ ] Implement basic CRUD operations

---

Bu proje, Section 11'de öğrendiğiniz tüm kavramları gerçek dünyada uygulama fırsatı verecek ve bir sonraki section için güçlü bir temel oluşturacak!

## 🤝 Mentoring Approach
Projeyi geliştirirken karmaşık kısımlarda size rehberlik edeceğim, ama temel implementasyonları siz yapacaksınız. Bu şekilde öğrenme maksimize olur!