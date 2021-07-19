package Chapter4.ch01;

class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + "," +author;
    }
}

public class BookTest {
    public static void main(String[] args) {

        Book book = new Book("데미안", "헤르만 헤세");
        System.out.println(book); //book.toString()이랑 같음 --> toString() 오버라이딩 해서 재정의 가능

        String str = new String("test");
        System.out.println(str);
    }
}
