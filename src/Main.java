import java.util.Scanner;

// Custom class representing a movie
class Movie {
    private String title;
    private int releaseYear;

    // Constructor
    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    // Getters for title and releaseYear
    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}

// Collection class for storing movies
class MovieCollection {
    private int count;
    private Movie[] movies;

    // Constructor
    public MovieCollection(int capacity) {
        movies = new Movie[capacity];
        count = 0;
    }

    // Method to add new movies
    public void add(Movie movie) {
        if (count < movies.length) {
            movies[count] = movie;
            count++;
        }
    }

    // Method to print detailed information about a movie at index i
    public void printOne(int i) {
        if (i >= 0 && i < count) {
            System.out.println("Title: " + movies[i].getTitle() + ", Release Year: " + movies[i].getReleaseYear());
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to print all movies in the collection
    public void print() {
        for (int i = 0; i < count; i++) {
            printOne(i);
        }
    }

    // Method to search and print movies by title
    public void find(String title) {
        for (int i = 0; i < count; i++) {
            if (movies[i].getTitle().equalsIgnoreCase(title)) {
                printOne(i);
            }
        }
    }

    // Method to perform bubble sort of movies based on release year
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (movies[j].getReleaseYear() > movies[j + 1].getReleaseYear()) {
                    // Swap movies[j] and movies[j + 1]
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }
}

// Main class for user dialogue
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection(100); // Creating a collection with a capacity of 100 movies

        System.out.println("Welcome to the movie database!");
        while (true) {
            System.out.println("Choose an option to proceed:");
            System.out.println("1 - Add a movie");
            System.out.println("2 - Print all movies");
            System.out.println("3 - Sort movies by release year");
            System.out.println("4 - Search movies by title");
            System.out.println("0 - Exit the program");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter movie release year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after nextInt()
                    Movie newMovie = new Movie(title, releaseYear);
                    collection.add(newMovie);
                    break;
                case 2:
                    System.out.println("List of movies:");
                    collection.print();
                    break;
                case 3:
                    collection.sort();
                    System.out.println("Movies sorted by release year.");
                    break;
                case 4:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = scanner.nextLine();
                    System.out.println("Matching movies:");
                    collection.find(searchTitle);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
