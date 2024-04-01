import other.Input;
import type.Role;
import user.Book;
import user.BookService;
import user.User;
import user.UserService;

public class Frontend {
    static User curUser = new User();
    static Book[] books ;
    static UserService userService = new UserService(20);
    static BookService bookService = new BookService(30);

    public static void main(String[] args) {
        System.out.println("Welcome is our Library");
        while (true){
            menu();
        switch (Input.inputInt("Choose")){
            case 1 -> login();
            case 2 -> singUp();
            case 0 -> {
                System.out.println("Bye bye 👋 ");
                return;
            }default -> System.out.println("Wrong option, Try again");
        }
        }
    }

    private static void login() {
    String username = Input.inputStr("Username");
    String password = Input.inputStr("Password");
    curUser = userService.login(username,password);
    if (curUser == null){
        System.out.println("Name or Password Wrong❌");
        return;
    }else if(curUser.getRole().equals(Role.ADMIN)){
        adminProfile();
    } else{
        userProfile();
        }
    }

    private static void userProfile() {
        System.out.println(curUser+
        "=======================================");
        System.out.println("\n User  Menu\n");
    }

    private static void adminProfile() {
        System.out.println(curUser);
        while (true) {
            System.out.println("\nAdmin Menu\n");
            System.out.println("""
                    1. Show Books
                    2. Add book
                    3. Delete book
                    4. Update Book
                    5. Show Users
                    0. Back
                    """);
            int n = Input.inputInt("Choose");
            switch (n) {
                case 1 -> showBooks();
                case 2 -> addBook();
                case 3 -> deleteBook();
                case 4 -> updateBook();
                case 5 -> showUsers();
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nWrong Option, Try again");
            }
        }
    }

    private static void showUsers() {
        System.out.println(userService.showUserList());
        int ind  = Input.inputInt("Choose")-1;
        if (ind >=0 && ind < userService.getCountOfUser()){
            System.out.println(userService.getUsers(ind));
        }else {
            System.out.println("Wrong option, Try Again");
        }
    }

    private static void updateBook() {
        showBookList();
        int ind = Input.inputInt("Select")-1;
        Book book = bookService.getBooks(ind);
        System.out.println("""
                1. Name
                2. Author
                3. Count
                0. Back
                """);
        switch (Input.inputInt("Choose: ")){
            case 1 -> {
                String name = Input.inputStr("New Name");
                book.setName(name);
            }
            case 2 -> {
                String author = Input.inputStr("New Author");
                book.setAuthor(author);
            }
            case 3 -> {
                int count  =Input.inputInt("New Count");
                book.setCount(count);
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Wrong option, Try again");
        }

    }

    private static void deleteBook() {
        showBookList();
        int ind = Input.inputInt("Choose")-1;
        if (ind >= 0 && ind < bookService.getCountBook()){
            String hint = bookService.deleteBook(ind);
            System.out.println("Delete");
        }else if (bookService.getCountBook()==0){
            System.out.println("Data base is Empty");
        }else {
            System.out.println("Wrong choice ❌");
        }
    }

    private static void addBook() {
        String name = Input.inputStr("Name");
        String author = Input.inputStr("Author");
        int count = Input.inputInt("count");
        String book = bookService.addBook(name,author,count);
        System.out.println(book);
    }

    private static void showBooks() {
        showBookList();
        int ind = Input.inputInt("Choose")-1;
        if (ind >= 0 && ind < bookService.getCountBook()){
            System.out.println(bookService.getBooks(ind));
        }else {
            System.out.println("Wrong choice ❌");
        }


    }
    private static void showBookList(){
        System.out.println(bookService.showBookList());
    }

    private static void singUp() {
        String name = Input.inputStr("Name");
        String username = Input.inputStr("Username");
        String password = Input.inputStr("Password");
        String hint  = userService.signUp(name,username,password);
        System.out.println(hint);
    }

    public static void menu(){
        System.out.println("""
                
                1. Login
                2. Sign Up
                0. Exit
                
                """);
    }
}