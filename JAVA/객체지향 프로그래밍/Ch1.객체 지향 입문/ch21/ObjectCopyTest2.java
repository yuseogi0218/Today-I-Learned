package Chapter2.ch21;

public class ObjectCopyTest2 {

    public static void main(String[] args) {
        Book[] library = new Book[5]; // 객체 자료형
        Book[] copyLibrary = new Book[5];

        library[0] =  new Book("태백산맥1", "조정래");
        library[1] =  new Book("태백산맥2", "조정래");
        library[2] =  new Book("태백산맥3", "조정래");
        library[3] =  new Book("태백산맥4", "조정래");
        library[4] =  new Book("태백산맥5", "조정래");

        // 깊은 복사 - 객체 배열의 요소인 각 객체가 가리키는 주소가 원본 과 다름.
        copyLibrary[0] = new Book();
        copyLibrary[1] = new Book();
        copyLibrary[2] = new Book();
        copyLibrary[3] = new Book();
        copyLibrary[4] = new Book();

        for (int i = 0; i < library.length; i++) {
            copyLibrary[i].setAuthor(library[i].getAuthor());
            copyLibrary[i].setTitle(library[i].getTitle());

        }

        library[0].setAuthor("박완서");
        library[0].setTitle("나목"); // 객체 주소만 복사되어 copyLibrary 의 내용도 바뀜

        System.out.println("== library ==");
        for (Book book : library) {
            System.out.println(book);
            book.showInfo();
        }

        System.out.println("== copyLibrary ==");
        for (Book book : copyLibrary) {
            System.out.println(book);
            book.showInfo();
        }

    }
}
