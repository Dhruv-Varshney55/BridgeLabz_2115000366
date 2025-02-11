import java.util.Scanner;

class Movie{
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList{
    private Movie head, tail;

    public void addAtBeginning(String title, String director, int year, double rating){
        Movie newMovie = new Movie(title, director, year, rating);
        if(head == null){
            head = tail = newMovie;
        }
		else{
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating){
        Movie newMovie = new Movie(title, director, year, rating);
        if(tail == null){
            head = tail = newMovie;
        }
		else{
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position){
        Movie newMovie = new Movie(title, director, year, rating);
        if(position == 1){
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for(int i=1; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp == null){
			return;
		}
        newMovie.next = temp.next;
        if(temp.next != null){
			temp.next.prev = newMovie;
		}
        temp.next = newMovie;
        newMovie.prev = temp;
        if(newMovie.next == null){
			tail = newMovie;
		}
    }

    public void removeByTitle(String title){
        if(head == null){
			return;
		}
        if(head.title.equals(title)){
            head = head.next;
            if(head != null){
				head.prev = null;
			}
            return;
        }
        Movie temp = head;
        while(temp!=null && !temp.title.equals(title)){
            temp = temp.next;
        }
        if(temp == null){
			return;
		}
        if(temp.next != null){
			temp.next.prev = temp.prev;
		}
        if(temp.prev != null){
			temp.prev.next = temp.next;
		}
        if(temp == tail){
			tail = temp.prev;
		}
    }

    public void searchByDirector(String director){
        Movie temp = head;
        boolean found = false;
        while(temp != null){
            if(temp.director.equals(director)){
                System.out.println("Title: " + temp.title + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if(!found){
			System.out.println("No movies found by " + director);
		}
    }

    public void searchByRating(double rating){
        Movie temp = head;
        boolean found = false;
        while(temp != null){
            if(temp.rating == rating){
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if(!found){
			System.out.println("No movies found with rating " + rating);
		}
    }

    public void updateRating(String title, double newRating){
        Movie temp = head;
        while(temp != null){
            if(temp.title.equals(title)){
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void displayForward(){
        Movie temp = head;
        while(temp != null){
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse(){
        Movie temp = tail;
        while(temp != null){
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MovieList movieList = new MovieList();
        while(true){
            System.out.println("\n1. Add Movie at Beginning\n2. Add Movie at End\n3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title\n5. Search by Director\n6. Search by Rating");
            System.out.println("7. Update Movie Rating\n8. Display Movies (Forward)\n9. Display Movies (Reverse)\n10. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    movieList.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    movieList.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter Title, Director, Year, Rating, Position: ");
                    movieList.addAtPosition(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Title to remove: ");
                    movieList.removeByTitle(sc.next());
                    break;
                case 5:
                    System.out.print("Enter Director: ");
                    movieList.searchByDirector(sc.next());
                    break;
                case 6:
                    System.out.print("Enter Rating: ");
                    movieList.searchByRating(sc.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter Title and New Rating: ");
                    movieList.updateRating(sc.next(), sc.nextDouble());
                    break;
                case 8:
                    movieList.displayForward();
                    break;
                case 9:
                    movieList.displayReverse();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}