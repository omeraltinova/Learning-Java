# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

This is a structured Java learning repository organized by sections (Section 4-11), progressing from Java fundamentals to advanced OOP concepts including abstract classes and interfaces. Each section contains practical examples and summaries in Turkish.

## Development Environment

- **IDE**: IntelliJ IDEA (primary)
- **Java Version**: JDK 8 or higher
- **Project Type**: Plain Java module without build tools (no Maven/Gradle)
- **Language**: Code in English, documentation and summaries in Turkish

## Common Commands

### Compilation & Execution

```bash
# Compile a single Java file
javac src/Section{N}/PackageName/ClassName.java

# Compile with dependencies from same section
javac -cp src src/Section{N}/PackageName/*.java

# Run a compiled class with Main method
java -cp src Section{N}.PackageName.Main

# Example: Running Section 11 Abstract Challenge
javac -cp src src/Section11/Abstract/Challange1/*.java
java -cp src Section11.Abstract.Challange1.Store
```

### IntelliJ IDEA Shortcuts

```bash
# Run current file
Shift + F10 (Windows/Linux) or Control + R (macOS)

# Debug current file
Shift + F9 (Windows/Linux) or Control + D (macOS)

# Reformat code
Cmd + Option + L (macOS) or Ctrl + Alt + L (Windows/Linux)
```

### Project Navigation

```bash
# Find all Main classes in the project
find src -name "Main.java" -type f

# Find all Java files in a specific section
find src/Section{N} -name "*.java" -type f

# Count lines of code in a section
find src/Section{N} -name "*.java" -type f | xargs wc -l

# Search for specific concept usage
grep -r "abstract class" src/
grep -r "interface" src/Section11/
```

## Code Architecture

### Section Organization

The codebase follows a progressive learning structure:

```
src/
├── Section4/          # Java fundamentals (variables, conditionals, operators)
├── Section5/          # Methods and control structures
├── Section6/          # User input handling (Scanner)
├── Section7/          # OOP Part 1 (Classes, encapsulation, inheritance)
├── Section8/          # Composition and "has-a" relationships
├── Section9/          # Arrays and variable arguments
├── Section10/         # Lists and ArrayList collections
└── Section11/         # Abstract classes and interfaces
```

### Key Learning Patterns

1. **Progressive Complexity**: Each section builds on previous concepts
2. **Practical Examples**: Real-world scenarios (Library, Computer, Kitchen projects)
3. **Challenge Structure**: Most sections have challenge packages for practice
4. **Documentation**: Each section has a Turkish summary markdown file

### Important Design Patterns Covered

- **Encapsulation**: Section 7 - getter/setter patterns
- **Inheritance Hierarchy**: Section 7 - Animal → Dog/Fish, Worker → Employee
- **Composition**: Section 8 - Computer components, Kitchen appliances
- **Abstract Factory**: Section 11 - ProductForSale abstract class
- **Interface Segregation**: Section 11 - FlightEnabled, Trackable interfaces

## Current Learning Context

**Current Level**: Intermediate (Section 11 completed)
**Active Project**: Library Management System (see Project_1_Library_Management.md)

### Next Learning Goals (from Java_Development_Roadmap.md)
1. Exception Handling & File I/O
2. Generics mastery
3. Advanced Collections & Stream API
4. Multithreading & Concurrency

## Code Style Guidelines

### Naming Conventions
- Classes: PascalCase (e.g., `SmartKitchen`, `PersonalComputer`)
- Methods: camelCase (e.g., `calculateLateFee`, `getItemType`)
- Constants: UPPER_SNAKE_CASE (e.g., `MILES_TO_KILOMETERS`)
- Packages: lowercase (e.g., `abstract`, `inheritance`)

### File Organization
- One public class per file
- Main classes typically in separate files or clearly marked
- Interface definitions often in the same file as implementations (for learning purposes)

## Testing Approach

Currently no formal testing framework. Testing is done through:
- Main methods in each package
- Challenge exercises with expected outputs
- Manual verification of results

Future improvement: Consider adding JUnit tests for practice projects.

## Version Control

Repository uses Git. Key branches/commits:
- Each section completion is typically committed
- Challenge solutions are committed separately

## Special Notes for AI Assistance

1. **Language Context**: Documentation and summaries are in Turkish, but code and comments should be in English
2. **Learning Focus**: Prioritize educational clarity over production-level optimizations
3. **Section Dependencies**: Later sections depend on earlier concepts - ensure understanding of prerequisites
4. **Challenge Solutions**: When helping with challenges, provide guided hints before full solutions
5. **Project Work**: The Library Management project should demonstrate Section 11 concepts (abstract classes, interfaces)

## Resource References

- **README.md**: Overall project structure and section descriptions
- **Java_Development_Roadmap.md**: Learning path and future goals
- **Project_1_Library_Management.md**: Current practical project specifications
- **Section summaries**: Turkish language conceptual explanations in each section

## Common Issues and Solutions

### Issue: Package declaration mismatch
**Solution**: Ensure package declaration matches directory structure from `src/` root

### Issue: Cannot find symbol errors
**Solution**: Check import statements and compile with correct classpath `-cp src`

### Issue: No Main method found
**Solution**: Look for classes with `public static void main(String[] args)`

### Issue: Turkish character encoding
**Solution**: Ensure IDE is set to UTF-8 encoding for proper display of Turkish text
